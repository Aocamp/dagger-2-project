package com.andrey.dagger2project.database.repository;

import android.arch.lifecycle.LiveData;

import com.andrey.dagger2project.database.dao.ServiceDao;
import com.andrey.dagger2project.database.model.Service;

import java.util.List;

import javax.inject.Inject;

public class ServiceRepository extends BaseRepository <Service, ServiceDao> {
    @Inject
    public ServiceRepository(ServiceDao dao) {
        super(dao);
    }

    public LiveData<List<Service>> getAllByCategoryId() {
        return getDao().getAll();
    }
}
