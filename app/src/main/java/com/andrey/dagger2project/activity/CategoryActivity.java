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
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.model.ServiceCategory;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryActivity extends AppCompatActivity {
    private ServiceCategoryApi serviceCategoryApi;

    private RecyclerView mRecyclerView;
    private ServiceCategoryAdapter mAdapter;

    private List<ServiceCategory> serviceCategoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        mRecyclerView = findViewById(R.id.recycler_view_service_category);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ServiceCategoryAdapter(CategoryActivity.this, serviceCategoryList);
        mRecyclerView.setAdapter(mAdapter);

        App app = (App) getApplication();
        ServiceCategoryComponent component = app.getServiceCategoryComponent();
        serviceCategoryApi = component.getServiceCategoryApi();

        loadAllCategories();
    }

    private void loadAllCategories() {
        Call<List<ServiceCategory>> serviceCategoryCall = serviceCategoryApi.getAll();
        serviceCategoryCall.enqueue(new Callback<List<ServiceCategory>>() {
            @Override
            public void onResponse(@NonNull Call<List<ServiceCategory>> call, @NonNull Response<List<ServiceCategory>> response) {
                List<ServiceCategory> message = response.body();
                mAdapter.setItem(message);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<ServiceCategory>> call, @NonNull Throwable t) {
                Toast.makeText(CategoryActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
