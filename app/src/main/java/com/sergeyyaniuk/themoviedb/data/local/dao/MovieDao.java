package com.sergeyyaniuk.themoviedb.data.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sergeyyaniuk.themoviedb.data.model.Movie;

import java.util.List;

@Dao
public interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(Movie movie);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllMovies(List<Movie> movies);

    @Query("SELECT * FROM movie ORDER BY popularity DESC, vote_count DESC")
    List<Movie> getPopularMovies();

    @Query("SELECT * FROM movie WHERE (title LIKE :queryString) ORDER BY popularity DESC")
    List<Movie> getMoviesByName(String queryString);
}
