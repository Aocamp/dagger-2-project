package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.entity.Service;

import java.util.List;

@Dao
public interface ServiceDao extends BaseDao<Service>{
    @Query("DELETE FROM services")
    void deleteAll();

    @Query("SELECT * from services")
    LiveData<List<Service>> getAll();
//
//    @Query("SELECT * FROM services WHERE categories = :id ")
//    LiveData<List<Service>> getAllBySubcategoryId(Long id);
}



