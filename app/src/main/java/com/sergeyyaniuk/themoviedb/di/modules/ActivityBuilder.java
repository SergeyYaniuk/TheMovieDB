package com.sergeyyaniuk.themoviedb.di.modules;

import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailActivity;
import com.sergeyyaniuk.themoviedb.ui.movieList.MovieListActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {
            PopularFragmentProvider.class,
            SearchFragmentProvider.class})
    abstract MovieListActivity bindMovieList();

    @ContributesAndroidInjector(modules = {
            MovieDetailFragmentProvider.class})
    abstract MovieDetailActivity bindMovieDetail();
}
