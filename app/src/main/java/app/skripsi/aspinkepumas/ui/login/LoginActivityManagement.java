package app.skripsi.aspinkepumas.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.api.ApiClient;
import app.skripsi.aspinkepumas.api.ApiInterface;
import app.skripsi.aspinkepumas.model.login.DataLogin;
import app.skripsi.aspinkepumas.model.login.DataLoginAdmin;
import app.skripsi.aspinkepumas.model.login.LoginAdmin;
import app.skripsi.aspinkepumas.session.SessionManager;
import app.skripsi.aspinkepumas.ui.mainactivity.MainActivity;
import app.skripsi.aspinkepumas.ui.mainactivitymanagement.MainActivityManagement;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivityManagement extends AppCompatActivity implements View.OnClickListener {
    private CheckBox ShowPass;
    EditText EmailLogin, PasswordLogin;
    TextView btn_login;
    ProgressDialog progressDialog;
    SessionManager sessionManager;
    String LoginEMail, LoginPassword;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_management);

        EmailLogin = findViewById(R.id.loginemail);
        PasswordLogin = findViewById(R.id.loginpassadmin);
        btn_login = findViewById(R.id.login_btn_admin);
        ShowPass  = findViewById(R.id.showPassadmin);

        ShowPass.setOnClickListener(this);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Silakan Tunggu....");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        btn_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.login_btn_admin:
                LoginEMail = EmailLogin.getText().toString();
                LoginPassword = PasswordLogin.getText().toString();
                loginadmin(LoginEMail,LoginPassword);
                break;


            case R.id.showPass:
                showpass();
                break;


        }

    }

    private void showpass() {

        if(ShowPass.isChecked()){
            //Saat Checkbox dalam keadaan Checked, maka password akan di tampilkan
            PasswordLogin.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }else {
            //Jika tidak, maka password akan di sembuyikan
            PasswordLogin.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    private void loginadmin(String loginEMail, String loginPassword) {
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<LoginAdmin> loginAdminCall = apiInterface.LoginAdminResponse(loginEMail, loginPassword);
        loginAdminCall.enqueue(new Callback<LoginAdmin>() {
            @Override
            public void onResponse(Call<LoginAdmin> call, Response<LoginAdmin> response) {
                if (response.body() != null && response.isSuccessful() && response.body().isStatus()) {
                    progressDialog.dismiss();

                    sessionManager = new SessionManager(LoginActivityManagement.this);
                    DataLoginAdmin dataLoginAdmin = response.body().getDataLogin2();
                    sessionManager.createLoginAdminSession(dataLoginAdmin);



                    Toast.makeText(LoginActivityManagement.this, response.body().getDataLogin2().getNama(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivityManagement.this, MainActivityManagement.class);
                    startActivity(intent);
                    finish();
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(LoginActivityManagement.this, response.body().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginAdmin> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(LoginActivityManagement.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}