package com.andrey.dagger2project.di.module;

import android.app.Application;

import com.andrey.dagger2project.di.annotation.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @ApplicationScope
    @Provides
    Application providesApplication() {
        return mApplication;
    }

}
