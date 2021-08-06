package app.skripsi.aspinkepumas.ui.mainactivitymanagement;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.session.SessionManager;
import app.skripsi.aspinkepumas.ui.aboutactivity.AboutActivity;
import app.skripsi.aspinkepumas.ui.grafik.GrafikActivity;
import app.skripsi.aspinkepumas.ui.hasilkuesioner.HasilKuesioner;
import app.skripsi.aspinkepumas.ui.login.LoginActivity;
import app.skripsi.aspinkepumas.ui.login.LoginActivityManagement;
import app.skripsi.aspinkepumas.ui.mainactivity.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivityManagement extends AppCompatActivity {
    SessionManager sessionManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_management);

        sessionManager  = new SessionManager(MainActivityManagement.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        Calendar calendar = Calendar.getInstance();
        String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());

        TextView textViewDate = findViewById(R.id.tv_tanggal);
        textViewDate.setText(currentDate);

        CardView grafik = findViewById(R.id.cv_grafik);
        grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ii = new Intent(getApplicationContext(), GrafikActivity.class);
                startActivity(ii);
            }
        });

        CardView tentang = findViewById(R.id.cv_tentang);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iii = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(iii);
            }
        });

        CardView hasilkuesioner = findViewById(R.id.cv_hasil);
        hasilkuesioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iiii = new Intent(getApplicationContext(), HasilKuesioner.class);
                startActivity(iiii);
            }
        });


        CardView logoutt = findViewById(R.id.cv_logout2);
        logoutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });

    }

    private void moveToLogin() {

        Intent intent = new Intent(MainActivityManagement.this, LoginActivityManagement.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}