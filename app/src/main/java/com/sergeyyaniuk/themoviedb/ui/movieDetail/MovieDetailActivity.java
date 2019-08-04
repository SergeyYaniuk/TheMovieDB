package com.sergeyyaniuk.themoviedb.ui.movieDetail;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.ui.base.BaseActivity;
import com.sergeyyaniuk.themoviedb.utils.Constants;

public class MovieDetailActivity extends BaseActivity {

    Toolbar toolbar;

    String movieId, movieTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        movieId = getIntent().getStringExtra(Constants.MOVIE_ID);
        movieTitle = getIntent().getStringExtra(Constants.MOVIE_TITLE);
        setupUi();
        showMovieDetailFragment();
    }

    private void setupUi() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(movieTitle);
        toolbar.setTitleTextAppearance(this, R.style.ToolbarTextAppearance);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
    }

    private void showMovieDetailFragment(){
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle arg = new Bundle();
        arg.putString(Constants.MOVIE_ID, movieId);
        movieDetailFragment.setArguments(arg);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment_container, movieDetailFragment);
        transaction.commit();
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
