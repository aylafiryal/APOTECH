package com.example.apotech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHelper = new DatabaseHelper(this);
        boolean insert = databaseHelper.insertObat("Paracetamol", "Kimiafarma", "12 Mei 2022", 20000, 50);
        if(insert == true){
            Toast.makeText(getApplicationContext(), "Data sudah masuk", Toast.LENGTH_SHORT).show();
        }
    }


}