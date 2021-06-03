package app.skripsi.aspinkepumas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import app.skripsi.aspinkepumas.session.SessionManager;
import app.skripsi.aspinkepumas.ui.aboutactivity.AboutActivity;
import app.skripsi.aspinkepumas.ui.grafik.GrafikActivity;
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