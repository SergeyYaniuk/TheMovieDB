package com.sergeyyaniuk.themoviedb.ui.movieDetail;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.ui.base.BaseFragment;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends BaseFragment<MovieDetailViewModel>{

    @Inject
    ViewModelProvider.Factory factory;

    MovieDetailViewModel viewModel;


    public MovieDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie_detail, container, false);
    }

    @Override
    public MovieDetailViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailViewModel.class);
        return viewModel;
    }
}
