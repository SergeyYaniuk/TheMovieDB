package com.sergeyyaniuk.themoviedb.di.modules;

import android.arch.persistence.room.Room;
import android.content.Context;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.sergeyyaniuk.themoviedb.TheMovieDBApp;
import com.sergeyyaniuk.themoviedb.data.MoviesDataSource;
import com.sergeyyaniuk.themoviedb.data.MoviesRepository;
import com.sergeyyaniuk.themoviedb.data.local.AppDatabase;
import com.sergeyyaniuk.themoviedb.data.local.LocalDataSource;
import com.sergeyyaniuk.themoviedb.data.local.LocalHelper;
import com.sergeyyaniuk.themoviedb.data.remote.ApiEndPoints;
import com.sergeyyaniuk.themoviedb.data.remote.ApiHelper;
import com.sergeyyaniuk.themoviedb.data.remote.RemoteDataSource;
import com.sergeyyaniuk.themoviedb.di.qualifiers.ApiInfo;
import com.sergeyyaniuk.themoviedb.di.qualifiers.ApiKey;
import com.sergeyyaniuk.themoviedb.di.qualifiers.DatabaseInfo;
import com.sergeyyaniuk.themoviedb.utils.Constants;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/** Dagger module to inject context, api and database */

@Module
public class AppModule {


    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return Constants.DB_NAME;
    }

    @Provides
    @Singleton
    Context provideContext(TheMovieDBApp application) {
        return application;
    }

    @Provides
    @Singleton
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).build();
    }

    @Provides
    @Singleton
    LocalDataSource provideLocalDataSource(LocalHelper localHelper){
        return localHelper;
    }

    @Provides
    @ApiInfo
    String provideBaseUrl(){
        return Constants.BASE_URL;
    }

    @Provides
    @ApiKey
    String provideApiKey(){
        return Constants.API_KEY;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(@ApiKey String apiKey){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request original = chain.request();
                HttpUrl originalHttpUrl = original.url();

                HttpUrl url = originalHttpUrl.newBuilder()
                        .addQueryParameter("api_key", apiKey)
                        .build();

                Request.Builder requestBuilder = original.newBuilder().url(url);

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(@ApiInfo String baseUrl, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    ApiEndPoints provideApi(Retrofit retrofit){
        return retrofit.create(ApiEndPoints.class);
    }

    @Provides
    @Singleton
    RemoteDataSource provideRemoteDataSource(ApiHelper apiHelper){
        return apiHelper;
    }

    @Provides
    @Singleton
    MoviesDataSource provideMoviesDataSource(MoviesRepository repository){
        return repository;
    }
}
