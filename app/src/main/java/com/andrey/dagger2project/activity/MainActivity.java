package com.andrey.dagger2project.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.andrey.dagger2project.App;
import com.andrey.dagger2project.R;
import com.andrey.dagger2project.adapter.MessageAdapter;
import com.andrey.dagger2project.api.MessageApi;
import com.andrey.dagger2project.di.component.MessageComponent;
import com.andrey.dagger2project.database.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private MessageApi messageApi;

    private RecyclerView mRecyclerView;
    private MessageAdapter mAdapter;

    private List<Message> messageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recycler_view_messages);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MessageAdapter(MainActivity.this, messageList);
        mRecyclerView.setAdapter(mAdapter);

        App app = (App) getApplication();
        MessageComponent component = app.getMessageComponent();
        messageApi = component.getMessageApi();

        loadAllMessages();
    }

    private void loadAllMessages() {
        Call<List<Message>> messageCall = messageApi.getAllMessages();
        messageCall.enqueue(new Callback<List<Message>>() {
            @Override
            public void onResponse(@NonNull Call<List<Message>> call, @NonNull Response<List<Message>> response) {
                 List<Message> message = response.body();
                 mAdapter.setItem(message);
                 mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(@NonNull Call<List<Message>> call, @NonNull Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
