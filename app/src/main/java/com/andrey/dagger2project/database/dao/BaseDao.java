package com.andrey.dagger2project.database.dao;

import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Update;

import com.andrey.dagger2project.database.model.BaseModel;

import java.util.List;

import io.reactivex.Completable;

public interface BaseDao <T extends BaseModel> {
    @Insert
    Completable insert (T t);

    @Insert
    Completable insertAll (List<T> t);

    @Update
    void update (T t);

    @Delete
    void delete (T t);
}
