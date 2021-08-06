package app.skripsi.aspinkepumas.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import app.skripsi.aspinkepumas.ui.mainactivity.MainActivity;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.login.DataLogin;
import app.skripsi.aspinkepumas.model.login.Login;
import app.skripsi.aspinkepumas.session.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity  implements View.OnClickListener {

    private CheckBox ShowPass;
    EditText nimLogin, passLogin;
    private Spinner sp;
    TextView btnlogin;
    private ProgressDialog pd;
    ProgressDialog progressDialog;

    String loginnim, loginpassword, loginrole;
    ApiInterface apiInterface;
    SessionManager sessionManager;
    private int status = 0;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //initials
        nimLogin = findViewById(R.id.loginnim);
        passLogin = findViewById(R.id.loginpass);
        ShowPass = findViewById(R.id.showPass);
        btnlogin = findViewById(R.id.login_btn);

        ShowPass.setOnClickListener(this);

        //progressdialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Silakan Tunggu....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        //this

        btnlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn:
                loginnim = nimLogin.getText().toString();
                loginpassword = passLogin.getText().toString();
                login(loginnim,loginpassword);
                break;

            case R.id.showPass:
                showpass();
                break;
        }

    }

    private void showpass() {
        if(ShowPass.isChecked()){
            //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
            passLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            //Jika tidak, maka password akan di sembuyikan
            passLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }

    }

    private void login(String loginnim, String loginpassword) {

        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<Login> loginCall = apiInterface.LoginResponse(loginnim, loginpassword);
        loginCall.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()){
                    progressDialog.dismiss();

                    sessionManager = new SessionManager(LoginActivity.this);
                    DataLogin dataLogin = response.body().getDataLogin();
                    sessionManager.createLoginSession(dataLogin);

                    Toast.makeText(LoginActivity.this, response.body().getDataLogin().getNama(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivity.this,t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}