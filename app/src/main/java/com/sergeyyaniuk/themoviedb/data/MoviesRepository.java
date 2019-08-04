package com.sergeyyaniuk.themoviedb.data;

import com.sergeyyaniuk.themoviedb.data.local.LocalDataSource;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;
import com.sergeyyaniuk.themoviedb.data.model.PaginatedResponse;
import com.sergeyyaniuk.themoviedb.data.remote.RemoteDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


/**
 * Concrete implementation to load all data.
 */

@Singleton
public class MoviesRepository implements MoviesDataSource {

    private final LocalDataSource localDataSource;

    private final RemoteDataSource remoteDataSource;

    @Inject
    public MoviesRepository(LocalDataSource localDataSource, RemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<List<Movie>> getPopularMoviesLocally(){
        return localDataSource.getPopularMovies();
    }

    @Override
    public Observable<List<Movie>> getSearchedMoviesLocally(String searchString){
        return localDataSource.getMoviesByName(searchString);
    }

    @Override
    public Observable<Boolean> saveMovieLocally(final Movie movie){
        return localDataSource.saveMovie(movie);
    }

    @Override
    public Observable<Boolean> saveMovieListLocally(List<Movie> movies) {
        return localDataSource.saveMovieList(movies);
    }

    @Override
    public Observable<Boolean> saveDetailMovieLocally(MovieDetail movieDetail) {
        return localDataSource.saveDetailMovie(movieDetail);
    }

    @Override
    public Observable<MovieDetail> getDetailMovieLocally(int movieId){
        return localDataSource.getDetailMovie(movieId);
    }

    @Override
    public Observable<PaginatedResponse> getPopularMoviesRemotely(int page){
        return remoteDataSource.getPopularMovies(page);
    }

    @Override
    public Observable<PaginatedResponse> getSearchedMoviesRemotely(String query, int page){
        return remoteDataSource.getSearchedMovies(query, page);
    }

    @Override
    public Observable<MovieDetail> getDetailMovieRemotely(String movieId){
        return remoteDataSource.getDetailMovie(movieId);
    }
}
