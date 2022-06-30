package com.example.apotech;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PesananActivity extends AppCompatActivity {

    Button btn_bayar;
    ApotechDatabaseHelper db;
    ArrayList<String> nama_pembeli, alamat_pembeli;
    ArrayList<Integer> id_pembeli;
    TextView tv_namaPembeli, tv_alamatPembeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_pesanan);

        // calling the action bar
        ActionBar actionBar = getSupportActionBar();
        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        btn_bayar = (Button) findViewById(R.id.tombol_bayar);
        btn_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PesananActivity.this, SelesaiActivity.class));
            }
        });

        db = new ApotechDatabaseHelper(PesananActivity.this);
        id_pembeli = new ArrayList<>();
        nama_pembeli = new ArrayList<>();
        alamat_pembeli = new ArrayList<>();

        displayAkun();

        tv_namaPembeli = (TextView) findViewById(R.id.Nama_Pembeli);
        tv_alamatPembeli = (TextView) findViewById(R.id.tv_alamat_pembeli);

        for (int position = 0; position < id_pembeli.size(); position++){
            tv_namaPembeli.setText(nama_pembeli.get(position));
            tv_alamatPembeli.setText(alamat_pembeli.get(position));
        }

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
                id_pembeli.add(cursor.getInt(0));
                nama_pembeli.add(cursor.getString(1));
                alamat_pembeli.add(cursor.getString(2));
            }
        }
    }
}
