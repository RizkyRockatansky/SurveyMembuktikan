package app.skripsi.aspinkepumas.testingfitur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.adapter.PertanyaanAdapter;
import app.skripsi.aspinkepumas.api.ApiClient;
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


        apiInterface = ApiClient.getClient().create(ApiInterface.class);

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
    }
