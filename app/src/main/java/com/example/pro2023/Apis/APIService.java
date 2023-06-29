package com.example.pro2023.Apis;

import com.example.pro2023.model.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {
    @FormUrlEncoded
    @POST("checkUser.php")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );






}
