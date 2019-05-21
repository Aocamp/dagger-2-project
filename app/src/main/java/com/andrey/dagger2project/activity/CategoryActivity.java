package com.andrey.dagger2project.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.api.ServiceCategoryApi;
import com.andrey.dagger2project.di.component.DaggerServiceCategoryComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.di.module.ContextModule;
import com.squareup.picasso.Picasso;

public class CategoryActivity extends AppCompatActivity {
    ServiceCategoryApi serviceCategoryApi;
    Picasso picasso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ServiceCategoryComponent component = DaggerServiceCategoryComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
        picasso = component.getPicasso();
        serviceCategoryApi = component.getServiceCategoryApi();
    }
}
