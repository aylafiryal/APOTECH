package com.example.apotech;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PesananActivity extends AppCompatActivity {

    RecyclerView rv;
    ApotechDatabaseHelper db;
    Button btn_bayar;

    // Akun
    ArrayList<String> pesanan_namaPembeli, pesanan_alamatPembeli;
    ArrayList<Integer> pesanan_idAkun;
    TextView tv_namaPembeli, tv_alamatPembeli, tv_totalBayar;
    int total;

    // Pesanan
    ArrayList<String> pesanan2_namaObat;
    ArrayList<Integer> pesanan2_hargaObat, pesanan2_id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_pesanan);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        db = new ApotechDatabaseHelper(PesananActivity.this);

        // Akun
        pesanan_idAkun = new ArrayList<>();
        pesanan_namaPembeli = new ArrayList<>();
        pesanan_alamatPembeli = new ArrayList<>();
        displayAkun();

        // Pesanan
        pesanan2_namaObat = new ArrayList<>();
        pesanan2_hargaObat = new ArrayList<>();
        pesanan2_id = new ArrayList<>();
        displayPesananObat();
        total(pesanan2_hargaObat);

        rv = findViewById(R.id.rv_pesanan_obat);
        DaftarPesananAdapter adapter = new DaftarPesananAdapter(this, pesanan2_namaObat, pesanan2_hargaObat, pesanan2_id);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        btn_bayar = (Button) findViewById(R.id.tombol_bayar);
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.insert_Riwayat(pesanan2_namaObat, pesanan2_hargaObat);
                db.close();
                startActivity(new Intent(PesananActivity.this, PengirimanActivity.class));
            }
        });

        tv_namaPembeli = (TextView) findViewById(R.id.Nama_Pembeli);
        tv_alamatPembeli = (TextView) findViewById(R.id.tv_alamat_pembeli);
        tv_totalBayar = (TextView) findViewById(R.id.Total_biaya_pesanan);

        for (int position = 0; position < pesanan_idAkun.size(); position++){
            tv_namaPembeli.setText(pesanan_namaPembeli.get(position));
            tv_alamatPembeli.setText(pesanan_alamatPembeli.get(position));
        }
        tv_totalBayar.setText(String.valueOf(total));
    }

    // this event will enable the back
    // function to the button on press
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    void displayAkun(){
        Cursor cursor = db.readAkun();
        if(cursor.getCount() == 0){

        } else {
            while (cursor.moveToNext()){
                pesanan_idAkun.add(cursor.getInt(0));
                pesanan_namaPembeli.add(cursor.getString(1));
                pesanan_alamatPembeli.add(cursor.getString(2));
            }
            cursor.close();
        }
    }

    void total(ArrayList<Integer> harga){
        for (int i = 0; i < harga.size(); i++){
            total = total + harga.get(i);
        }
        total = total + 9000;
    }

    void displayPesananObat(){
        Cursor cursor = db.readPesanan();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                pesanan2_id.add(cursor.getInt(0));
                pesanan2_namaObat.add(cursor.getString(1));
                pesanan2_hargaObat.add(cursor.getInt(2));
            }
            cursor.close();
        }
    }
}
