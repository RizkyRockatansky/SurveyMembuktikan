package app.skripsi.aspinkepumas.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.model.login.DataLogin;
import app.skripsi.aspinkepumas.model.pertanyaan.DataPertanyaan;
import app.skripsi.aspinkepumas.session.SessionManager;

public class PertanyaanAdapter extends RecyclerView.Adapter<PertanyaanAdapter.MyViewHolder> {
//   private List<DataPertanyaan> detailSoalList;
//    private DataLogin mahasiswa;
//    private String date;
//    private List<String> jawaban = new ArrayList<>();
//    private List<String> jawabanHar = new ArrayList<>();
//    private List<String> jawabanPer = new ArrayList<>();
//    SessionManager sessionManager;




    public PertanyaanAdapter(ArrayList<DataPertanyaan> dataPertanyaans) {
        this.dataPertanyaans = dataPertanyaans;
//        this.mahasiswa = mahasiswa;
//        this.date = date;

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
//        holder.idPertanyan.setText(dataPertanyaan.getId_pertanyaan());
        holder.namaKategori.setText(dataPertanyaan.getNama_kategori());
        holder.namaPertanyaan.setText(dataPertanyaan.getNama_pertanyaan());
        holder.kd_soal.setText(dataPertanyaan.getKodeKuis());

//        final int totalsoal = dataPertanyaans.size();
//
////        mahasiswa.set
//
//        holder.rg_presepsi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//                switch (checkedId){
//                    case(R.id.nilai_presepsi_1):
//                        int a = 0;
//                    if(jawabanPer.size()==0) {
//                        jawabanPer.add(detailSoalList.get(position).getKodeKuis());
//                        jawaban.add("1");
//                    }else {
//                        for(int y =0; y < jawaban.size(); y++){
////                            if(!jawaban.get(y).equals(detailSoalList.get(position).getNomer)){
////                                a++;
////                            }else{
////                                a = 0;
////                                jawaban.remove(jawaban.get(y));
////                                jawaban.
////                            }
//                        }
//                    }
//
//                }
//            }
//        });


//       holder.rg_harapan.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//           @Override
//           public void onCheckedChanged(RadioGroup radioGroup, int checkedIde) {
//               switch (checkedIde) {
//                   case (R.id.nilai_harapan_1):
//                       int a = 0;
//                       if (jawabanHar.size() == 0) ;
//                       jawabanPer.add(detailSoalList.get(position).getKodeKuis());
//                       jawaban.add("1");
//
//               }
//           }
//       });

        //radiogroup

//        View.OnClickListener rbClick = new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                    RadioGroup rg = (RadioGroup) view;
//                    int sel = rg.getCheckedRadioButtonId();
//                    RadioButton rb = (RadioButton) view.findViewById(sel);
//                Log.i("DATA====>", rb.getText().toString());
//            }
//        };
//        holder.rg_harapan.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener) rbClick);
//        holder.idmahasiswa.setText(id_mhs);
//        holder.idmahasiswa.setText(dataLogin.getId());
//        holder.idmahasiswa.setText(sessionManager.getUserDetail().get(SessionManager.ID));


    }

    @Override
    public int getItemCount() {
        return dataPertanyaans.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        EditText idPertanyan, idKategori, idmahasiswa;
        TextView namaPertanyaan , namaKategori, kd_soal;
        String id_mhs;
        RadioGroup rg_harapan, rg_presepsi;
        RadioButton rb_harapan1, rb_harapan2, rb_harapan3, rb_harapan4, rb_harapan5;
        RadioButton rb_persepsi1, rb_persepsi2, rb_persepsi3, rb_persepsi4,rb_persepsi5;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

//            idPertanyan = itemView.findViewById(R.id.et_id_perntanyaan);
////            idKategori = itemView.findViewById(R.id.et_id_kategori);
            namaPertanyaan = itemView.findViewById(R.id.tv_nama_pertanyaan);
            namaKategori = itemView.findViewById(R.id.tv_nama_kategori);
            kd_soal = itemView.findViewById(R.id.tv_kode_kuis);
////            idmahasiswa = itemView.findViewById(R.id.edit_id_mahasiswa);
//
//            //radioGroupHArapan
//            rg_harapan = itemView.findViewById(R.id.rgp_harapan);
//            rg_presepsi = itemView.findViewById(R.id.rgp_persepsi);

             //RadioButtonHarapan
//            rb_harapan1 = itemView.findViewById(R.id.nilai_harapan_1);
//            rb_harapan2 = itemView.findViewById(R.id.nilai_harapan_2);
//            rb_harapan3 = itemView.findViewById(R.id.nilai_harapan_3);
//            rb_harapan4 = itemView.findViewById(R.id.nilai_harapan_4);
//            rb_harapan5 = itemView.findViewById(R.id.nilai_harapan_5);
//
//            //RadioButtonPersepsi
//            rb_persepsi1 = itemView.findViewById(R.id.nilai_presepsi_1);
//            rb_persepsi2 = itemView.findViewById(R.id.nilai_presepsi2);
//            rb_persepsi3 = itemView.findViewById(R.id.nilai_presepsi_3);
//            rb_persepsi4 = itemView.findViewById(R.id.nilai_presepsi_4);
//            rb_persepsi5 = itemView.findViewById(R.id.nilai_presepsi_5);





//            id_mhs = sessionManager.getUserDetail().get(SessionManager.ID);


        }
    }
}
