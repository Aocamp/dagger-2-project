package com.andrey.dagger2project;

import android.app.Application;

import com.andrey.dagger2project.di.component.DaggerMessageComponent;
import com.andrey.dagger2project.di.component.MessageComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;

public class App extends Application {
    private MessageComponent messageComponent;
    private ServiceCategoryComponent serviceCategoryComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        messageComponent = DaggerMessageComponent.create();
    }

    public MessageComponent getMessageComponent() {
        return messageComponent;
    }
}
