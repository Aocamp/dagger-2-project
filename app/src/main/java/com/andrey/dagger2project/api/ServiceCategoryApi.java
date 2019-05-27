package com.andrey.dagger2project.api;

import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface ServiceCategoryApi {
    @Headers({
            "partner-name: wooppay_kz",
            "language: ru"
            })
    @GET("service-category")
    Call<List<ServiceCategory>> getAll(@Query("expand") String children);
}
