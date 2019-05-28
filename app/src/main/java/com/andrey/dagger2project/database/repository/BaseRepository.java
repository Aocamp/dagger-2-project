package com.andrey.dagger2project.database.repository;

import com.andrey.dagger2project.database.model.BaseModel;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface BaseRepository <T extends BaseModel> {
    Completable insert (T t);

    Completable insertAll (List<T> t);

    void deleteAll();

    Maybe<List<T>> getAll();
}
