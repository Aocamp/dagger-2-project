package com.andrey.dagger2project;

import android.app.Application;

import com.andrey.dagger2project.component.DaggerMessageComponent;
import com.andrey.dagger2project.di.component.MessageComponent;

public class App extends Application {
    private MessageComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMessageComponent.create();
    }

    public MessageComponent getComponent() {
        return component;
    }
}
