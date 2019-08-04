package com.sergeyyaniuk.themoviedb.data.remote;

import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.data.model.PaginatedResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * Implementation of the data source that requests data from network.
 */

@Singleton
public class ApiHelper implements RemoteDataSource {

    private ApiEndPoints apiEndPoints;

    @Inject
    public ApiHelper(ApiEndPoints apiEndPoints) {
        this.apiEndPoints = apiEndPoints;
    }

    @Override
    public Observable<PaginatedResponse> getPopularMovies(int page){
        return apiEndPoints.getPopularMovies(page);
    }

    @Override
    public Observable<PaginatedResponse> getSearchedMovies(String query, int page){
        return apiEndPoints.getSearchedMovies(query, page);
    }

    @Override
    public Observable<MovieDetail> getDetailMovie(String movieId){
        return apiEndPoints.getDetailMovie(movieId);
    }
}
