package com.sergeyyaniuk.themoviedb.ui.movieList;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;


import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.ui.base.BaseFragment;
import com.sergeyyaniuk.themoviedb.ui.base.ErrorCallback;
import java.util.List;

import javax.inject.Inject;

public class PopularMoviesFragment extends BaseFragment<PopularMoviesViewModel>{

    public interface PopularFragmentListener{
        void onPopularClicked(String movieId);
    }

    public static final String NETWORK_STATUS = "isNetwork";

    @Inject
    ViewModelProvider.Factory factory;

    private PopularMoviesViewModel viewModel;

    PopularFragmentListener listener;
    private ErrorCallback errorCallback;

    private RecyclerView popularRecView;
    private PopularMoviesAdapter adapter;

    private int page = 1;

    boolean isNetworkConnected;


    public PopularMoviesFragment() {
        // Required empty public constructor
    }

    public static PopularMoviesFragment newInstance(boolean isNetworkConnected){
        Bundle args = new Bundle();
        args.putBoolean(NETWORK_STATUS, isNetworkConnected);
        PopularMoviesFragment fragment = new PopularMoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        isNetworkConnected = args.getBoolean(NETWORK_STATUS);
        viewModel.loadPopularMovies(page, isNetworkConnected);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popular_movies, container, false);
        setupUi(view);
        setupObservers();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        errorCallback = (ErrorCallback) context;
        listener = (PopularFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        errorCallback = null;
        listener = null;
    }

    @Override
    public PopularMoviesViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(PopularMoviesViewModel.class);
        return viewModel;
    }

    private void setupObservers(){
        viewModel.getPopularMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.updateList(movies);
            }
        });
        viewModel.getIsDataLoadingError().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                errorCallback.setDataError(aBoolean);
            }
        });
    }

    private void setupUi(View view){
        popularRecView = view.findViewById(R.id.popular_recView);
        popularRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new PopularMoviesAdapter(adapterListener);
        popularRecView.setAdapter(adapter);
        popularRecView.addItemDecoration(new ItemDivider(getContext()));
    }

    public void setPopularFragListener(PopularFragmentListener popularFragListener){
        listener = popularFragListener;
    }

    PopularMoviesAdapter.PopularMoviesAdapterListener adapterListener = new PopularMoviesAdapter.PopularMoviesAdapterListener() {
        @Override
        public void onPopularClick(String movieId) {
            listener.onPopularClicked(movieId);
        }
    };
}
