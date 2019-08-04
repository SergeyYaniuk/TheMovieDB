package com.sergeyyaniuk.themoviedb.di.modules;


import android.arch.lifecycle.ViewModelProvider;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.movieList.SearchMoviesViewModel;
import com.sergeyyaniuk.themoviedb.utils.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

/** Module for injecting SearchMovies fragment */

@Module
public class SearchFragmentModule {

    @Provides
    SearchMoviesViewModel provideSearchMoviesViewModel(MoviesDataSource moviesDataSource){
        return new SearchMoviesViewModel(moviesDataSource);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(SearchMoviesViewModel viewModel){
        return new ViewModelFactory<>(viewModel);
    }
}
