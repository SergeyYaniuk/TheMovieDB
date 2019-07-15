package com.sergeyyaniuk.themoviedb;


import com.sergeyyaniuk.themoviedb.di.DaggerApplicationComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class TheMovieDBApp extends DaggerApplication {


    private static TheMovieDBApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
    }

    public static synchronized TheMovieDBApp getInstance() {
        return instance;
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerApplicationComponent.builder().create(this);
    }
}

