package com.sergeyyaniuk.themoviedb.ui.movieDetail;

import android.arch.lifecycle.MutableLiveData;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;

import java.util.List;

import javax.inject.Inject;

public class MovieDetailViewModel extends BaseViewModel {

    private final MutableLiveData<List<Movie>> popularMovies = new MutableLiveData<>();

    private final MutableLiveData<List<Movie>> searchedMovies = new MutableLiveData<>();

    private final MutableLiveData<Boolean> dataLoading = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isDataLoadingError = new MutableLiveData<>();

    @Inject
    public MovieDetailViewModel(MoviesDataSource dataSource) {
        super(dataSource);
    }

    public void loadFavoriteMovies(int page){

    }

    public MutableLiveData<List<Movie>> getPopularMovies() {
        return popularMovies;
    }

    public MutableLiveData<List<Movie>> getSearchedMovies() {
        return searchedMovies;
    }

    public MutableLiveData<Boolean> getDataLoading() {
        return dataLoading;
    }

    public MutableLiveData<Boolean> getIsDataLoadingError() {
        return isDataLoadingError;
    }


}
