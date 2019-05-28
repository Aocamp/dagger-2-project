package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.Subcategory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class SubcategoryRepository implements BaseRepository<Subcategory> {
    private SubcategoryDao dao;

    @Inject
    public SubcategoryRepository(SubcategoryDao dao){
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
    public Maybe<List<Subcategory>> getAll() {
        return dao.getAll();
    }

    public Maybe<List<Subcategory>> getAllByCategoryId(Long id) {
        return dao.getAllByCategoryId(id);
    }
}
