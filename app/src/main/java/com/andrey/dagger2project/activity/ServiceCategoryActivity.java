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
import com.andrey.dagger2project.database.model.Subcategory;
import com.andrey.dagger2project.database.model.SubcategoryByCategory;
import com.andrey.dagger2project.database.repository.ServiceCategoryRepository;
import com.andrey.dagger2project.database.repository.SubcategoryByCategoryRepository;
import com.andrey.dagger2project.database.repository.SubcategoryRepository;
import com.andrey.dagger2project.di.component.RoomComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.database.model.ServiceCategory;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceCategoryActivity extends AppCompatActivity {
    private ServiceCategoryApi mServiceCategoryApi;
    private ServiceCategoryAdapter mAdapter;
    private List<ServiceCategory> mServiceCategoryList;
    private List<Subcategory> mSubcategoryList;

    @Inject
    ServiceCategoryRepository serviceCategoryRepository;
    @Inject
    SubcategoryRepository subcategoryRepository;
    @Inject
    SubcategoryByCategoryRepository subcategoryByCategoryRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mSubcategoryList = new ArrayList<>();
        mServiceCategoryList = new ArrayList<>();

        initRecyclerView();

        App app = (App) getApplication();
        ServiceCategoryComponent component = app.getServiceCategoryComponent();
        mServiceCategoryApi = component.getServiceCategoryApi();

        RoomComponent roomComponent = app.getRoomComponent();
        roomComponent.inject(this);

        serviceCategoryRepository.getAll().observe(this, mServiceCategoryList -> {
            mAdapter.setItem(mServiceCategoryList);
            mAdapter.notifyDataSetChanged();
        });

        if (mServiceCategoryList.isEmpty()){
            loadAllCategories();
        }
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
                if (response.isSuccessful()){
                    mServiceCategoryList = response.body();
                    serviceCategoryRepository.insertAll(mServiceCategoryList);
                    mAdapter.setItem(mServiceCategoryList);
                    mAdapter.notifyDataSetChanged();

                    for (ServiceCategory service: mServiceCategoryList){
                        mSubcategoryList.addAll(service.getChildren());
                    }

                    subcategoryRepository.insertAll(mSubcategoryList);

                    for (Subcategory subcategory: mSubcategoryList){
                        SubcategoryByCategory subcategoryByCategory = new SubcategoryByCategory();
                        subcategoryByCategory.setServiceCategoryId(subcategory.getParentId());
                        subcategoryByCategory.setSubcategoryId(subcategory.getId());
                        subcategoryByCategoryRepository.insert(subcategoryByCategory);
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ServiceCategory>> call, @NonNull Throwable t) {
                Toast.makeText(ServiceCategoryActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
