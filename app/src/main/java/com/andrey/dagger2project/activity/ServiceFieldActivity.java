package com.andrey.dagger2project.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.andrey.dagger2project.R;
import com.andrey.dagger2project.database.model.Field;
import com.andrey.dagger2project.database.model.Service;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServiceFieldActivity extends AppCompatActivity {
    @BindView(R.id.linearLayout)
    LinearLayout layout;

    private HashMap<String, Field> fieldHashMap = new HashMap<>();

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

        generateEditText(fieldList);
    }

    private void generateEditText(List<Field> fieldList){
        for (Field field: fieldList){
            if (!field.isHidden()){
                if (!field.getName().equals("game_amount")){
                    fieldHashMap.put(field.getName(), field);

                    EditText et = new EditText(this);
                    et.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                    et.setHint(field.getTitle());

                    if (field.getType().equals("string")){
                        et.setInputType(InputType.TYPE_CLASS_TEXT);
                    }
                    else if (field.getType().equals("amount")){
                        et.setInputType(InputType.TYPE_CLASS_NUMBER);
                    }

                    layout.addView(et);
                }
            }
        }
    }
}
