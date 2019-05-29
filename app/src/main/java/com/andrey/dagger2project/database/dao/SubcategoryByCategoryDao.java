package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.SubcategoryByCategory;

import java.util.List;

@Dao
public interface SubcategoryByCategoryDao extends BaseDao<SubcategoryByCategory> {
    @Query("SELECT * FROM SubcategoryByCategory WHERE serviceCategoryId = :id ")
    LiveData<List<SubcategoryByCategory>> getAllByCategoryId(Long id);
}
