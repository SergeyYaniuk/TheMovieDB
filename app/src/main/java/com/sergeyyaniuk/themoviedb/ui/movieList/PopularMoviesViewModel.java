package com.sergeyyaniuk.themoviedb.ui.movieList;

import android.arch.lifecycle.MutableLiveData;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class PopularMoviesViewModel extends BaseViewModel {

    private final MutableLiveData<List<Movie>> popularMovies = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isDataLoadingError = new MutableLiveData<>();

    public PopularMoviesViewModel(MoviesDataSource dataSource) {
        super(dataSource);
    }

    public void loadPopularMovies(int page, boolean isNetwork){
        if (isNetwork){
            getCompositeDisposable().add(getDataSource()
                    .getPopularMoviesRemotely(page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(paginatedResponse -> {
                        savePopularToDatabase(paginatedResponse.getMovies());
                        popularMovies.postValue(paginatedResponse.getMovies());
                    }, throwable -> isDataLoadingError.postValue(true)));
        } else {
            getCompositeDisposable().add(getDataSource()
                    .getPopularMoviesLocally()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            popularMovies::setValue,
                            throwable -> isDataLoadingError.postValue(true)));
        }
    }

    private void savePopularToDatabase(List<Movie> movies){
        getCompositeDisposable().add(getDataSource()
                .saveMovieListLocally(movies)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public MutableLiveData<List<Movie>> getPopularMovies() {
        return popularMovies;
    }

    public MutableLiveData<Boolean> getIsDataLoadingError() {
        return isDataLoadingError;
    }
}
