package com.sergeyyaniuk.themoviedb.data;

import com.sergeyyaniuk.themoviedb.data.local.DatabaseDataSource;
import com.sergeyyaniuk.themoviedb.data.remote.RemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class MoviesRepository implements MoviesDataSource {

    private final DatabaseDataSource databaseDataSource;

    private final RemoteDataSource remoteDataSource;

    @Inject
    public MoviesRepository(DatabaseDataSource databaseDataSource, RemoteDataSource remoteDataSource) {
        this.databaseDataSource = databaseDataSource;
        this.remoteDataSource = remoteDataSource;
    }
}
