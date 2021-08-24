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
import app.skripsi.aspinkepumas.session.SessionManager;
import app.skripsi.aspinkepumas.ui.aboutactivity.AboutActivity;
import app.skripsi.aspinkepumas.ui.mainactivity.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class FiturTesting extends AppCompatActivity {
    View view;
    ApiInterface apiInterface;
    PertanyaanAdapter adapterPertanyaan;
    RecyclerView recyclerView;
    EditText ID_Mahasiswa;
    String id_mahasiswa;
    SessionManager sessionManager;
    RadioButton radioButtonJawabanHarapan, radioButtonJawabanPresepsi;
    RadioGroup radioGroupHarapan, radioGroupPresepsi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitur_testing);

        sessionManager = new SessionManager(FiturTesting.this);
        if(sessionManager.isLoggedIn() == false){
            moveFiturTesting();
        }

        recyclerView = findViewById(R.id.recv_pertanyaan);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(FiturTesting.this);
//        ID_Mahasiswa = findViewById(R.id.et_id_mahasiswa);
//        radioGroupHarapan = findViewById(R.id.rg_harapan);
//        radioGroupPresepsi = findViewById(R.id.rg_kenyataan);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());


//
//        id_mahasiswa = sessionManager.getUserDetail().get(SessionManager.ID);
//        ID_Mahasiswa.setText(id_mahasiswa);

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
                    Log.i("id_kuis", av.getId_pertanyaan());
                    Log.i("pertanyaan", av.getNama_pertanyaan());
//                    Log.i("id_kategori", av.getId_kategori());
                    Log.i("nama_kategori", av.getNama_kategori());
                    Log.i("kode_kuis", av.getKodeKuis());


                }

//                int selectedId = radioGroup.getCheckedRadioButtonId();
//                radioButtonHar1 = (RadioButton) findViewById(selectedId);
//
//                Toast.makeText(getApplicationContext(), radioButtonHar1.getText()
//                ,Toast.LENGTH_LONG);


            }

            @Override
            public void onFailure(Call<ArrayList<DataPertanyaan>> call, Throwable t) {

                Log.i("Error", t.toString());

                 }
            });
        }

    private void moveFiturTesting() {
        Intent intent = new Intent(FiturTesting.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        finish();
    }


//    public void onRadioButtonClicked(View view){
//        boolean checked = ((RadioButton) view).isChecked();
//        switch (view.getId()){
//            case R.id.nilai_harapan_1:
//                if (checked)
//                    break;
//
//            case R.id.nilai_harapan_2:
//                if (checked)
//                    break;
//            case R.id.nilai_harapan_3:
//                if (checked)
//                    break;
//            case R.id.nilai_harapan_4:
//                if (checked)
//                    break;
//            case R.id.nilai_harapan_5:
//                if (checked)
//                    break;
//
//                //harapan
//
//            case R.id.nilai_kenyataan_1:
//                if (checked)
//                    break;
//            case R.id.nilai_kenyataan_2:
//                 if(checked)
//                   break;
//
//            case R.id.nilai_kenyataan_3:
//                if(checked)
//                    break;
//
//            case R.id.nilai_kenyataan_4:
//                if(checked)
//                    break;
//
//            case R.id.nilai_kenyataan_5:
//                if (checked)
//                    break;
//
//            }
        }

