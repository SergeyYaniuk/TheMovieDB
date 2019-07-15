package com.sergeyyaniuk.themoviedb.ui.movieDetail;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;

import javax.inject.Inject;

public class MovieDetailViewModel extends BaseViewModel {

    MoviesDataSource dataSource;

    @Inject
    public MovieDetailViewModel(MoviesDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
