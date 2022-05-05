package com.example.project21.service;

import com.example.project21.models.Account;
import com.example.project21.network.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Retrofit;

public class AccountServiceImpl implements AccountService {

    private Retrofit retrofit = RetrofitClientInstance.getRetrofitInstance();

    @Override
    public Call<Account> createTokenUser(String authorizationToken) {
        return  retrofit.create(AccountService.class).createTokenUser(authorizationToken);
    }

}
