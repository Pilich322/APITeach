package com.pilichevdeveloper.apiteach.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    static Retrofit retrofit;
    public static  Retrofit getRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
