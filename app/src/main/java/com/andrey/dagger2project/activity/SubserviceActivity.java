package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.SubserviceAdapter;
import com.andrey.dagger2project.database.model.Service;
import com.andrey.dagger2project.database.model.SubService;
import com.google.gson.Gson;

import java.util.List;

public class SubserviceActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private SubserviceAdapter mAdapter;
    private List<SubService> mSubServiceList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subservice);

        initRecyclerView();

        loadAllCategories();
    }

    private void initRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view_subservice);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SubserviceAdapter(SubserviceActivity.this, mSubServiceList);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void loadAllCategories() {
        Intent intent = getIntent();
        Gson gson = new Gson();
        Service category = gson.fromJson(intent.getStringExtra("service"), Service.class);
        mSubServiceList = category.getChildren();
        mAdapter.setItem(mSubServiceList);
        mAdapter.notifyDataSetChanged();
    }

}
