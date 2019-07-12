package com.sergeyyaniuk.themoviedb.ui.movieList;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sergeyyaniuk.themoviedb.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchMoviesFragment extends Fragment {


    public SearchMoviesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_movies, container, false);
    }

}
