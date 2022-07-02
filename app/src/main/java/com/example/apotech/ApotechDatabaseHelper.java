package com.example.apotech;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ApotechDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "APOTECHDB_14.db";
    private static final int DATABASE_VERSION = 1;

    public ApotechDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Sakit(id_sakit integer primary key, jenis_sakit text)");
        sqLiteDatabase.execSQL("create table Obat(id_obat integer primary key, nama_obat text, id_sakit integer, farmasi text, expire_date text, harga integer, stok integer, foreign key (id_sakit) references Sakit(id_sakit))");
        sqLiteDatabase.execSQL("create table Akun(id_akun integer primary key, nama text, alamat text)");
        sqLiteDatabase.execSQL("create table Pesanan(id_pesanan integer primary key, id_obat integer, id_akun integer, foreign key (id_obat) references Obat(id_obat), foreign key (id_akun) references Akun(id_akun))");
        sqLiteDatabase.execSQL("create table Transaksi(id_transaksi integer primary key, jumlah_pesanan integer, tanggal_pembelian text, biaya integer, id_pesanan integer, id_akun integer, foreign key (id_pesanan) references Pesanan(id_pesanan), foreign key (id_akun) references Akun(id_akun))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Sakit");
        sqLiteDatabase.execSQL("drop table if exists Obat");
        sqLiteDatabase.execSQL("drop table if exists Akun");
        sqLiteDatabase.execSQL("drop table if exists Pesanan");
        sqLiteDatabase.execSQL("drop table if exists Transaksi");
        onCreate(sqLiteDatabase);
    }

    public void insert_jenisSakit(int id_sakit, String jenisSakit){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_sakit", id_sakit);
        contentValues.put("jenis_sakit", jenisSakit);
        long data = db.insert("Sakit", null, contentValues);
    }

    public void insert_Akun(int id_akun, String nama, String alamat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_akun", id_akun);
        contentValues.put("nama", nama);
        contentValues.put("alamat", alamat);
        long data = db.insert("Akun", null, contentValues);
    }

    public void insert_Obat(int id_obat, String nama_obat, int id_sakit, String farmasi, String expire_date, int harga, int stok){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id_obat", id_obat);
        contentValues.put("nama_obat", nama_obat);
        contentValues.put("id_sakit", id_sakit);
        contentValues.put("farmasi", farmasi);
        contentValues.put("expire_date", expire_date);
        contentValues.put("harga", harga);
        contentValues.put("stok", stok);
        long data = db.insert("Obat", null, contentValues);
    }

    public void insert_Pesanan(ArrayList<Integer> id_obat){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        for(int i = 0; i < id_obat.size(); i++){
            contentValues.put("id_obat", id_obat.get(i));
            contentValues.put("id_akun", 1);
        }
        long data = db.insert("Pesanan", null, contentValues);
    }

    Cursor cari_idObat(String nama){
        String query = "SELECT id_obat FROM Obat WHERE nama_obat='"+nama+"'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readPesanan(){
        String query = "SELECT Pesanan.id_akun, Obat.nama_obat, Obat.harga FROM Obat INNER JOIN Pesanan ON Pesanan.id_obat = Obat.id_obat";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAllObat(){
        String query = "SELECT * FROM Obat";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readOneObat(int index){
        String query = "SELECT * FROM Obat WHERE id_obat = " + index;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor readAkun(){
        String query = "SELECT * FROM Akun";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void deleteAllDataPesanan()
    {
        SQLiteDatabase sdb= this.getWritableDatabase();
        sdb.delete("Pesanan", null, null);

    }

    Cursor deleteAllAkun(){
        String query = "DELETE FROM Akun";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    Cursor deleteAllObat(){
        String query = "DELETE FROM Obat";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
}
