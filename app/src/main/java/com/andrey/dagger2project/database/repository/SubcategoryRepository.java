package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.os.AsyncTask;

import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

import javax.inject.Inject;

public class SubcategoryRepository extends BaseRepository<Subcategory, SubcategoryDao> {
    @Inject
    public SubcategoryRepository(SubcategoryDao dao) {
        super(dao);
    }

    public LiveData<List<Subcategory>> getAll() {
        return getDao().getAll();
    }

//    public LiveData<List<Subcategory>> getAllByCategoryId(Long id) {
//        return getDao().getAllByCategoryId(id);
//    }

    public LiveData<Subcategory> getByCategoryId(Long id) {
        return getDao().getByCategoryId(id);
    }
}
