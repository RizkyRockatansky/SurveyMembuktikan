package app.skripsi.aspinkepumas.api;


import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import app.skripsi.aspinkepumas.model.histori.HistoriData;
import app.skripsi.aspinkepumas.model.inserttesting.DataInsertTesting;
import app.skripsi.aspinkepumas.model.kuisioner.DataKuisioner;
import app.skripsi.aspinkepumas.model.login.Login;
import app.skripsi.aspinkepumas.model.login.LoginAdmin;
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
//            @Field("role") int role

    );
    @GET("login/tentang.php")
    Call<ArrayList<DataTentang>>TentangResponse(
//            @Field("id_tentang") String id_tentang
    );

    //Fetch Soal From database

    @GET("login/kuisioner.php")
    Call<ArrayList<DataPertanyaan>>PertanyaanResponse(

    );

    @FormUrlEncoded
    @POST("login/loginadmin.php")
    Call<LoginAdmin>LoginAdminResponse(
            @Field("email") String email,
            @Field("password") String password
    );


    //testtambahdata

    @FormUrlEncoded
    @POST("login/crud.php")
    Call<DataInsertTesting>InsertResponse(
            @Field("id_mahasiswa") String id_mahasiswa,
            @Field("id_periode") String id_periode,
            @Field("id_kuis") String id_kuis,
            @Field("jawaban_presepsi") String jawaban_presepsi,
            @Field("jawaban_harapan") String jawaban_harapan



            );
        @FormUrlEncoded
    @POST("login/history.php")
    Call<List<HistoriData>> HistoriResponse(
            @Field("id_mhs") String id_mhs
        );




}
