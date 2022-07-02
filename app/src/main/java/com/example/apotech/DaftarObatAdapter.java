package com.example.apotech;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DaftarObatAdapter extends RecyclerView.Adapter<DaftarObatAdapter.DaftarObatViewHolder> {

    private Context context;
    private Obat obat = new Obat();
    private ArrayList obat_nama, obat_farmasi, obat_harga, id_obat, foto_obat;
    private ClickBeli clickBeli;
    //private ArrayList<Integer> list_foto = new ArrayList<Integer>();

    DaftarObatAdapter(Context context, ArrayList obat_nama, ArrayList obat_farmasi, ArrayList obat_harga, ArrayList id_obat, ClickBeli clickBeli){
        this.context = context;
        this.obat_nama = obat_nama;
        this.obat_farmasi = obat_farmasi;
        this.obat_harga = obat_harga;
        this.id_obat = id_obat;
        this.clickBeli = clickBeli;
    }

    @NonNull
    @Override
    public DaftarObatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.daftar_obat, parent, false);
        return new DaftarObatViewHolder(view, clickBeli);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarObatViewHolder holder, int position) {
        holder.nama_obat.setText(String.valueOf(obat_nama.get(position)));
        holder.farmasi_obat.setText(String.valueOf(obat_farmasi.get(position)));
        holder.harga_obat.setText(String.valueOf(obat_harga.get(position)));
        //holder.foto_obat.setImageResource(Integer.valueOf(list_foto.get(position)));

    }

    @Override
    public int getItemCount() {
        return obat.id_obat.length;
    }

    public class DaftarObatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView nama_obat, farmasi_obat, harga_obat;
        ImageView foto_obat;
        Button beli_btn;
        ClickBeli clickBeli;

        public DaftarObatViewHolder(@NonNull View itemView, ClickBeli clickBeli) {
            super(itemView);
            nama_obat = itemView.findViewById(R.id.tv_nama_obat);
            farmasi_obat = itemView.findViewById(R.id.tv_farmasi);
            harga_obat = itemView.findViewById(R.id.tv_harga_obat);
            foto_obat = itemView.findViewById(R.id.iv_foto_obat);
            beli_btn = itemView.findViewById(R.id.btn_beli);
            beli_btn.setOnClickListener(this);
            this.clickBeli = clickBeli;

            /*list_foto.add(R.drawable.apotech1);
            list_foto.add(R.drawable.apotech2);
            list_foto.add(R.drawable.apotech3);
            list_foto.add(R.drawable.apotech4);
            list_foto.add(R.drawable.apotech5);
            list_foto.add(R.drawable.apotech6);*/
        }

        @Override
        public void onClick(View view) {
            clickBeli.clickBeli(getAdapterPosition());
        }
    }

    public interface ClickBeli{
        void clickBeli(int position);
    }
}
