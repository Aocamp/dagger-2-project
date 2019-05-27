package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

import javax.inject.Inject;

public class ServiceCategoryRepositoryImpl implements ServiceCategoryRepository {
    private ServiceCategoryDao dao;

    @Inject
    public ServiceCategoryRepositoryImpl(ServiceCategoryDao dao) {
        this.dao = dao;
    }

    @Override
    public void insert(ServiceCategory serviceCategory) {
        dao.insert(serviceCategory);
    }

    @Override
    public void insertAll(ServiceCategory... serviceCategories) {
        dao.insertAll(serviceCategories);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public LiveData<List<ServiceCategory>> getAll() {
        return dao.getAll();
    }
}
