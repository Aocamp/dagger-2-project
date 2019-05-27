package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

import javax.inject.Inject;

public class SubcategoryRepositoryImpl implements SubcategoryRepository {
    private SubcategoryDao dao;

    @Inject
    public SubcategoryRepositoryImpl(SubcategoryDao dao){
        this.dao = dao;
    }

    @Override
    public void insert(Subcategory serviceCategory) {
        dao.insert(serviceCategory);
    }

    @Override
    public void insertAll(Subcategory... serviceCategories) {
        dao.insertAll();
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
    public LiveData<List<Subcategory>> getAllById(Long id) {
        return dao.getAllById(id);
    }
}
