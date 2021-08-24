package app.skripsi.aspinkepumas.ui.aboutactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.adapter.TentangAdapter;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiClientDua;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.tentang.DataTentang;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {


    ApiInterface apiInterface;
    RecyclerView recyclerView;
    TentangAdapter adapter;
//    String id_tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        recyclerView = findViewById(R.id.rcv_tentang);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AboutActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        apiInterface = ApiClientDua.getClient().create(ApiInterface.class);

         Call<ArrayList<DataTentang>> callTentang = apiInterface.TentangResponse();

        callTentang.enqueue(new Callback<ArrayList<DataTentang>>() {
            @Override
            public void onResponse(Call<ArrayList<DataTentang>> call, Response<ArrayList<DataTentang>> response) {

                adapter = new TentangAdapter(response.body());
                recyclerView.setAdapter(adapter);

                if(response.code()==200){
                    Log.i("Rseult_Json", String.valueOf(response.code()));

                }
            for (DataTentang av: response.body()){
//                Log.i("Tentang", av.getJudul());
                Log.i("Deskripsi", av.getDeskripsi());
                Log.i("id", av.getId_tentang());


            }

            }

            @Override
            public void onFailure(Call<ArrayList<DataTentang>> call, Throwable t) {

                Log.i("Errpr_",t.toString());
            }
        });

    }

}