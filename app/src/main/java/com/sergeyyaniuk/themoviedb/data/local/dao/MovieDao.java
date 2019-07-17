package com.sergeyyaniuk.themoviedb.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sergeyyaniuk.themoviedb.data.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovieList(List<Movie> movieList);

    @Query("SELECT * FROM movie ORDER BY popularity DESC, vote_count DESC")
    List<Movie> getPopularMovies();

    @Query("SELECT * FROM movie WHERE title LIKE :queryString ORDER BY popularity DESC")
    List<Movie> getMoviesByName(String queryString);
}
