package com.andrey.dagger2project.di.module;

import android.app.Application;
import android.arch.persistence.room.Room;

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

import dagger.Module;
import dagger.Provides;

@Module (includes = AppModule.class)
public class RoomModule {
    private AppDatabase appDatabase;

    public RoomModule(Application application) {
        appDatabase = Room.databaseBuilder(application, AppDatabase.class, "mydb").build();
    }

    @ApplicationScope
    @Provides
    AppDatabase providesRoomDatabase() {
        return appDatabase;
    }

    @ApplicationScope
    @Provides
    ServiceCategoryDao providesServiceCategoryDao(AppDatabase database) {
        return database.getServiceCategoryDao();
    }

    @ApplicationScope
    @Provides
    SubcategoryDao providesSubcategoryDao(AppDatabase database) {
        return database.getSubcategoryDao();
    }

    @ApplicationScope
    @Provides
    ServiceDao providesServiceDao(AppDatabase database) {
        return database.getServiceDao();
    }

    @ApplicationScope
    @Provides
    SubcategoryByCategoryDao subcategoryByCategoryDao(AppDatabase database) {
        return database.getSubcategoryByCategoryDao();
    }

    @ApplicationScope
    @Provides
    ServiceCategoryRepository serviceCategoryRepository(ServiceCategoryDao dao) {
        return new ServiceCategoryRepository(dao);
    }

    @ApplicationScope
    @Provides
    SubcategoryByCategoryRepository subcategoryByCategoryRepository(SubcategoryByCategoryDao dao) {
        return new SubcategoryByCategoryRepository(dao);
    }

    @ApplicationScope
    @Provides
    ServiceRepository serviceRepository(ServiceDao dao) {
        return new ServiceRepository(dao);
    }

    @ApplicationScope
    @Provides
    SubcategoryRepository subcategoryRepository(SubcategoryDao dao) {
        return new SubcategoryRepository(dao);
    }
}
