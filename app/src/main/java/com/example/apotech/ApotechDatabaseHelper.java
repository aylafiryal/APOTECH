package com.example.apotech;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ApotechDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "APOTECHDB.db";
    private static final int DATABASE_VERSION = 1;

    public ApotechDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table Sakit(id_sakit integer primary key, jenis_sakit text, id_obat integer, foreign key (id_obat) references Obat(id_obat))");
        sqLiteDatabase.execSQL("create table Obat(id_obat integer primary key, nama_obat text, id_sakit integer, farmasi text, expire_date text, harga integer, stok integer, foreign key (id_sakit) references Sakit(id_sakit))");
        sqLiteDatabase.execSQL("create table Akun(id_akun integer primary key, nama text, alamat text)");
        sqLiteDatabase.execSQL("create table Pesanan(id_pesanan integer primary key, jumlah_obat integer, id_obat integer, id_akun integer, foreign key (id_obat) references Obat(id_obat), foreign key (id_akun) references Akun(id_akun))");
        sqLiteDatabase.execSQL("create table Transaksi(id_transaksi primary key, jumlah_pesanan integer, tanggal_pembelian text, biaya integer, id_pesanan integer, id_akun integer, foreign key (id_pesanan) references Pesanan(id_pesanan), foreign key (id_akun) references Akun(id_akun))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Sakit");
        sqLiteDatabase.execSQL("drop table if exists Obat");
        sqLiteDatabase.execSQL("drop table if exists Akun");
        sqLiteDatabase.execSQL("drop table if exists Pesanan");
        sqLiteDatabase.execSQL("drop table if exists Transaksi");

    }
}
