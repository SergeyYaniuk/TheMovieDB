package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailActivity;
import com.sergeyyaniuk.themoviedb.ui.movieList.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityModule {

    @ContributesAndroidInjector(modules = {
            FavoritesFragmentProvider.class,
            SearchFragmentProvider.class})
    abstract MovieListActivity bindMovieList();

    @ContributesAndroidInjector(modules = {
            DetailFragmentProvider.class})
    abstract MovieDetailActivity bindMovieDetail();
}
