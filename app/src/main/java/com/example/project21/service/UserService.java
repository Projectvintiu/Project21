package com.example.project21.service;

import com.example.project21.models.User;

import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.Call;
import retrofit2.http.Query;

public interface UserService {
    @POST("/user/register")
    Call<ResponseBody> createUser(@Body User user);

}


