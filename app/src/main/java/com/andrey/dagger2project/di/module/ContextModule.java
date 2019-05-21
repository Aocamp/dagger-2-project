package com.andrey.dagger2project.di.module;

import android.content.Context;

import com.andrey.dagger2project.di.annotation.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {
    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @ApplicationScope
    @Provides
    public Context context(){ return context.getApplicationContext(); }
}