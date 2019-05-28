package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Field;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface FieldDao extends BaseDao <Field>{
    @Query("DELETE FROM Field")
    void deleteAll();

    @Query("SELECT * from Field")
    List<Field> getAll();

    @Query("SELECT * FROM Field WHERE serviceId = :id ")
    Field getByServiceId(Long id);
}
