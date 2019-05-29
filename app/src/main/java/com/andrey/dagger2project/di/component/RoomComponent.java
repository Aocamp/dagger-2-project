package com.andrey.dagger2project.di.component;

import android.app.Application;

import com.andrey.dagger2project.activity.ServiceActivity;
import com.andrey.dagger2project.activity.ServiceCategoryActivity;
import com.andrey.dagger2project.activity.SubServiceActivity;
import com.andrey.dagger2project.activity.SubcategoryActivity;
import com.andrey.dagger2project.database.AppDatabase;
import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.dao.ServiceDao;
import com.andrey.dagger2project.database.dao.SubcategoryByCategoryDao;
import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.repository.ServiceCategoryRepository;
import com.andrey.dagger2project.database.repository.ServiceRepository;
import com.andrey.dagger2project.database.repository.SubcategoryByCategoryRepository;
import com.andrey.dagger2project.database.repository.SubcategoryRepository;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.di.module.AppModule;
import com.andrey.dagger2project.di.module.RoomModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class, RoomModule.class})
public interface RoomComponent {
    void inject(ServiceCategoryActivity activity);

    void inject(SubcategoryActivity activity);

    void inject(ServiceActivity activity);

    void inject(SubServiceActivity activity);

    AppDatabase appDatabase();

    Application application();

    ServiceCategoryDao serviceCategoryDao();

    SubcategoryDao subcategoryDao();

    ServiceDao serviceDao();

    SubcategoryByCategoryDao subcategoryByCategoryDao();

    SubcategoryByCategoryRepository subcategoryByCategoryRepository();

    ServiceRepository serviceRepository();

    ServiceCategoryRepository serviceCategoryRepository();

    SubcategoryRepository subcategoryRepository();


}
