package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Service;

import java.util.List;

@Dao
public interface ServiceDao {
    @Insert
    void insert (Service service);

    @Insert
    void insertAll (Service... services);

    @Query("DELETE FROM services")
    void deleteAll();

    @Query("SELECT * from services")
    LiveData<List<Service>> getAll();
}



