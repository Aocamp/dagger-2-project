package com.andrey.dagger2project.database.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.andrey.dagger2project.database.entity.BaseModel;

import java.util.List;

public interface BaseDao <T extends BaseModel> {
    @Insert
    void insert (T t);

    @Insert
    void insertAll (List<T> t);

    @Update
    void update (T t);

    @Delete
    void delete (T t);
}
