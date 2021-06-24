package app.skripsi.aspinkepumas.ui.splashscreen;

import androidx.appcompat.app.AppCompatActivity;
import app.skripsi.aspinkepumas.ui.mainactivity.MainActivity;
import app.skripsi.aspinkepumas.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends AppCompatActivity {
    private int time_loading = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        }, time_loading);
    }
}