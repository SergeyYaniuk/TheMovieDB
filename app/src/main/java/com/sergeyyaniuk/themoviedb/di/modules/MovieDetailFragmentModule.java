package com.sergeyyaniuk.themoviedb.di.modules;

import androidx.lifecycle.ViewModelProvider;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailViewModel;
import com.sergeyyaniuk.themoviedb.utils.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class MovieDetailFragmentModule {

    @Provides
    MovieDetailViewModel provideMovieDetailViewModel(MoviesDataSource moviesDataSource){
        return new MovieDetailViewModel(moviesDataSource);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(MovieDetailViewModel viewModel){
        return new ViewModelFactory<>(viewModel);
    }
}
