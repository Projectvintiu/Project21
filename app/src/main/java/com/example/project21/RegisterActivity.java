package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.project21.databinding.ActivityRegisterBinding;
import com.example.project21.utils.PreferencesProvider;
import com.example.project21.viewmodel.RegisterViewModel;


public class RegisterActivity extends AppCompatActivity {
    private RegisterViewModel registerViewModel;
    private ActivityRegisterBinding activityRegisterBinding;

    private String TAG = "RegisterActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        this.registerViewModel = new RegisterViewModel();
        initDataBinding();

        registerViewModel.getEmailLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "getEmailLiveData - > " + s);
            }

        });

        setup();
        //data();
    }

    private void initDataBinding() {
        activityRegisterBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_register);
        activityRegisterBinding.setRegisterViewModel(registerViewModel);
        activityRegisterBinding.setLifecycleOwner(this);


    }

    private void setup(){
        PreferencesProvider.init(this);
    }

    private void data(){
        //String token = PreferencesProvider.providePreferences().getString("token", "");
        //Log.d(TAG, "token: " + token);

        //startActivity(new Intent(this, GameActivity.class));


    }

}