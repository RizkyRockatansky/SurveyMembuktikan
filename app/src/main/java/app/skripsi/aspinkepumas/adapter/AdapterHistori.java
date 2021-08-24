package app.skripsi.aspinkepumas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.model.histori.HistoriData;

public class AdapterHistori extends RecyclerView.Adapter<AdapterHistori.RecycleViewAdapter> {

    private Context context;
    private List<HistoriData> historiDatas;
    String Harapan, Persepsi;

    public AdapterHistori(Context context, List<HistoriData> historiDatas) {
        this.context = context;
        this.historiDatas = historiDatas;
    }


    @NonNull
    @Override
    public AdapterHistori.RecycleViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rcv_histori, parent, false);
        return new RecycleViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHistori.RecycleViewAdapter holder, int position) {
        HistoriData historiData = historiDatas.get(position);
        holder.tv_pertanyaan.setText(historiData.getPertanyaan());
        Harapan = historiData.getJawaban_harapan();
        if (Harapan.equals("1")){
            holder.tv_jawabanhar.setText("Sangat Tidak Puas");
        }else if (Harapan.equals("2")){
            holder.tv_jawabanhar.setText("Tidak Puas");
        }else if (Harapan.equals("3")){
            holder.tv_jawabanhar.setText("Cukup Puas");
        }else if (Harapan.equals("4")){
            holder.tv_jawabanhar.setText("Puas");
        }
        else if (Harapan.equals("5")){
            holder.tv_jawabanhar.setText("Sangat  Puas");
        }
        Persepsi = historiData.getJawaban_persepsi();
        if (Persepsi.equals("1")){
            holder.tv_jawabanper.setText("Sangat Tidak Puas");
        }else if (Persepsi.equals("2")){
            holder.tv_jawabanper.setText("Tidak Puas");
        }else if (Persepsi.equals("3")){
            holder.tv_jawabanper.setText("Cukup Puas");
        }else if (Persepsi.equals("4")){
            holder.tv_jawabanper.setText("Puas");
        }
        else if (Persepsi.equals("5")){
            holder.tv_jawabanper.setText("Sangat  Puas");
        }

    }

    @Override
    public int getItemCount() {
        return historiDatas.size();
    }

    public class RecycleViewAdapter extends RecyclerView.ViewHolder  {

        TextView tv_pertanyaan,  tv_jawabanhar, tv_jawabanper;
        CardView cardView;
        public RecycleViewAdapter(@NonNull View itemView ) {
            super(itemView);

            tv_pertanyaan = itemView.findViewById(R.id.tv_hs_pertanyaan);
            tv_jawabanhar = itemView.findViewById(R.id.hsjwbharapan);
            tv_jawabanper = itemView.findViewById(R.id.hsjwbpersepsi);
            cardView = itemView.findViewById(R.id.cv_pertanyaan);

        }

    }



}
