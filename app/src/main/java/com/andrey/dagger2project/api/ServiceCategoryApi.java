package com.andrey.dagger2project.api;

import com.andrey.dagger2project.model.ServiceCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ServiceCategoryApi {
    @Headers({
            "partner-name: wooppay_kz",
            "language: ru"
            })
    @GET("service-category")
    Call<List<ServiceCategory>> getAll();
}
