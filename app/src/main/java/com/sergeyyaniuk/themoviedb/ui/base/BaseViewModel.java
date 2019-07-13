package com.sergeyyaniuk.themoviedb.ui.base;

import androidx.lifecycle.ViewModel;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    private final MoviesDataSource dataSource;

    private CompositeDisposable compositeDisposable;

    public BaseViewModel(MoviesDataSource dataSource) {
        this.dataSource = dataSource;
        compositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    public MoviesDataSource getDataSource() {
        return dataSource;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
