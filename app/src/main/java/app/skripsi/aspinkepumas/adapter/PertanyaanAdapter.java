package app.skripsi.aspinkepumas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.model.pertanyaan.DataPertanyaan;

public class PertanyaanAdapter extends RecyclerView.Adapter<PertanyaanAdapter.MyViewHolder> {

    public PertanyaanAdapter(ArrayList<DataPertanyaan> dataPertanyaans) {
        this.dataPertanyaans = dataPertanyaans;
    }

    ArrayList<DataPertanyaan> dataPertanyaans;

    @NonNull
    @Override
    public PertanyaanAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_pertanyaan, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PertanyaanAdapter.MyViewHolder holder, int position) {

        DataPertanyaan dataPertanyaan = dataPertanyaans.get(position);
        holder.idPertanyan.setText(dataPertanyaan.getId_pertanyaan());
        holder.idKategori.setText(dataPertanyaan.getId_kategori());
        holder.namaKategori.setText(dataPertanyaan.getNama_kategori());
        holder.namaPertanyaan.setText(dataPertanyaan.getNama_pertanyaan());
    }

    @Override
    public int getItemCount() {
        return dataPertanyaans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        EditText idPertanyan, idKategori;
        TextView namaPertanyaan , namaKategori;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            idPertanyan = itemView.findViewById(R.id.et_id_perntanyaan);
            idKategori = itemView.findViewById(R.id.et_id_kategori);
            namaPertanyaan = itemView.findViewById(R.id.tv_nama_pertanyaan);
            namaKategori = itemView.findViewById(R.id.tv_nama_kategori);


        }
    }
}
