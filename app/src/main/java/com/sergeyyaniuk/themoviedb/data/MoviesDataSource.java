package com.sergeyyaniuk.themoviedb.data;


import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.data.model.PaginatedResponse;

import java.util.List;

import io.reactivex.Observable;

public interface MoviesDataSource {

    Observable<List<Movie>> getPopularMoviesLocally();

    Observable<List<Movie>> getSearchedMoviesLocally(String searchString);

    Observable<Boolean> saveMovieLocally(Movie movie);

    Observable<Boolean> saveMovieListLocally(List<Movie> movies);

    Observable<Boolean> saveDetailMovieLocally(MovieDetail movieDetail);

    Observable<MovieDetail> getDetailMovieLocally(int movieId);

    Observable<PaginatedResponse> getPopularMoviesRemotely(int page);

    Observable<PaginatedResponse> getSearchedMoviesRemotely(String query, int page);

    Observable<MovieDetail> getDetailMovieRemotely(String movieId);
}
