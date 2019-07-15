package com.sergeyyaniuk.themoviedb.di;

import com.sergeyyaniuk.themoviedb.TheMovieDBApp;
import com.sergeyyaniuk.themoviedb.di.modules.ActivityBuilder;
import com.sergeyyaniuk.themoviedb.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface ApplicationComponent extends AndroidInjector<TheMovieDBApp> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<TheMovieDBApp> {}
}
