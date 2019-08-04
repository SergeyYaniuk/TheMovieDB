package com.sergeyyaniuk.themoviedb.ui.movieDetail;

import android.arch.lifecycle.MutableLiveData;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.ui.base.BaseViewModel;


import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MovieDetailViewModel extends BaseViewModel {

    private final MutableLiveData<MovieDetail> detailMovie = new MutableLiveData<>();

    private final MutableLiveData<Boolean> isDataLoadingError = new MutableLiveData<>();

    @Inject
    public MovieDetailViewModel(MoviesDataSource dataSource) {
        super(dataSource);
    }

    public void loadMovieDetail(String id, boolean isNetwork){
        if (isNetwork){
            getCompositeDisposable().add(getDataSource()
                    .getDetailMovieRemotely(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(movieDetail -> {
                        saveMovieDetail(movieDetail);
                        detailMovie.postValue(movieDetail);},
                            throwable -> isDataLoadingError.setValue(true)));
        } else {
            int movieId = Integer.valueOf(id);
            getCompositeDisposable().add(getDataSource()
                    .getDetailMovieLocally(movieId)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(detailMovie::postValue,
                            throwable -> isDataLoadingError.postValue(true)));
        }
    }

    private void saveMovieDetail(MovieDetail movieDetail){
        getCompositeDisposable().add(getDataSource()
                .saveDetailMovieLocally(movieDetail)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe());
    }

    public MutableLiveData<MovieDetail> getDetailMovie() {
        return detailMovie;
    }

    public MutableLiveData<Boolean> getIsDataLoadingError() {
        return isDataLoadingError;
    }
}
