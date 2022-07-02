package com.example.apotech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn;
    ApotechDatabaseHelper db;
    Akun pasien;
    Obat obat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        db = new ApotechDatabaseHelper(this);
        pasien = new Akun();
        obat = new Obat();

        db.deleteAllPesanan();
        db.deleteAllAkun();
        db.deleteAllObat();
        db.deleteAllRiwayat();

        // Insert data kategori sakit
        int [] idSakit_array = {1, 2, 3, 4, 5};
        String [] jenisSakit_array = {"COVID", "Demam", "Batuk Pilek", "Pusing", "Letih"};
        for(int i = 0; i < idSakit_array.length; i++){
            db.insert_jenisSakit(idSakit_array[i], jenisSakit_array[i]);
        }

        // Insert data akun pasien
        db.insert_Akun(1, pasien.getNama(), pasien.getAlamat());

        // Insert data obat
        int index_expireDate = 0;
        int index_stok = 0;
        int index_idSakit = 0;
        int iterasi_idSakit = 0;

        for(int i = 0; i < obat.id_obat.length; i++){
            index_expireDate++;
            if(index_expireDate == obat.expire_date.length){
                index_expireDate = 0;
            }
            index_stok++;
            if(index_stok == obat.stok.length){
                index_stok = 0;
            }
            if(iterasi_idSakit == 3){
                index_idSakit++;
                iterasi_idSakit = 0;
            }
            iterasi_idSakit++;
            db.insert_Obat(obat.getId_obat(i), obat.getNama_obat(i), obat.getId_sakit(index_idSakit), obat.getFarmasi(i), obat.getExpire_date(index_expireDate), obat.getHarga(i), obat.getStok(index_stok));
        }

        btn = (Button) findViewById(R.id.tombolNext);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, UtamaActivity.class));
            }
        });

        db.close();

    }
}