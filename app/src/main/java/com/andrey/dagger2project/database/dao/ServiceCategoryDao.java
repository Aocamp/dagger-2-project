package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.entity.ServiceCategory;

import java.util.List;

@Dao
public interface ServiceCategoryDao extends BaseDao<ServiceCategory>{
    @Query("DELETE FROM service_categories")
    void deleteAll();

    @Query("SELECT * from service_categories")
    LiveData<List<ServiceCategory>> getAll();
}
