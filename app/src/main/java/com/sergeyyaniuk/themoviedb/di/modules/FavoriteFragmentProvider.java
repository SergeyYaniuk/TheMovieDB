package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieList.FavoriteMoviesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FavoriteFragmentProvider {

    @ContributesAndroidInjector(modules = FavoriteFragmentModule.class)
    abstract FavoriteMoviesFragment favoriteMoviesFragment();
}
