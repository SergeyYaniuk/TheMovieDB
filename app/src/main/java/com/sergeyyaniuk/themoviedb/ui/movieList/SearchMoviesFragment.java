package com.sergeyyaniuk.themoviedb.ui.movieList;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.ui.base.BaseFragment;
import com.sergeyyaniuk.themoviedb.ui.base.ErrorCallback;

import java.util.List;

import javax.inject.Inject;


public class SearchMoviesFragment extends BaseFragment<SearchMoviesViewModel> {

    public interface SearchFragmentListener{
        void onSearchClicked(String movieId, String movieTitle);
    }
    
    public static final String NETWORK_STATUS = "isNetwork";

    @Inject
    ViewModelProvider.Factory factory;

    SearchMoviesViewModel viewModel;

    SearchMoviesFragment.SearchFragmentListener listener;
    ErrorCallback errorListener;

    private RecyclerView searchRecView;
    private SearchMoviesAdapter adapter;
    private EditText searchEditText;

    int page = 1;
    boolean isNetworkConnected;

    public SearchMoviesFragment() {
        // Required empty public constructor
    }

    public static SearchMoviesFragment newInstance(boolean isNetworkConnected){
        Bundle args = new Bundle();
        args.putBoolean(NETWORK_STATUS, isNetworkConnected);
        SearchMoviesFragment fragment = new SearchMoviesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        isNetworkConnected = args.getBoolean(NETWORK_STATUS);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_movies, container, false);
        setupUi(view);
        setupObservers();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        errorListener = (ErrorCallback) context;
        listener = (SearchFragmentListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        errorListener = null;
        listener = null;
    }

    @Override
    public SearchMoviesViewModel getViewModel() {
        viewModel = ViewModelProviders.of(this, factory).get(SearchMoviesViewModel.class);
        return viewModel;
    }

    private void setupObservers(){
        viewModel.getSearchedMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                adapter.updateList(movies);
            }
        });
        viewModel.getIsDataLoadingError().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                errorListener.setDataError(aBoolean);
            }
        });
    }

    private void setupUi(View view){
        searchRecView = view.findViewById(R.id.search_recView);
        searchRecView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new SearchMoviesAdapter(adapterListener);
        searchRecView.setAdapter(adapter);
        searchRecView.addItemDecoration(new ItemDivider(getContext()));
        searchEditText = view.findViewById(R.id.search_editText);
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0){
                    viewModel.loadSearchMovies(s.toString(), page, true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public void setSearchFragListener(SearchFragmentListener searchFragListener){
        listener = searchFragListener;
    }

    SearchMoviesAdapter.SearchMoviesAdapterListener adapterListener = new SearchMoviesAdapter.SearchMoviesAdapterListener() {
        @Override
        public void onSearchedClick(String movieId, String movieTitle) {
            listener.onSearchClicked(movieId, movieTitle);
        }
    };
}
