package com.sergeyyaniuk.themoviedb.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;


@Dao
public interface MovieDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieDetail movieDetail);

    @Query("SELECT * FROM movie_detail WHERE id = :movieId LIMIT 1")
    MovieDetail getMovie(int movieId);
}
