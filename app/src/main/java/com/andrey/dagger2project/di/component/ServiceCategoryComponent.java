package com.andrey.dagger2project.di.component;

import com.andrey.dagger2project.api.ServiceCategoryApi;
import com.andrey.dagger2project.di.annotation.ApplicationScope;
import com.andrey.dagger2project.di.module.ContextModule;
import com.andrey.dagger2project.di.module.PicassoModule;
import com.andrey.dagger2project.di.module.ServiceCategoryModule;

import com.squareup.picasso.Picasso;

import dagger.Component;

@ApplicationScope
@Component(modules = {ServiceCategoryModule.class, ContextModule.class, PicassoModule.class})
public interface ServiceCategoryComponent {
    ServiceCategoryApi getServiceCategoryApi();
    Picasso getPicasso();
}
