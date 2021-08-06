package app.skripsi.aspinkepumas.ui.landingpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.ui.login.LoginActivity;
import app.skripsi.aspinkepumas.ui.login.LoginActivityManagement;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LandingPageLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page_login);

        CardView adminmasuk = findViewById(R.id.cv_login_admin);
        adminmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), LoginActivityManagement.class);
                startActivity(i);
            }
        });

        CardView mahasiswamasuk = findViewById(R.id.cv_login_mahasiswa);
        mahasiswamasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent  ii = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(ii);
            }
        });
    }
}