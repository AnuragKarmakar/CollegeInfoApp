package com.anurag.college_information.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.anurag.college_information.R;

public class SplashScreenActivity extends AppCompatActivity {

    String goal = null;
    ImageView SplashImg;
    TextView SplashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        setTheme(R.style.Splash);

        SplashImg = findViewById(R.id.ivSplash);
        SplashText = findViewById(R.id.tvSplash);

        SplashImg.animate().translationY(-1600).setDuration(1000).setStartDelay(2000);
        SplashText.animate().translationY(1600).setDuration(1000).setStartDelay(2000);



         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(getApplicationContext(), CareerGoalActivity.class);
                startActivity(i);
                finish();

            }
        }, 3000);
    }

}