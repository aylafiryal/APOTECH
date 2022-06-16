package com.example.apotech;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "APOTECH.db";

    private static final String TABLE_OBAT = "Obat";


    private static final String KEY_ID = "id";

    private static final String KEY_NamaObat = "Nama_obat";
    private static final String KEY_Farmasi = "Farmasi";
    private static final String KEY_ExpireDate = "Expire_date";
    private static final String KEY_HargaObat = "Harga_obat";
    private static final String KEY_StokObat = "Stok_obat";


    private final Context context;


    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE_OBAT = "CREATE TABLE " + TABLE_OBAT +
                " (" + KEY_ID + " INTEGER PRIMARY KEY, " +
                KEY_NamaObat + " TEXT," +
                KEY_Farmasi + " TEXT," +
                KEY_ExpireDate + " TEXT," +
                KEY_HargaObat + " INTEGER," +
                KEY_StokObat + " INTEGER)";

        db.execSQL(CREATE_TABLE_OBAT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_OBAT);


        // create new tables
        onCreate(db);
    }

    public boolean insertObat(int id, String namaObat, String farmasi, String expireDate, int harga, int stok){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("KEY_ID", id);
        contentValues.put("KEY_NamaObat", namaObat);
        contentValues.put("KEY_Farmasi", farmasi);
        contentValues.put("KEY_ExpireDate", expireDate);
        contentValues.put("KEY_HargaObat", harga);
        contentValues.put("KEY_StokObat", stok);
        long result = db.insert("Obat", null, contentValues);
        if(result == -1){
            return false;
        } else {
            return true;
        }
    }
}
