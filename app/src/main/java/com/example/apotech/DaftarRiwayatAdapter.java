package com.example.apotech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarRiwayatAdapter extends RecyclerView.Adapter<DaftarRiwayatAdapter.DaftarRiwayatViewHolder>{

    private Context context;
    private ArrayList listRiwayat_namaObat, listRiwayat_hargaObat;


    DaftarRiwayatAdapter(Context context, ArrayList listRiwayat_namaObat, ArrayList listRiwayat_hargaObat){
        this.context = context;
        this.listRiwayat_namaObat = listRiwayat_namaObat;
        this.listRiwayat_hargaObat = listRiwayat_hargaObat;
    }

    @NonNull
    @Override
    public DaftarRiwayatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.daftar_riwayat, parent, false);
        return new DaftarRiwayatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarRiwayatViewHolder holder, int position) {
        holder.keranjang_namaObat.setText(String.valueOf(listRiwayat_namaObat.get(position)));
        holder.keranjang_hargaObat.setText(String.valueOf(listRiwayat_hargaObat.get(position)));
    }

    @Override
    public int getItemCount() {
        return listRiwayat_namaObat.size();
    }

    public class DaftarRiwayatViewHolder extends RecyclerView.ViewHolder {

        TextView keranjang_namaObat, keranjang_hargaObat, keranjang_jumlahItem;

        public DaftarRiwayatViewHolder(@NonNull View itemView) {
            super(itemView);
            keranjang_namaObat = itemView.findViewById(R.id.tv_nama_obat_pesanan);
            keranjang_hargaObat = itemView.findViewById(R.id.tv_harga_obat_pesanan);
        }
    }
}
