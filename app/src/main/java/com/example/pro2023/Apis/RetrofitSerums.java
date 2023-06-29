package com.example.pro2023.Apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSerums {
    private static RetrofitSerums instance = null;
    private APIUrl myApi;

    private RetrofitSerums() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(APIUrl.SER)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        myApi = retrofit.create(APIUrl.class);
    }

    public static synchronized RetrofitSerums getInstance() {
        if (instance == null) {
            instance = new RetrofitSerums();
        }
        return instance;
    }

    public APIUrl getMyApi() {
        return myApi;
    }
}
