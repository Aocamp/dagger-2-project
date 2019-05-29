package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andrey.dagger2project.App;
import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.SubcategoryAdapter;
import com.andrey.dagger2project.database.model.Subcategory;
import com.andrey.dagger2project.database.model.SubcategoryByCategory;
import com.andrey.dagger2project.database.repository.SubcategoryByCategoryRepository;
import com.andrey.dagger2project.database.repository.SubcategoryRepository;
import com.andrey.dagger2project.di.component.RoomComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SubcategoryActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SubcategoryAdapter mAdapter;
    private List<Subcategory> mSubcategoryList;
    private List<SubcategoryByCategory> mSubcategoryByCategoryList;

    @Inject
    SubcategoryRepository subcategoryRepository;

    @Inject
    SubcategoryByCategoryRepository subcategoryByCategoryRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subcategory);

        mSubcategoryList = new ArrayList<>();
        mSubcategoryByCategoryList = new ArrayList<>();

        App app = (App) getApplication();
        RoomComponent roomComponent = app.getRoomComponent();
        roomComponent.inject(this);

        initRecyclerView();

        loadAllCategories();
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view_subcategory);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubcategoryAdapter(SubcategoryActivity.this, mSubcategoryList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadAllCategories() {
        Intent intent = getIntent();
        Long id = intent.getLongExtra("id", 0);
        subcategoryByCategoryRepository.getAllByCategoryId(id).observe(this, mSubcategoryByCategoryList -> {
             for (SubcategoryByCategory category: mSubcategoryByCategoryList){
                 subcategoryRepository.getByCategoryId(category.getServiceCategoryId()).observe(this, subcategory -> {
                     mSubcategoryList.add(subcategory);
                 });
             }
        });
        mAdapter.setItem(mSubcategoryList);
        mAdapter.notifyDataSetChanged();
    }
}
