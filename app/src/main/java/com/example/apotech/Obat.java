package com.example.apotech;

public class Obat {
    int id_obat, harga, stok;
    String nama_obat, farmasi, expire_date;

    public Obat(){

    }

    public Obat(int harga, int stok, String nama_obat, String farmasi, String expire_date) {
        this.harga = harga;
        this.stok = stok;
        this.nama_obat = nama_obat;
        this.farmasi = farmasi;
        this.expire_date = expire_date;
    }

    public Obat(int id_obat, int harga, int stok, String nama_obat, String farmasi, String expire_date) {
        this.id_obat = id_obat;
        this.harga = harga;
        this.stok = stok;
        this.nama_obat = nama_obat;
        this.farmasi = farmasi;
        this.expire_date = expire_date;
    }

    public void setId_obat(int id_obat) {
        this.id_obat = id_obat;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public void setNama_obat(String nama_obat) {
        this.nama_obat = nama_obat;
    }

    public void setFarmasi(String farmasi) {
        this.farmasi = farmasi;
    }

    public void setExpire_date(String expire_date) {
        this.expire_date = expire_date;
    }

    public int getId_obat() {
        return id_obat;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public String getNama_obat() {
        return nama_obat;
    }

    public String getFarmasi() {
        return farmasi;
    }

    public String getExpire_date() {
        return expire_date;
    }
}
