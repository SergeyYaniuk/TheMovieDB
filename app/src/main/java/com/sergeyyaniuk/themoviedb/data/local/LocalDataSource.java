package com.sergeyyaniuk.themoviedb.data.local;

import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;

import java.util.List;

import io.reactivex.Observable;

public interface LocalDataSource {

    Observable<List<Movie>> getPopularMovies();

    Observable<List<Movie>> getMoviesByName(String searchString);

    Observable<Boolean> saveMovies(final List<Movie> movies);

    Observable<MovieDetail> getDetailMovie(int movieId);
}
