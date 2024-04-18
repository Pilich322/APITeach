package com.pilichevdeveloper.apiteach;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;
import com.pilichevdeveloper.apiteach.api.APIRequests;
import com.pilichevdeveloper.apiteach.api.RetrofitManager;
import com.pilichevdeveloper.apiteach.data.Post;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    /*
    Перед началом работы необходимо зайти:
    Зайти в Manifest и прописать
    <uses-permission android:name="android.permission.INTERNET"/>
    File->ProjectStructure->dependencies и добавить библиотеки
    com.squareup.retrofit2:retrofit
    com.squareup.retrofit2:converter-gson
     */

    //Переменная, с которой будем работать для запросов к серверу
    APIRequests api = RetrofitManager.getRetrofit().create(APIRequests.class);

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        getPosts();
    }

    private void getPosts() {
        Call<List<Post>> listPost = api.getPosts();
        listPost.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        showPosts(response.body());
                    } else {
                        Log.e("Code","Response NULL");
                    }
                } else {
                    Log.e("CODE", response.code() + "");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Post>> call, @NonNull Throwable t) {
                Log.e("CODE", t.getMessage());
            }
        });
    }
   private void showPosts(List<Post> postsList) {
        tv.setText(postsList.toString());
   }
}