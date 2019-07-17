package com.sergeyyaniuk.themoviedb.ui.base;


import android.arch.lifecycle.ViewModel;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;

    private MoviesDataSource dataSource;

    public BaseViewModel(MoviesDataSource dataSource) {
        this.dataSource = dataSource;
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public MoviesDataSource getDataSource(){
        return dataSource;
    }
}
