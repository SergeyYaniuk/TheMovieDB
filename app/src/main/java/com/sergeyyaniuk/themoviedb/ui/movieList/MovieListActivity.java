package com.sergeyyaniuk.themoviedb.ui.movieList;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.sergeyyaniuk.themoviedb.R;
import com.sergeyyaniuk.themoviedb.ui.base.BaseActivity;
import com.sergeyyaniuk.themoviedb.ui.movieDetail.MovieDetailActivity;


public class MovieListActivity extends BaseActivity implements
        PopularMoviesFragment.PopularFragmentListener,
        SearchMoviesFragment.SearchFragmentListener {

    ViewPager viewPager;
    TabLayout tabLayout;

    boolean isNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isNetwork = isNetworkConnected();
        setContentView(R.layout.activity_movie_list);
        setupUi();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isNetwork){
            showToast(getResources().getString(R.string.offline_mode));
        }
    }

    @Override
    public void onAttachFragment(Fragment fragment) {
        if (fragment instanceof PopularMoviesFragment) {
            PopularMoviesFragment popularMoviesFragment = (PopularMoviesFragment) fragment;
            popularMoviesFragment.setPopularFragListener(this);
        } else if (fragment instanceof SearchMoviesFragment){
            SearchMoviesFragment searchMoviesFragment = (SearchMoviesFragment) fragment;
            searchMoviesFragment.setSearchFragListener(this);
        }
    }

    private void setupUi(){
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
        SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void onPopularClicked(String movieId) {
        startActivity(new Intent(this, MovieDetailActivity.class));
    }

    @Override
    public void onSearchClicked(String movieId) {
        startActivity(new Intent(this, MovieDetailActivity.class));
    }

    private class SectionsPagerAdapter extends FragmentPagerAdapter {
        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return PopularMoviesFragment.newInstance(isNetwork);
                case 1:
                    return SearchMoviesFragment.newInstance(isNetwork);
            }
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getText(R.string.popular);
                case 1:
                    return getResources().getText(R.string.search);
            }
            return null;
        }
    }
}
