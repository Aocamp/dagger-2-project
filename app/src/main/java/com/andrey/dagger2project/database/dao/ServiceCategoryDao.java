package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

@Dao
public interface ServiceCategoryDao {
    @Insert
    void insert (ServiceCategory serviceCategory);

    @Insert
    void insertAll (ServiceCategory... serviceCategories);

    @Query("DELETE FROM service_categories")
    void deleteAll();

    @Query("SELECT * from service_categories")
    LiveData<List<ServiceCategory>> getAll();
}
