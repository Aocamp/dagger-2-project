package com.andrey.dagger2project.database.repository;

import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;

public class ServiceCategoryRepository implements BaseRepository<ServiceCategory> {
    private ServiceCategoryDao dao;

    @Inject
    public ServiceCategoryRepository(ServiceCategoryDao dao) {
        this.dao = dao;
    }

    @Override
    public Completable insert(ServiceCategory serviceCategory) {
        return dao.insert(serviceCategory);
    }

    @Override
    public Completable insertAll(List<ServiceCategory> t) {
        return dao.insertAll(t);
    }

    @Override
    public void deleteAll() {
        dao.deleteAll();
    }

    @Override
    public Maybe<List<ServiceCategory>> getAll() {
        return dao.getAll();
    }
}
