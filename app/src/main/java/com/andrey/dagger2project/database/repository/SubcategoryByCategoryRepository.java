package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.SubcategoryByCategoryDao;
import com.andrey.dagger2project.database.model.SubcategoryByCategory;

import java.util.List;

public class SubcategoryByCategoryRepository extends BaseRepository <SubcategoryByCategory, SubcategoryByCategoryDao> {
    public SubcategoryByCategoryRepository(SubcategoryByCategoryDao dao) {
        super(dao);
    }

    public LiveData<List<SubcategoryByCategory>> getAllByCategoryId(Long id) {
        return getDao().getAllByCategoryId(id);
    }
}
