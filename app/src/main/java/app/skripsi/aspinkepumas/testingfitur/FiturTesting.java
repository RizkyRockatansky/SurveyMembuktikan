package app.skripsi.aspinkepumas.testingfitur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.adapter.PertanyaanAdapter;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiClientDua;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.pertanyaan.DataPertanyaan;
import app.skripsi.aspinkepumas.model.tentang.DataTentang;
import app.skripsi.aspinkepumas.ui.aboutactivity.AboutActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;

public class FiturTesting extends AppCompatActivity {
    ApiInterface apiInterface;
    PertanyaanAdapter adapterPertanyaan;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur_testing);
        recyclerView = findViewById(R.id.recv_pertanyaan);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FiturTesting.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        apiInterface = ApiClientDua.getClient().create(ApiInterface.class);

        Call<ArrayList<DataPertanyaan>> callPertanyaan = apiInterface.PertanyaanResponse();

        callPertanyaan.enqueue(new Callback<ArrayList<DataPertanyaan>>() {
            @Override
            public void onResponse(Call<ArrayList<DataPertanyaan>> call, Response<ArrayList<DataPertanyaan>> response) {
                adapterPertanyaan = new PertanyaanAdapter(response.body());
                recyclerView.setAdapter(adapterPertanyaan);

                if (response.code() == 200) {

                    Log.i("Result_Json", String.valueOf(response.code()));
                }
                for (DataPertanyaan av : response.body()) {
                    Log.i("id_pertanyaan", av.getId_pertanyaan());
                    Log.i("nama_pertanyaan", av.getNama_pertanyaan());
                    Log.i("id_kategori", av.getId_kategori());
                    Log.i("nama_kategori", av.getNama_kategori());


                }


            }

            @Override
            public void onFailure(Call<ArrayList<DataPertanyaan>> call, Throwable t) {

                Log.i("Error", t.toString());

                 }
            });
        }

//        public void RadioButtonClicked(View view){
//        String jawabanHarapan ="";
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()){
//            case R.id.nilai_harapan_1:
//                if (checked)
//                    jawabanHarapan = "1";
//                break;
//            case R.id.nilai_harapan_2:
//                if (checked)
//                    jawabanHarapan = "2";
//                break;
//            case R.id.nilai_harapan_3:
//                if (checked)
//                    jawabanHarapan = "3";
//                break;
//            case R.id.nilai_harapan_4:
//                if (checked)
//                    jawabanHarapan = "4";
//                break;
//            case R.id.nilai_harapan_5:
//                if (checked)
//                    jawabanHarapan = "5";
//                break;
//        }
//        }
    }
