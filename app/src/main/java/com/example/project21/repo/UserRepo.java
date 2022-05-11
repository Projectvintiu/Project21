package com.example.project21.repo;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.project21.models.Result;
import com.example.project21.models.User;
import com.example.project21.service.UserService;
import com.example.project21.service.UserServiceImpl;


import okhttp3.ResponseBody;
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

        this.userService.createUser(user).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    Log.d(TAG, "Response ok");
                }
                registerResultLiveData.postValue(registerResult);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                registerResultLiveData.postValue(registerResult);
                Log.d(TAG, "Response FAIL");
            }
        });
    }

    //public LiveData<Result<String>> getReisterResult() {return this.registerResultLiveData;}

}
