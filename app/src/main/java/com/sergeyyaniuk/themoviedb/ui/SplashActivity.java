package com.sergeyyaniuk.themoviedb.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sergeyyaniuk.themoviedb.MainActivity;

/**
 * Simple activity shows Splash screen on launching
 * In styles is configured background of screen
 *
 **/

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
