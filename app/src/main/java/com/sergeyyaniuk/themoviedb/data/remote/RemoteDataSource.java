package com.sergeyyaniuk.themoviedb.data.remote;

import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.data.model.PaginatedResponse;

import io.reactivex.Observable;

public interface RemoteDataSource {

    Observable<PaginatedResponse> getPopularMovies(int page);

    Observable<PaginatedResponse> getSearchedMovies(String query, int page);

    Observable<MovieDetail> getDetailMovie(String movieId);
}
