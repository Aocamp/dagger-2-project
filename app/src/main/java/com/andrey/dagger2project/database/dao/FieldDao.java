package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.entity.Field;

import java.util.List;

@Dao
public interface FieldDao extends BaseDao <Field>{
    @Query("DELETE FROM fields")
    void deleteAll();

    @Query("SELECT * from fields")
    LiveData<List<Field>> getAll();

    @Query("SELECT * FROM fields WHERE serviceId = :id ")
    Field getByServiceId(Long id);
}
