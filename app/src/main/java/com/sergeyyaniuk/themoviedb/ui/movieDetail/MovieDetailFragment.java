package com.sergeyyaniuk.themoviedb.ui.movieDetail;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.ui.base.BaseFragment;
import com.sergeyyaniuk.themoviedb.utils.Constants;

import javax.inject.Inject;

public class MovieDetailFragment extends BaseFragment<MovieDetailViewModel>{

    @Inject
    ViewModelProvider.Factory factory;

    MovieDetailViewModel viewModel;

    ImageView backdropImage;
    TextView titleTV, budgetTV, releaseTV, revenueTV, overviewTV;
    String movieId;


    public MovieDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        boolean isNetwork = isNetworkConnected();
        Bundle arguments = getArguments();
        if (arguments != null){
            movieId = arguments.getString(Constants.MOVIE_ID);
            setupUi(view);
            setupObservers();
            viewModel.loadMovieDetail(movieId, isNetwork);
        }
        return view;
    }

    @Override
    public MovieDetailViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(MovieDetailViewModel.class);
        return viewModel;
    }

    private void setupUi(View view){
        backdropImage = view.findViewById(R.id.backdrop_image);
        titleTV = view.findViewById(R.id.title_tv);
        budgetTV = view.findViewById(R.id.budget_tv);
        releaseTV = view.findViewById(R.id.release_date_tv);
        revenueTV = view.findViewById(R.id.revenue_tv);
        overviewTV = view.findViewById(R.id.overview);
    }

    private void setupObservers(){
        viewModel.getDetailMovie().observe(this, new Observer<MovieDetail>() {
            @Override
            public void onChanged(@Nullable MovieDetail movieDetail) {
                String budget = movieDetail.getBudget() + " USD";
                String revenue = movieDetail.getRevenue() + " USD";
                String imageUrl = Constants.BASE_URL_IMAGE + movieDetail.getBackdropPath();
                titleTV.setText(movieDetail.getTitle());
                releaseTV.setText(movieDetail.getReleaseDate());
                overviewTV.setText(movieDetail.getOverview());
                budgetTV.setText(budget);
                revenueTV.setText(revenue);
                Glide.with(getActivity()).load(imageUrl).apply(RequestOptions.centerCropTransform())
                        .into(backdropImage);
            }
        });
    }
}
