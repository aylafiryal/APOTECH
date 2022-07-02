package com.example.apotech;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PengirimanActivity extends AppCompatActivity {

    Button pengiriman_btnOke, pengiriman_btnRiwayat;
    ApotechDatabaseHelper db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_pengiriman);

        db = new ApotechDatabaseHelper(this);
        db.deleteAllPesanan();

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        pengiriman_btnOke = (Button) findViewById(R.id.btn_oke);
        pengiriman_btnOke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PengirimanActivity.this, UtamaActivity.class));
            }
        });
        pengiriman_btnRiwayat = (Button) findViewById(R.id.btn_riwayat);
        pengiriman_btnRiwayat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PengirimanActivity.this, RiwayatActivity.class));
            }
        });
    }
}



