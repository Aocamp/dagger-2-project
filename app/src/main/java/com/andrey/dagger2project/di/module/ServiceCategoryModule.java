package com.andrey.dagger2project.di.module;

import android.content.Context;

import com.andrey.dagger2project.api.ServiceApi;
import com.andrey.dagger2project.api.ServiceCategoryApi;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ServiceCategoryModule {
    @ApplicationScope
    @Provides
    public ServiceCategoryApi serviceCategoryApi(Retrofit retrofit){
        return retrofit.create(ServiceCategoryApi.class);
    }

    @ApplicationScope
    @Provides
    public ServiceApi serviceApi(Retrofit retrofit){
        return retrofit.create(ServiceApi.class);
    }

    @ApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit
                .Builder()
                .baseUrl("https://api.yii2.test.wooppay.com/v1/")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @ApplicationScope
    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @ApplicationScope
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }
}
