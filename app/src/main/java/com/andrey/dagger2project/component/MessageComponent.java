package com.andrey.dagger2project.component;

import com.andrey.dagger2project.MessageApplicationScope;
import com.andrey.dagger2project.api.MessageApi;
import com.andrey.dagger2project.module.MessageModule;

import dagger.Component;

@MessageApplicationScope
@Component (modules = MessageModule.class)
public interface MessageComponent {
    MessageApi getMessageApi();
}
