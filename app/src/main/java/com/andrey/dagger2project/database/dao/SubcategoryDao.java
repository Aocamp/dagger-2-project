package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

import io.reactivex.Maybe;

@Dao
public interface SubcategoryDao extends BaseDao<Subcategory> {
    @Query("DELETE FROM Subcategory")
    void deleteAll();

    @Query("SELECT * FROM Subcategory")
    Maybe<List<Subcategory>> getAll();

    @Query("SELECT * FROM Subcategory WHERE parentId = :id ")
    Maybe<List<Subcategory>> getAllByCategoryId(Long id);
}
