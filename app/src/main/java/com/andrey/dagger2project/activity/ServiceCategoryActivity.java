package com.andrey.dagger2project.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andrey.dagger2project.App;
import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.ServiceCategoryAdapter;
import com.andrey.dagger2project.api.ServiceCategoryApi;
import com.andrey.dagger2project.database.repository.ServiceCategoryRepository;
import com.andrey.dagger2project.di.component.DaggerRoomComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.di.module.AppModule;
import com.andrey.dagger2project.di.module.RoomModule;
import com.andrey.dagger2project.model.ServiceCategory;
import com.andrey.dagger2project.model.Subcategory;

import java.util.List;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCategoryActivity extends AppCompatActivity {
    private ServiceCategoryApi mServiceCategoryApi;
    private ServiceCategoryAdapter mAdapter;
    private List<ServiceCategory> mServiceCategoryList;

    @Inject
    private ServiceCategoryRepository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initRecyclerView();

        App app = (App) getApplication();
        ServiceCategoryComponent component = app.getServiceCategoryComponent();
        mServiceCategoryApi = component.getServiceCategoryApi();

        DaggerRoomComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);


        loadAllCategories();
    }

    private void initRecyclerView(){
        RecyclerView mRecyclerView = findViewById(R.id.recycler_view_service_category);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ServiceCategoryAdapter(ServiceCategoryActivity.this, mServiceCategoryList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadAllCategories() {
        String expand = "children";
        Call<List<ServiceCategory>> serviceCategoryCall = mServiceCategoryApi.getAll(expand);
        serviceCategoryCall.enqueue(new Callback<List<ServiceCategory>>() {
            @Override
            public void onResponse(@NonNull Call<List<ServiceCategory>> call, @NonNull Response<List<ServiceCategory>> response) {
                mServiceCategoryList = response.body();
                mAdapter.setItem(mServiceCategoryList);
                mAdapter.notifyDataSetChanged();

                repository.insertAll(mServiceCategoryList);
            }

            @Override
            public void onFailure(@NonNull Call<List<ServiceCategory>> call, @NonNull Throwable t) {
                Toast.makeText(ServiceCategoryActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}