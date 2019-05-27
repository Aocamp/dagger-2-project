package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

@Dao
public interface SubcategoryDao {
    @Insert
    void insert (Subcategory serviceCategory);

    @Insert
    void insertAll (Subcategory... serviceCategories);

    @Query("DELETE FROM service_categories")
    void deleteAll();

    @Query("SELECT * FROM service_categories")
    LiveData<List<Subcategory>> getAll();

    @Query("SELECT * FROM subcategories WHERE parent_id = :id ")
    LiveData<List<Subcategory>> getAllById(Long id);
}
