package com.andrey.dagger2project.database.repository;

import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

import javax.inject.Inject;

public class ServiceCategoryRepository extends BaseRepository<ServiceCategory> {
    private ServiceCategoryDao dao;

    @Inject
    public ServiceCategoryRepository(ServiceCategoryDao dao) {
        this.dao = dao;
    }


    public List<ServiceCategory> getAll() {
        return dao.getAll();
    }
}
