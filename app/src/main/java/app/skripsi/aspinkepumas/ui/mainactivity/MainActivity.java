package app.skripsi.aspinkepumas.ui.mainactivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import app.skripsi.aspinkepumas.R;
import app.skripsi.aspinkepumas.session.SessionManager;
import app.skripsi.aspinkepumas.testingfitur.FiturTesting;
import app.skripsi.aspinkepumas.ui.aboutactivity.AboutActivity;
import app.skripsi.aspinkepumas.ui.grafik.GrafikActivity;
import app.skripsi.aspinkepumas.ui.kuisioner.KuisionerActivity;
import app.skripsi.aspinkepumas.ui.login.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        sessionManager = new SessionManager(MainActivity.this);
        if (!sessionManager.isLoggedIn()){
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

        CardView kuisioner = findViewById(R.id.cv_survey);
        kuisioner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iiii = new Intent(getApplicationContext(), FiturTesting.class);
                startActivity(iiii);
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


        CardView logout = findViewById(R.id.cv_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sessionManager.logoutSession();
                moveToLogin();
            }
        });
    }

    private void moveToLogin() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}