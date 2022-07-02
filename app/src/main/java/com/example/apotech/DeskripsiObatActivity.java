package com.example.apotech;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class DeskripsiObatActivity extends AppCompatActivity {

    Button btn_beliSekarang, btn_keranjang;
    ApotechDatabaseHelper db;
    Akun akun;
    Pesanan pesanan;
    int id_obatDipilih;
    ArrayList<String> namaObatDipilih, farmasiObatDipilih, expireObatDipilih;

    ArrayList<String> obat_expire;
    ArrayList<Integer> id_Obat, id_Obatsakit, obat_harga, obat_stok;

    TextView namaObat_deskripsi, farmasiObat_deskripsi, expireObat_deskripsi;

    ArrayList<Integer> id_keranjang, id_beliSekarang;
    Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_deskripsi_obat);

        id_keranjang = new ArrayList<Integer>();
        id_beliSekarang = new ArrayList<>();
        args = new Bundle();


        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);

        db = new ApotechDatabaseHelper(DeskripsiObatActivity.this);
        id_obatDipilih = (Integer) getIntent().getSerializableExtra("id_obatDipilih");
        namaObatDipilih = new ArrayList<>();
        farmasiObatDipilih = new ArrayList<>();
        expireObatDipilih = new ArrayList<>();

        obat_harga = new ArrayList<>();
        obat_expire = new ArrayList<>();
        id_Obat = new ArrayList<>();
        id_Obatsakit = new ArrayList<>();
        obat_stok = new ArrayList<>();

        pesanan = new Pesanan();

        displayDeskripsiObat();

        namaObat_deskripsi = (TextView) findViewById(R.id.tv_deskripsi_nama_obat);
        farmasiObat_deskripsi = (TextView) findViewById(R.id.tv_deskripsi_farmasi_obat);
        expireObat_deskripsi = (TextView) findViewById(R.id.tv_expire_date);
        namaObat_deskripsi.setText(namaObatDipilih.get(0));
        farmasiObat_deskripsi.setText(farmasiObatDipilih.get(0));
        expireObat_deskripsi.setText(obat_expire.get(0));

        btn_beliSekarang = (Button) findViewById(R.id.btn_beli_sekarang);
        btn_beliSekarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DeskripsiObatActivity.this, PesananActivity.class);
                id_beliSekarang.clear();
                id_beliSekarang.add(id_obatDipilih);
//                args.putSerializable("ARRAYLIST", (Serializable) id_beliSekarang);
//                intent.putExtra("BUNDLE", args);
                db.insert_Pesanan(id_beliSekarang);
                db.close();
                startActivity(intent);
            }
        });

        btn_keranjang = (Button) findViewById(R.id.btn_keranjang);
        btn_keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DeskripsiObatActivity.this, "Dimasukkan ke keranjang!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(DeskripsiObatActivity.this, KeranjangActivity.class);
                id_beliSekarang.add(id_obatDipilih);
                id_keranjang.add(id_obatDipilih);
//                args.putSerializable("ARRAYLIST", (Serializable) id_keranjang);
//                intent.putExtra("BUNDLE", args);
                db.insert_Pesanan(id_keranjang);
                db.close();
            }
        });
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

    void displayDeskripsiObat(){
        Cursor cursor = db.readOneObat(id_obatDipilih);

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                //int id_obat, String nama_obat, int id_sakit, String farmasi, String expire_date, int harga, int stok
                id_Obat.add(cursor.getInt(0));
                namaObatDipilih.add(cursor.getString(1));
                id_Obatsakit.add(cursor.getInt(2));
                farmasiObatDipilih.add(cursor.getString(3));
                obat_expire.add(cursor.getString(4));
                obat_harga.add(cursor.getInt(5));
                obat_stok.add(cursor.getInt(6));
            }
            cursor.close();
        }
    }
}

