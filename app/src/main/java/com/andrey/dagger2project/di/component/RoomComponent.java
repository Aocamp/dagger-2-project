package com.andrey.dagger2project.di.component;

import android.app.Application;

import com.andrey.dagger2project.activity.ServiceCategoryActivity;
import com.andrey.dagger2project.database.AppDatabase;
import com.andrey.dagger2project.database.dao.ServiceCategoryDao;
import com.andrey.dagger2project.database.dao.SubcategoryDao;
import com.andrey.dagger2project.database.repository.ServiceCategoryRepository;
import com.andrey.dagger2project.database.repository.SubcategoryRepository;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.di.module.AppModule;
import com.andrey.dagger2project.di.module.RoomModule;

import dagger.Component;

@ApplicationScope
@Component(modules = {AppModule.class, RoomModule.class})
public interface RoomComponent {
    void inject(ServiceCategoryActivity activity);

    AppDatabase appDatabase();

    Application application();

    ServiceCategoryDao serviceCategoryDao();

    SubcategoryDao subcategoryDao();

    ServiceCategoryRepository serviceCategoryRepository();

    SubcategoryRepository subcategoryRepository();


}
