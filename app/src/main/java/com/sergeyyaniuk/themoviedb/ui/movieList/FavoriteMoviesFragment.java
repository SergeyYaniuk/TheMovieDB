package com.sergeyyaniuk.themoviedb.ui.movieList;


import android.os.Bundle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.ui.base.BaseFragment;

import javax.inject.Inject;

public class FavoriteMoviesFragment extends BaseFragment<MovieListViewModel>{

    @Inject
    ViewModelProvider.Factory factory;

    MovieListViewModel viewModel;


    public FavoriteMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_movies, container, false);
    }

    @Override
    public MovieListViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(MovieListViewModel.class);
        return viewModel;
    }
}
