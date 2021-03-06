package com.andrey.dagger2project.database;

import android.arch.persistence.room.RoomDatabase;

import com.andrey.dagger2project.database.dao.FieldDao;
import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.dao.ServiceDao;
import com.andrey.dagger2project.database.dao.SubcategoryByCategoryDao;
import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.model.Category;
import com.andrey.dagger2project.database.model.Field;
import com.andrey.dagger2project.database.model.Service;
import com.andrey.dagger2project.database.model.ServiceBySubcategory;
import com.andrey.dagger2project.database.model.ServiceCategory;
import com.andrey.dagger2project.database.model.SubService;
import com.andrey.dagger2project.database.model.Subcategory;
import com.andrey.dagger2project.database.model.SubcategoryByCategory;

@android.arch.persistence.room.Database(
        entities = {Field.class, Service.class, ServiceCategory.class, Subcategory.class, SubService.class, Category.class, SubcategoryByCategory.class, ServiceBySubcategory.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FieldDao getFieldDao();
    public abstract ServiceCategoryDao getServiceCategoryDao();
    public abstract ServiceDao getServiceDao();
    public abstract SubcategoryDao getSubcategoryDao();
    public abstract SubcategoryByCategoryDao getSubcategoryByCategoryDao();
}
