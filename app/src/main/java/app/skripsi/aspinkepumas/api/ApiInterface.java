package app.skripsi.aspinkepumas.api;


import android.widget.ListView;

import java.util.ArrayList;

import app.skripsi.aspinkepumas.model.kuisioner.DataKuisioner;
import app.skripsi.aspinkepumas.model.login.Login;
import app.skripsi.aspinkepumas.model.pertanyaan.DataPertanyaan;
import app.skripsi.aspinkepumas.model.tentang.DataTentang;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login/login.php")
    Call<Login> LoginResponse(
            @Field("nim") String nim,
            @Field("password") String password

    );
    @GET("login/tentang.php")
    Call<ArrayList<DataTentang>>TentangResponse(
//            @Field("id_tentang") String id_tentang
    );

    //Fetch Soal From database

    @GET("login/pertanyaan.php")
    Call<ArrayList<DataPertanyaan>>PertanyaanResponse(

    );

    //Input Soal


}
