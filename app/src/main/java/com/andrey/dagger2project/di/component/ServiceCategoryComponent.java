package com.andrey.dagger2project.di.component;

import com.andrey.dagger2project.api.ServiceApi;
import com.andrey.dagger2project.api.ServiceCategoryApi;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.di.module.ServiceCategoryModule;

import dagger.Component;

@ApplicationScope
@Component(modules = ServiceCategoryModule.class)
public interface ServiceCategoryComponent {
    ServiceCategoryApi getServiceCategoryApi();
    ServiceApi getServiceApi();
}
