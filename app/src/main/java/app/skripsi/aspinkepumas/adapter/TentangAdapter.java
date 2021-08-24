package app.skripsi.aspinkepumas.adapter;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.model.tentang.DataTentang;

public class TentangAdapter extends RecyclerView.Adapter<TentangAdapter.MyViewHolder> {

    ArrayList<DataTentang> dataTentangs;

    public TentangAdapter(ArrayList<DataTentang> dataTentangs) {
        this.dataTentangs = dataTentangs;
    }


    @NonNull
    @Override
    public TentangAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_tentang,parent,false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TentangAdapter.MyViewHolder holder, int position) {
       DataTentang dataTentang = dataTentangs.get(position);

//        holder.judul.setText(dataTentang.getJudul());
        holder.deskripsi.setText(dataTentang.getDeskripsi());

    }

    @Override
    public int getItemCount() {
        return dataTentangs.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

//        TextView judul;
        TextView deskripsi;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            judul = itemView.findViewById(R.id.tv_judul);
            deskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
    }
}
