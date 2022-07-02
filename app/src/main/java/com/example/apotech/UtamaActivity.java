package com.example.apotech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class UtamaActivity extends AppCompatActivity implements DaftarObatAdapter.ClickBeli{

    RecyclerView rv;
    ApotechDatabaseHelper db;
    ArrayList<String> obat_nama, obat_farmasi, obat_expire;
    ArrayList<Integer> id_Obat, id_Obatsakit, obat_harga, obat_stok;
    ArrayList<Integer> id_obatDipilih;
    DaftarObatAdapter daftarObatAdapter;
    ImageView keranjang;
    EditText searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_utama);

        db = new ApotechDatabaseHelper(UtamaActivity.this);
        obat_nama = new ArrayList<>();
        obat_farmasi = new ArrayList<>();
        obat_harga = new ArrayList<>();
        obat_expire = new ArrayList<>();
        id_Obat = new ArrayList<>();
        id_Obatsakit = new ArrayList<>();
        obat_stok = new ArrayList<>();
        id_obatDipilih = new ArrayList<>();

        displayObat();

        rv = findViewById(R.id.rv_daftar_obat);
        daftarObatAdapter = new DaftarObatAdapter(UtamaActivity.this, obat_nama, obat_farmasi, obat_harga, id_Obat, this);
        rv.setAdapter(daftarObatAdapter);
        rv.setLayoutManager(new GridLayoutManager(UtamaActivity.this, 2));
        //rv.setLayoutManager(new LinearLayoutManager(UtamaActivity.this));


        keranjang = (ImageView) findViewById(R.id.iv_keranjang);
        keranjang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UtamaActivity.this, KeranjangActivity.class));
            }
        });

    }

    void displayObat(){
        Cursor cursor = db.readAllObat();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                //int id_obat, String nama_obat, int id_sakit, String farmasi, String expire_date, int harga, int stok
                id_Obat.add(cursor.getInt(0));
                obat_nama.add(cursor.getString(1));
                id_Obatsakit.add(cursor.getInt(2));
                obat_farmasi.add(cursor.getString(3));
                obat_expire.add(cursor.getString(4));
                obat_harga.add(cursor.getInt(5));
                obat_stok.add(cursor.getInt(6));
            }
        }
    }

    @Override
    public void clickBeli(int position) {
        Intent intent = new Intent(this, DeskripsiObatActivity.class);
        position = position + 1;
        intent.putExtra("id_obatDipilih", position);
        startActivity(intent);

        /*Intent intent = new Intent(this,DeskripsiObatActivity.class);
        startActivity(intent);*/
    }
}