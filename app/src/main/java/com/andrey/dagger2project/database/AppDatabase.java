package com.andrey.dagger2project.database;

import android.arch.persistence.room.RoomDatabase;

import com.andrey.dagger2project.database.dao.FieldDao;
import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.dao.ServiceDao;
import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.entity.Field;
import com.andrey.dagger2project.database.entity.Service;
import com.andrey.dagger2project.database.entity.ServiceCategory;
import com.andrey.dagger2project.database.entity.Subcategory;

@android.arch.persistence.room.Database(
        entities = {Field.class, Service.class, ServiceCategory.class, Subcategory.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FieldDao getFieldDao();
    public abstract ServiceCategoryDao getServiceCategoryDao();
    public abstract ServiceDao getServiceDao();
    public abstract SubcategoryDao getSubcategoryDao();
}
