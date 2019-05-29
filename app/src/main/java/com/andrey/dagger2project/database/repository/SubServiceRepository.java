package com.andrey.dagger2project.database.repository;

import com.andrey.dagger2project.database.dao.SubServiceDao;
import com.andrey.dagger2project.database.model.SubService;

public class SubServiceRepository extends BaseRepository <SubService, SubServiceDao> {
    public SubServiceRepository(SubServiceDao dao) {
        super(dao);
    }
}
