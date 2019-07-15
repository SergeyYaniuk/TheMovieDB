package com.sergeyyaniuk.themoviedb.ui.movieDetail;

import android.os.Bundle;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.ui.base.BaseActivity;

public class MovieDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
    }
}
