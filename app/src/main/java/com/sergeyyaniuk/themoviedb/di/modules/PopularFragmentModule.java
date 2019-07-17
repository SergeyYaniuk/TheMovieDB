package com.sergeyyaniuk.themoviedb.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.ui.movieList.PopularMoviesViewModel;
import com.sergeyyaniuk.themoviedb.utils.ViewModelFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class PopularFragmentModule {

    @Provides
    PopularMoviesViewModel providePopularMoviesViewModel(MoviesDataSource moviesDataSource){
        return new PopularMoviesViewModel(moviesDataSource);
    }

    @Provides
    ViewModelProvider.Factory provideViewModelProvider(PopularMoviesViewModel viewModel){
        return new ViewModelFactory<>(viewModel);
    }
}
