package com.andrey.dagger2project.api;

import com.andrey.dagger2project.model.Message;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessageApi {
    @GET("messages")
    Call<List<Message>> getAllMessages();
}
