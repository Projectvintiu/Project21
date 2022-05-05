package com.example.project21.service;

import com.example.project21.models.Account;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface AccountService {

    @POST("account/create_token")
    Call<Account> createTokenUser(@Header("Authorization") String autorizationToken);

}


