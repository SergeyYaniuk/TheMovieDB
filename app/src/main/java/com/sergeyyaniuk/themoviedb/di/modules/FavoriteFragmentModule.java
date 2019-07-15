package com.sergeyyaniuk.themoviedb.di.modules;

import androidx.lifecycle.ViewModelProvider;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.movieList.MovieListViewModel;
import com.sergeyyaniuk.themoviedb.utils.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class FavoriteFragmentModule {

    @Provides
    MovieListViewModel provideMovieListViewModel(MoviesDataSource moviesDataSource){
        return new MovieListViewModel(moviesDataSource);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(MovieListViewModel viewModel){
        return new ViewModelFactory<>(viewModel);
    }
}
