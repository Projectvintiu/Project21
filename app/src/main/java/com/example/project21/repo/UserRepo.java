package com.example.project21.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.project21.models.Account;
import com.example.project21.models.Result;
import com.example.project21.models.User;
import com.example.project21.service.AccountServiceImpl;
import com.example.project21.service.UserService;
import com.example.project21.service.UserServiceImpl;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepo {
    private UserService userService;
    private Result<String> registerResult;
    private MutableLiveData<Result<String>> registerResultLiveData;
    private String TAG = "User repo";

    public UserRepo(){
        this.userService = new UserServiceImpl();
        registerResultLiveData = new MutableLiveData<>();

    }

    public void register(User user) {
/*
        this.userService.createUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d(TAG, "register() -> onResponseSuccess -> " + response.body().toString());
                int id_user = response.body().getId();
                Log.d(TAG, "register() -> onResponseSuccess -> " + id_user);
                registerResult = Result.success(response.body().getUsername());
                Log.d(TAG, "register() -> onResponseSuccess / getResult-> " + registerResult.getResult());
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "register() -> onResponseSuccess END");
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                registerResult = Result.error(t);
                registerResultLiveData.postValue(regi);
                Log.d(TAG, "register() -> onResponseError -> " + t.getMessage());
            }
        });

 */
    }

}
