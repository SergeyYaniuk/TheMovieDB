package com.sergeyyaniuk.themoviedb.data.local;

import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class DatabaseHelper implements DatabaseDataSource {

    private final AppDatabase database;

    @Inject
    public DatabaseHelper(AppDatabase database) {
        this.database = database;
    }

    @Override
    public Observable<List<Movie>> getPopularMovies() {
        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return database.movieDao().getPopularMovies();
            }
        });
    }

    @Override
    public Observable<List<Movie>> getMoviesByName(String searchString){
        return Observable.fromCallable(new Callable<List<Movie>>() {
            @Override
            public List<Movie> call() throws Exception {
                return database.movieDao().getMoviesByName(searchString);
            }
        });
    }

    @Override
    public Observable<Boolean> saveMovies(final List<Movie> movies){
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                database.movieDao().insertAllMovies(movies);
                return true;
            }
        });
    }

    @Override
    public Observable<MovieDetail> getDetailMovie(int movieId){
        return Observable.fromCallable(new Callable<MovieDetail>() {
            @Override
            public MovieDetail call() throws Exception {
                return database.movieDetailDao().getMovie(movieId);
            }
        });
    }
}
