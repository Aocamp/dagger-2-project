package com.andrey.dagger2project.di.module;

import android.content.Context;

import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module(includes = ContextModule.class)
public class PicassoModule {
    @ApplicationScope
    @Provides
    public Picasso picasso(Context context){
        return new Picasso.Builder(context).
                build();
    }
}
