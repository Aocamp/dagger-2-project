package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.entity.Subcategory;

import java.util.List;

import javax.inject.Inject;

public class SubcategoryRepositoryImpl implements SubcategoryRepository {
    private SubcategoryDao dao;

    @Inject
    public SubcategoryRepositoryImpl(SubcategoryDao dao){
        this.dao = dao;
    }

    @Override
    public void insert(Subcategory subcategory) {
        dao.insert(subcategory);
    }

    @Override
    public void insertAll(List<Subcategory> t) {
        dao.insertAll(t);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public LiveData<List<Subcategory>> getAll() {
        return dao.getAll();
    }

    @Override
    public LiveData<List<Subcategory>> getAllByCategoryId(Long id) {
        return dao.getAllByCategoryId(id);
    }
}
