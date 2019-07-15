package com.sergeyyaniuk.themoviedb.ui.base;

import androidx.lifecycle.ViewModel;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {

    private CompositeDisposable compositeDisposable;

    public BaseViewModel() {
        compositeDisposable = new CompositeDisposable();
    }

    public CompositeDisposable getCompositeDisposable() {
        return compositeDisposable;
    }

    @Override
    protected void onCleared() {
        compositeDisposable.dispose();
        super.onCleared();
    }
}
