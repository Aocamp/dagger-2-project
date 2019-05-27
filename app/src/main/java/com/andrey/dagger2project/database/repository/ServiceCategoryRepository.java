package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

public interface ServiceCategoryRepository {
    void insert (ServiceCategory serviceCategory);

    void insertAll (ServiceCategory... serviceCategories);

    void deleteAll();

    LiveData<List<ServiceCategory>> getAll();
}
