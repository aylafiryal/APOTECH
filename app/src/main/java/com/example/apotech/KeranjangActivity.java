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

public class KeranjangActivity extends AppCompatActivity{

    RecyclerView rv;
    ApotechDatabaseHelper db;

    Button keranjang_tombolPesanan, keranjang_tombolTambahKeranjang;
    TextView jumlahItem, totalBayar;
    ArrayList<String> keranjang_namaObat;
    ArrayList<Integer> keranjang_hargaObat, keranjang_idAkun;

//    int keranjang_jumlahItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_keranjang);

        db = new ApotechDatabaseHelper(KeranjangActivity.this);
        keranjang_namaObat = new ArrayList<>();
        keranjang_hargaObat = new ArrayList<>();
        keranjang_idAkun = new ArrayList<>();
        displayPesananObat();
        //keranjang_jumlahItem = keranjang_namaObat.size();

        rv = findViewById(R.id.rv_daftar_keranjang);
        DaftarKeranjangAdapter adapter = new DaftarKeranjangAdapter(this, keranjang_namaObat, keranjang_hargaObat, keranjang_idAkun);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        keranjang_tombolPesanan = (Button) findViewById(R.id.btn_lanjut_pembayaran);
        keranjang_tombolPesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KeranjangActivity.this, PesananActivity.class));
            }
        });

        jumlahItem = (TextView) findViewById(R.id.tv_jumlah_item_obat);
        jumlahItem.setText(String.valueOf(keranjang_namaObat.size()) + " item");
    }

    void displayPesananObat(){
        Cursor cursor = db.readPesanan();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                //int id_obat, String nama_obat, int id_sakit, String farmasi, String expire_date, int harga, int stok
                keranjang_idAkun.add(cursor.getInt(0));
                keranjang_namaObat.add(cursor.getString(1));
                keranjang_hargaObat.add(cursor.getInt(2));
            }
            cursor.close();
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
