package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;
import com.andrey.dagger2project.database.entity.Subcategory;

import java.util.List;

public interface SubcategoryRepository extends BaseRepository<Subcategory> {
    LiveData<List<Subcategory>> getAllByCategoryId(Long id);
}
