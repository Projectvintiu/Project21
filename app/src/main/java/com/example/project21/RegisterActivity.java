package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        registerViewModel = new RegisterViewModel();
        initDataBinding();

        registerViewModel.getEmailLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "getEmailLiveData - > " + s);
            }

        });

        setup();


        Button done = findViewById(R.id.btn_done);
        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerViewModel.register();
                openLoginActivity();
            }
        });


        registerViewModel.getIsRegistered().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                registerViewModel.isRegistered.postValue(false);


            }
        });

        registerViewModel.isRegistered.postValue(false);




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
    public void openLoginActivity(){
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);

    }

}