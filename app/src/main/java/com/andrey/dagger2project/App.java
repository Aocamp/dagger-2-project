package com.andrey.dagger2project;

import android.app.Application;

import com.andrey.dagger2project.di.component.DaggerMessageComponent;
import com.andrey.dagger2project.di.component.DaggerRoomComponent;
import com.andrey.dagger2project.di.component.DaggerServiceCategoryComponent;
import com.andrey.dagger2project.di.component.MessageComponent;
import com.andrey.dagger2project.di.component.RoomComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.di.module.AppModule;

public class App extends Application {
    private MessageComponent messageComponent;
    private ServiceCategoryComponent serviceCategoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        messageComponent = DaggerMessageComponent.create();
        serviceCategoryComponent = DaggerServiceCategoryComponent.create();
    }

    public MessageComponent getMessageComponent() {
        return messageComponent;
    }

    public ServiceCategoryComponent getServiceCategoryComponent() {
        return serviceCategoryComponent;
    }
}
