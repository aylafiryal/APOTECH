package com.example.apotech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarPesananAdapter extends RecyclerView.Adapter<DaftarPesananAdapter.DaftarPesananViewHolder> {

    private Context context;
    private ArrayList listPesanan_namaObat, listPesanan_hargaObat, listPesanan_id;

    DaftarPesananAdapter (Context context, ArrayList listPesanan_namaObat, ArrayList listPesanan_hargaObat, ArrayList listPesanan_id){
        this.context = context;
        this.listPesanan_namaObat = listPesanan_namaObat;
        this.listPesanan_hargaObat = listPesanan_hargaObat;
        this.listPesanan_id = listPesanan_id;
    }

    @NonNull
    @Override
    public DaftarPesananViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.daftar_pesanan_obat, parent, false);
        return new DaftarPesananViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarPesananViewHolder holder, int position) {
        holder.pesanan_namaObat.setText(String.valueOf(listPesanan_namaObat.get(position)));
        holder.pesanan_hargaObat.setText(String.valueOf(listPesanan_hargaObat.get(position)));
    }

    @Override
    public int getItemCount() {
        return listPesanan_id.size();
    }

    public class DaftarPesananViewHolder extends RecyclerView.ViewHolder {

        TextView pesanan_namaObat, pesanan_hargaObat, pesanan_banyakObat, pesanan_totalbiaya;

        public DaftarPesananViewHolder(@NonNull View itemView) {
            super(itemView);
            pesanan_namaObat = itemView.findViewById(R.id.tv_nama_obat_pesanan);
            pesanan_hargaObat = itemView.findViewById(R.id.tv_harga_obat_pesanan);
        }
    }
}
