package com.andrey.dagger2project.api;

import com.andrey.dagger2project.model.Service;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ServiceApi {
    @Headers({"language: ru"})
    @GET("service")
    Call<List<Service>> getBySubcategoryId(@Query("category_id") Long id, @Query("expand") String children);
}
