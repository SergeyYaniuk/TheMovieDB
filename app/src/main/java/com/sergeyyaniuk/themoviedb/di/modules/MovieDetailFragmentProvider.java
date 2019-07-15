package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MovieDetailFragmentProvider {

    @ContributesAndroidInjector(modules = MovieDetailFragmentModule.class)
    abstract MovieDetailFragment movieDetailFragment();
}
