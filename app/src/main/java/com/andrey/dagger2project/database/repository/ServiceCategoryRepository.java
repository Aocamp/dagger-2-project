package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.List;

import javax.inject.Inject;

public class ServiceCategoryRepository extends BaseRepository<ServiceCategory, ServiceCategoryDao> {
    @Inject
    public ServiceCategoryRepository(ServiceCategoryDao dao) {
        super(dao);
    }

    public LiveData<List<ServiceCategory>> getAll() {
        return getDao().getAll();
    }
}
