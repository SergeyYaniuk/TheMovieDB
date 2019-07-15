package com.sergeyyaniuk.themoviedb.data.local.dao;

import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.Transaction;

import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;


@Dao
public interface MovieDetailDao {

    @Transaction
    @Query("SELECT * FROM movie_detail WHERE id = :movieId LIMIT 1")
    MovieDetail getMovie(int movieId);
}
