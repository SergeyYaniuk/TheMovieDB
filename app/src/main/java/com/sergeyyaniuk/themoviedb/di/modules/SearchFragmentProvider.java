package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieList.SearchMoviesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class SearchFragmentProvider {

    @ContributesAndroidInjector(modules = SearchFragmentModule.class)
    abstract SearchMoviesFragment searchMoviesFragment();
}
