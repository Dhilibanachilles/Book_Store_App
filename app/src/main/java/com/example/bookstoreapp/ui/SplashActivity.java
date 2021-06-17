package com.example.bookstoreapp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstoreapp.R;
import com.example.bookstoreapp.SharedPreferenceHelper;
import com.example.bookstoreapp.ui.authentication.LoginActivity;
import com.example.bookstoreapp.ui.dashboard.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    private boolean isLoggedIn;
    SharedPreferenceHelper sharedPreferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        sharedPreferenceHelper = new SharedPreferenceHelper(this);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams
                .FLAG_FULLSCREEN);

        new Handler().postDelayed(() -> {

            isLoggedIn = sharedPreferenceHelper.getLoggedIn();
            Intent SplashAct;
            if(isLoggedIn) {
                SplashAct = new Intent(SplashActivity.this, HomeActivity.class);
            } else{
                SplashAct = new Intent(SplashActivity.this, LoginActivity.class);
            }
            startActivity(SplashAct);
            finish();
        },4000);
    }
}
