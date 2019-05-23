package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andrey.dagger2project.App;
import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.MessageAdapter;
import com.andrey.dagger2project.adapter.ServiceAdapter;
import com.andrey.dagger2project.api.ServiceApi;
import com.andrey.dagger2project.di.component.MessageComponent;
import com.andrey.dagger2project.di.component.ServiceCategoryComponent;
import com.andrey.dagger2project.model.Message;
import com.andrey.dagger2project.model.Service;
import com.andrey.dagger2project.model.ServiceCategory;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ServiceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ServiceAdapter mAdapter;
    private List<Service> mServiceList;
    private ServiceApi mServiceApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        mRecyclerView = findViewById(R.id.recycler_view_service);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ServiceAdapter(ServiceActivity.this, mServiceList);
        mRecyclerView.setAdapter(mAdapter);

        App app = (App) getApplication();
        ServiceCategoryComponent component = app.getServiceCategoryComponent();
        mServiceApi = component.getServiceApi();

        loadAllMessages();
    }

    private void loadAllMessages() {
        Intent intent = getIntent();
        Long id = intent.getLongExtra("id", 0);
        Call<List<Service>> serviceCall = mServiceApi.getBySubcategoryId(id);
        serviceCall.enqueue(new Callback<List<Service>>() {
            @Override
            public void onResponse(@NonNull Call<List<Service>> call, @NonNull Response<List<Service>> response) {
                mServiceList = response.body();
                mAdapter.setItem(mServiceList);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<Service>> call, @NonNull Throwable t) {
                Toast.makeText(ServiceActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
