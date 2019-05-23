package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.model.Field;
import com.andrey.dagger2project.model.Service;
import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceFieldActivity extends AppCompatActivity {
    @BindView(R.id.et_account)
    EditText account;
    @BindView(R.id.et_amount)
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_field);
        ButterKnife.bind(this);

        loadFields();
    }

    private void loadFields(){
        Intent intent = getIntent();
        Gson gson = new Gson();
        Service field = gson.fromJson(intent.getStringExtra("service"), Service.class);
        List<Field> fieldList = field.getFields();
        for (Field field1: fieldList){
            if (field1.getName().equals("account")){
                account.setHint(field1.getMask());
            }else if (field1.getName().equals("amount")){
                amount.setHint(field1.getTitle());
            }
        }
    }
}
