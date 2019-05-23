package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.SubcategoryAdapter;
import com.andrey.dagger2project.model.Subcategory;
import com.andrey.dagger2project.model.ServiceCategory;
import com.google.gson.Gson;

import java.util.List;

public class SubcategoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SubcategoryAdapter mAdapter;
    private List<Subcategory> mServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        initRecyclerView();

        loadAllCategories();
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view_service_subcategory);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubcategoryAdapter(SubcategoryActivity.this, mServiceList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadAllCategories() {
        Intent intent = getIntent();
        Gson gson = new Gson();
        ServiceCategory category = gson.fromJson(intent.getStringExtra("subcategories"), ServiceCategory.class);
        mServiceList = category.getChildren();
        mAdapter.setItem(mServiceList);
        mAdapter.notifyDataSetChanged();
    }
}
