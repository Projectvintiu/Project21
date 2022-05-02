package com.example.project21.viewmodel;

import androidx.lifecycle.MutableLiveData;

public class LoginViewModel {

    private String TAG = "LoginViewModel";

    private  MutableLiveData<String> emailLiveData;
    private  MutableLiveData<String> errorEmailLiveData;
    private  MutableLiveData<String> passwordLiveData;
    private  MutableLiveData<String> errorPasswordLiveData;

    public MutableLiveData<Boolean> isLogged;

    public LoginViewModel(){
        this.emailLiveData = new MutableLiveData<>();
        this.errorEmailLiveData = new MutableLiveData<>();
        this.passwordLiveData = new MutableLiveData<>();
        this.errorPasswordLiveData = new MutableLiveData<>();

        this.isLogged = new MutableLiveData<>();
    }

    public MutableLiveData<String> getEmailLiveData() {
        return emailLiveData;
    }

    public void setEmailLiveData(MutableLiveData<String> emailLiveData) {
        this.emailLiveData = emailLiveData;
    }

    public MutableLiveData<String> getErrorEmailLiveData() {
        return errorEmailLiveData;
    }

    public void setErrorEmailLiveData(MutableLiveData<String> errorEmailLiveData) {
        this.errorEmailLiveData = errorEmailLiveData;
    }

    public MutableLiveData<String> getPasswordLiveData() {
        return passwordLiveData;
    }

    public void setPasswordLiveData(MutableLiveData<String> passwordLiveData) {
        this.passwordLiveData = passwordLiveData;
    }

    public MutableLiveData<String> getErrorPasswordLiveData() {
        return errorPasswordLiveData;
    }

    public void setErrorPasswordLiveData(MutableLiveData<String> errorPasswordLiveData) {
        this.errorPasswordLiveData = errorPasswordLiveData;
    }

    public void login(){}
}
