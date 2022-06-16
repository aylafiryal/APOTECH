package com.example.apotech;

public class Akun {

    int id_pasien;
    String nama, alamat;

    public Akun(){

    }

    public Akun(String nama, String alamat) {
        this.nama = nama;
        this.alamat = alamat;
    }

    public Akun(int id_pasien, String nama, String alamat) {
        this.id_pasien = id_pasien;
        this.nama = nama;
        this.alamat = alamat;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public int getId_pasien() {
        return id_pasien;
    }

    public String getNama() {
        return nama;
    }

    public String getAlamat() {
        return alamat;
    }
}
