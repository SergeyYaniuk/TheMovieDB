package com.sergeyyaniuk.themoviedb.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.sergeyyaniuk.themoviedb.data.local.dao.MovieDao;
import com.sergeyyaniuk.themoviedb.data.local.dao.MovieDetailDao;
import com.sergeyyaniuk.themoviedb.data.model.Movie;
import com.sergeyyaniuk.themoviedb.data.model.MovieDetail;

@Database(entities = {Movie.class, MovieDetail.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieDao movieDao();

    public abstract MovieDetailDao movieDetailDao();
}
