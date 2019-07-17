package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieList.PopularMoviesFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class PopularFragmentProvider {

    @ContributesAndroidInjector(modules = PopularFragmentModule.class)
    abstract PopularMoviesFragment popularMoviesFragment();
}
