package com.example.apotech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //private DatabaseHelper databaseHelper;
    ApotechDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new ApotechDatabaseHelper(this);

        /*databaseHelper = new DatabaseHelper(this);
        boolean insert = databaseHelper.insertObat(1,"Paracetamol", "Kimiafarma", "12 Mei 2022", 20000, 50);
        if(insert == true){
            Toast.makeText(getApplicationContext(), "Data sudah masuk", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Data gagal masuk", Toast.LENGTH_SHORT).show();
        }*/
    }


}