package com.sergeyyaniuk.themoviedb.di;

import android.app.Application;

import com.sergeyyaniuk.themoviedb.TheMovieDBApp;
import com.sergeyyaniuk.themoviedb.di.modules.ActivityModule;
import com.sergeyyaniuk.themoviedb.di.modules.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityModule.class})
public interface AppComponent {

    void inject(TheMovieDBApp app);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
