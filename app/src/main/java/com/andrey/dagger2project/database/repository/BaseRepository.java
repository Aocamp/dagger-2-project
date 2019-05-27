package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.model.BaseModel;

import java.util.List;

public interface BaseRepository <T extends BaseModel> {
    void insert (T t);

    void insertAll (List<T> t);

    void deleteAll();

    LiveData<List<T>> getAll();
}
