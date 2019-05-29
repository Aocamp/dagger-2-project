package com.andrey.dagger2project.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Service;
import com.andrey.dagger2project.database.model.ServiceBySubcategory;

import java.util.List;

public interface ServiceBySubcategoryDao extends BaseDao<ServiceBySubcategory> {
    @Query("SELECT s.* FROM ServiceBySubcategory ser INNER JOIN Service s, Category c ON ser.subcategoryId = c.parentId WHERE ser.subcategoryId = :id ")
    LiveData<List<Service>> getAllBySubcategoryId(Long id);
}
