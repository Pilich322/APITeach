package com.pilichevdeveloper.apiteach.api;

import com.pilichevdeveloper.apiteach.data.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIRequests {

    @GET("/posts")
    Call<List<Post>> getPosts();
    @GET("/posts/{id}")
    Call <List<Post>> getPosts(@Path("id") int id);
}
