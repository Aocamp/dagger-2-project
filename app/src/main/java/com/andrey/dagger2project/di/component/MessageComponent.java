package com.andrey.dagger2project.di.component;

import com.andrey.dagger2project.api.MessageApi;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.di.module.MessageModule;

import dagger.Component;

@ApplicationScope
@Component (modules = MessageModule.class)
public interface MessageComponent {
    MessageApi getMessageApi();
}
