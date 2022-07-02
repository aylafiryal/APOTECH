package com.example.apotech;

public class Obat {

    int [] foto = {
            R.drawable.apotech1, R.drawable.apotech2, R.drawable.apotech3,
            R.drawable.apotech4, R.drawable.apotech5, R.drawable.apotech6,
            R.drawable.apotech7, R.drawable.apotech8, R.drawable.apotech9,
            R.drawable.apotech10, R.drawable.apotech11, R.drawable.apotech12,
            R.drawable.apotech13, R.drawable.apotech14, R.drawable.apotech15
    };

    int [] id_sakit = {
            1, 2, 3, 4, 5
    };
    int [] id_obat = {
            1, 2, 3,
            4, 5, 6,
            7, 8, 9,
            10, 11, 12,
            13, 14, 15
    };
    String [] nama_obat = {
            "Avigan (Favipiravir)", "Octagam 10%", "Stromectol",
            "Paracetamol", "Aspirin", "Ibuprofen",
            "Benadryl", "Bodrexin Pilek Alergi", "Paramex Flu Batuk",
            "Panadol Extra", "Panadol", "Oskadon",
            "Enervon-C Multivitamin", "Sangobion", "Holisticare Ester C"
    };
    String [] farmasi = {
            "Avigan", "Octapharma Pharmazeutika", "Merck Sharp Dohme",
            "Pfizer Consumer Healthcare", "Bayer", "BASF",
            "Johnson & Johnson", "Tempo Scan Pacific", "Konimex",
            "Sterling", "Tempo Scan Pacific", "Sterling",
            "Darya-Varia", "P&G Health", "Indocare"
    };
    String [] expire_date = {
            "1 April 2024",
            "1 Mei 2024",
            "1 Juni 2024",
            "1 Agustus 2024",
            "1 November 2024",
            "1 Desember 2024"
    };
    int [] harga = {
            22500, 80000, 25000,
            4500, 19000, 24000,
            23500, 1500, 10000,
            11500, 1500, 9500,
            4000, 6000, 30000
    };
    int [] stok = {
            10, 30, 50, 90, 100, 150
    };

    public Obat(){

    }

    public int getId_obat(int i) {
        return id_obat[i];
    }

    public String getNama_obat(int i) {
        return nama_obat[i];
    }

    public String getFarmasi(int i) {
        return farmasi[i];
    }

    public String getExpire_date(int i) {
        return expire_date[i];
    }

    public int getHarga(int i) {
        return harga[i];
    }

    public int getStok(int i) {
        return stok[i];
    }

    public int getId_sakit(int i){
        return id_sakit[i];
    }

    public int getFoto(int i){
        return foto[i];
    }

}