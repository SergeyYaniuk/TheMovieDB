package com.sergeyyaniuk.themoviedb.data.remote;

import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.data.model.PaginatedResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiEndPoints {

    @GET("movie/popular")
    Observable<PaginatedResponse> getPopularMovies(@Query("page") int page);

    @GET("search/movie")
    Observable<PaginatedResponse> getSearchedMovies(@Query("query") String query, @Query("page") int page);

    @GET("movie/{movieId}")
    Observable<MovieDetail> getDetailMovie(@Path("movieId") String movieId);
}
