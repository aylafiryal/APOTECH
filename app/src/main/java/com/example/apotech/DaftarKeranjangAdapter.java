package com.example.apotech;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarKeranjangAdapter extends RecyclerView.Adapter<DaftarKeranjangAdapter.DaftarKeranjangViewHolder> {

    private Context context;
    private ArrayList listKeranjang_namaObat, listKeranjang_hargaObat, listKeranjang_idAkun;
    private ArrayList position;
    private Pesanan psn;


    DaftarKeranjangAdapter(Context context, ArrayList listKeranjang_namaObat, ArrayList listKeranjang_hargaObat, ArrayList listKeranjang_idAkun){
        this.context = context;
        this.listKeranjang_namaObat = listKeranjang_namaObat;
        this.listKeranjang_hargaObat = listKeranjang_hargaObat;
        this.listKeranjang_idAkun = listKeranjang_idAkun;
        psn = new Pesanan();
    }


    @NonNull
    @Override
    public DaftarKeranjangAdapter.DaftarKeranjangViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.daftar_keranjang_obat, parent, false);
        return new DaftarKeranjangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarKeranjangAdapter.DaftarKeranjangViewHolder holder, int position) {
        holder.keranjang_namaObat.setText(String.valueOf(listKeranjang_namaObat.get(position)));
        holder.keranjang_hargaObat.setText(String.valueOf(listKeranjang_hargaObat.get(position)));
    }

    @Override
    public int getItemCount() {
        return listKeranjang_idAkun.size();
    }

    public class DaftarKeranjangViewHolder extends RecyclerView.ViewHolder{

        TextView keranjang_namaObat, keranjang_hargaObat, keranjang_jumlahItem;

        public DaftarKeranjangViewHolder(@NonNull View itemView) {
            super(itemView);
            keranjang_namaObat = itemView.findViewById(R.id.tv_nama_produk_obat);
            keranjang_hargaObat = itemView.findViewById(R.id.tv_jumlah_pembayaran);
        }
    }
}
