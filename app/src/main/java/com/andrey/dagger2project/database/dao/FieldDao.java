package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Field;

import java.util.List;

@Dao
public interface FieldDao {
    @Insert
    void insert (Field field);

    @Insert
    void insertAll (Field... fields);

    @Query("DELETE FROM fields")
    void deleteAll();

    @Query("SELECT * from fields")
    LiveData<List<Field>> getAll();
}
