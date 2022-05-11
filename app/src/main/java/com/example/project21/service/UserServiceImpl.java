package com.example.project21.service;

import com.example.project21.models.User;
import com.example.project21.network.RetrofitClientInstance;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.Call;

public class UserServiceImpl implements UserService{

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<ResponseBody> createUser(User user) {
        return retrofit.create(UserService.class).createUser(user);
    }


}
