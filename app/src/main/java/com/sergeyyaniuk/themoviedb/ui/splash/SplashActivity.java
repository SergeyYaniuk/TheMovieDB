package com.sergeyyaniuk.themoviedb.ui.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.sergeyyaniuk.themoviedb.ui.movieList.MovieListActivity;

/**
 * Simple activity shows Splash screen on launching
 * In styles is configured background of screen
 *
 **/

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        startActivity(new Intent(this, MovieListActivity.class));
        finish();
    }
}
