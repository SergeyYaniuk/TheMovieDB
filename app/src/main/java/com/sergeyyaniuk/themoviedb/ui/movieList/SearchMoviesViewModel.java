package com.sergeyyaniuk.themoviedb.ui.movieList;

import android.arch.lifecycle.MutableLiveData;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SearchMoviesViewModel extends BaseViewModel {

    private final MutableLiveData<List<Movie>> searchedMovies = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isDataLoadingError = new MutableLiveData<>();

    public SearchMoviesViewModel(MoviesDataSource dataSource) {
        super(dataSource);
    }

    public void loadSearchMovies(String searchString, int page, boolean isNetwork){
        if (isNetwork){
            getCompositeDisposable().add(getDataSource()
                    .getSearchedMoviesRemotely(searchString, page)
                    .debounce(1000, TimeUnit.MILLISECONDS)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(paginatedResponse -> {
                        saveSearchToDatabase(paginatedResponse.getMovies());
                        searchedMovies.postValue(paginatedResponse.getMovies());
                    }, throwable -> isDataLoadingError.postValue(true)));
        } else {
            getCompositeDisposable().add(getDataSource()
                    .getSearchedMoviesLocally(searchString)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(searchedMovies::setValue,
                            throwable -> isDataLoadingError.setValue(true)));
        }
    }

    private void saveSearchToDatabase(List<Movie> movies){
        getCompositeDisposable().add(getDataSource().saveMovieListLocally(movies)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public MutableLiveData<List<Movie>> getSearchedMovies() {
        return searchedMovies;
    }

    public MutableLiveData<Boolean> getIsDataLoadingError() {
        return isDataLoadingError;
    }
}
