package com.example.apotech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class RiwayatActivity extends AppCompatActivity {

    RecyclerView rv;
    ApotechDatabaseHelper db;

    ArrayList<String> riwayat_namaObat;
    ArrayList<Integer> riwayat_hargaObat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_riwayat);

        db = new ApotechDatabaseHelper(RiwayatActivity.this);
        riwayat_namaObat = new ArrayList<>();
        riwayat_hargaObat = new ArrayList<>();
        displayRiwayat();

        rv = findViewById(R.id.rv_daftar_riwayat);
        DaftarRiwayatAdapter adapter = new DaftarRiwayatAdapter(this, riwayat_namaObat, riwayat_hargaObat);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(this));

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
    }

    void displayRiwayat(){
        Cursor cursor = db.readRiwayat();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                //int id_obat, String nama_obat, int id_sakit, String farmasi, String expire_date, int harga, int stok
                riwayat_namaObat.add(cursor.getString(0));
                riwayat_hargaObat.add(cursor.getInt(1));
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