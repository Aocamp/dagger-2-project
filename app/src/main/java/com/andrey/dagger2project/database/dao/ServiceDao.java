package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Service;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

@Dao
public interface ServiceDao extends BaseDao<Service>{
    @Query("DELETE FROM Service")
    void deleteAll();

    @Query("SELECT * FROM Service")
    Maybe<List<Service>> getAll();
//
//    @Query("SELECT * FROM services WHERE categories = :id ")
//    Flowable<List<Service>> getAllBySubcategoryId(Long id);
}



