package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class DetailFragmentProvider {

    @ContributesAndroidInjector
    abstract MovieDetailFragment provideMovieDetailFragment();
}
