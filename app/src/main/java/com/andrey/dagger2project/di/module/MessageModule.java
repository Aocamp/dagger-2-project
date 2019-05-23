package com.andrey.dagger2project.di.module;

import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.api.MessageApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MessageModule {
    @ApplicationScope
    @Provides
    public MessageApi messageApi(Retrofit retrofit){
        return retrofit.create(MessageApi.class);
    }

    @ApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit
                .Builder()
                .baseUrl("http://192.168.43.220:8080/com.api/rest/")
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
