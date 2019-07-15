package com.sergeyyaniuk.themoviedb.ui.movieList;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;

import javax.inject.Inject;

public class MovieListViewModel extends BaseViewModel {

    MoviesDataSource dataSource;

    @Inject
    public MovieListViewModel(MoviesDataSource dataSource) {
        this.dataSource = dataSource;
    }
}
