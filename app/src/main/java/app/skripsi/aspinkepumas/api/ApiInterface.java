package app.skripsi.aspinkepumas.api;


import app.skripsi.aspinkepumas.model.login.Login;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("login/login.php")
    Call<Login> LoginResponse(
            @Field("nim") String nim,
            @Field("password") String password

    );
}
