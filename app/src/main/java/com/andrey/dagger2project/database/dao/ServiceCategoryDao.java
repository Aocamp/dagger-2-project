package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

@Dao
public interface ServiceCategoryDao extends BaseDao<ServiceCategory>{
    @Query("DELETE FROM ServiceCategory")
    void deleteAll();

    @Query("SELECT * FROM ServiceCategory")
    LiveData<List<ServiceCategory>> getAll();
}
