package com.sergeyyaniuk.themoviedb.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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
