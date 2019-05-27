package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

public interface SubcategoryRepository {
    void insert (Subcategory serviceCategory);

    void insertAll (Subcategory... serviceCategories);

    void deleteAll();

    LiveData<List<Subcategory>> getAll();

    LiveData<List<Subcategory>> getAllById(Long id);
}
