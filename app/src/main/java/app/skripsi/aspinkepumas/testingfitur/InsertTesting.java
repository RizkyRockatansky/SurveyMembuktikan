package app.skripsi.aspinkepumas.testingfitur;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;

import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.inserttesting.DataInsertTesting;
import app.skripsi.aspinkepumas.session.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InsertTesting extends AppCompatActivity {
    EditText idMahasiswa, idPeriode, idKuis, jwbHar, jwbPer;
    ProgressDialog progressDialog;
    SessionManager sessionManager;
    String ID_M;
    ApiInterface apiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_testing);

        idMahasiswa = findViewById(R.id.et_id_mhs);
        idPeriode = findViewById(R.id.et_id_periode);
        idKuis = findViewById(R.id.et_id_kuis);
        jwbHar = findViewById(R.id.et_jawaban_har);
        jwbPer = findViewById(R.id.et_jawaban_per);

        sessionManager = new SessionManager(InsertTesting.this);
        ID_M = sessionManager.getUserDetail().get(SessionManager.ID);



        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Silahkan Tunggu...");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_editor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.save:
                //save
                String id_mhs = idMahasiswa.getText().toString().trim();
                String id_periode = idPeriode.getText().toString().trim();
                String id_kuis = idKuis.getText().toString().trim();
                String jawabanHar = jwbHar.getText().toString().trim();
                String jawabanPer = jwbPer.getText().toString().trim();

                if(id_mhs.isEmpty()){
                    idMahasiswa.setError("Silakan isi bagian ini");
                }else if(id_periode.isEmpty()){
                    idPeriode.setError("SIlakan isi Bagian ini");
                }else if(id_kuis.isEmpty()){
                    idKuis.setError("silahkan ini bagian ini");
                }else if(jawabanHar.isEmpty()){
                    jwbHar.setError("silakan isi bagian ini");
                }else if(jawabanPer.isEmpty()){
                    jwbPer.setError("Silakan isi bagian ini");
                }else {

                    SaveInsert(ID_M ,id_periode,id_kuis,jawabanHar,jawabanPer);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    private void SaveInsert( final String id_mahasiswa, final String id_periode, final String id_kuis, final String jawaban_presepsi, final String jawaban_harapan ) {
        progressDialog.show();

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<DataInsertTesting> call = apiInterface.InsertResponse(id_mahasiswa, id_periode, id_kuis, jawaban_presepsi, jawaban_harapan);

        call.enqueue(new Callback<DataInsertTesting>() {
            @Override
            public void onResponse(@NotNull Call<DataInsertTesting> call, @NotNull Response<DataInsertTesting> response) {

                progressDialog.dismiss();
                if(response.isSuccessful() && response.body() != null){
                 Boolean success = response.body().getSuccess();
                 if (success){
                     Toast.makeText(InsertTesting.this, response.body().getMessage(),
                             Toast.LENGTH_SHORT).show();
                     finish();
                 }else{
                     Toast.makeText(InsertTesting.this, response.body().getMessage(),
                             Toast.LENGTH_SHORT).show();
                 }

                }
            }

            @Override
            public void onFailure(@NotNull Call<DataInsertTesting> call, @NotNull Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(InsertTesting.this, t.getLocalizedMessage(),
                        Toast.LENGTH_SHORT).show();
                finish();

            }
        });


    }
}