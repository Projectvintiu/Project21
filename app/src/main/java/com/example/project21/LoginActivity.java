package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.project21.databinding.ActivityLoginBinding;
import com.example.project21.models.Result;
import com.example.project21.utils.PreferencesProvider;
import com.example.project21.utils.UIUtils;
import com.example.project21.viewmodel.LoginViewModel;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel loginViewModel;
    private ActivityLoginBinding activityLoginBinding;
    private Button btnRegister;


    private String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginViewModel = new LoginViewModel();
        initDataBinding();

        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegisterActivity();
            }
        });

        loginViewModel.getEmailLiveData().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Log.d(TAG, "getEmailLiveData - > " + s);
            }
        });

        setup();
        data();

        loginViewModel.isUserLogged().observe(this, new Observer<Result<String>>() {
            @Override
            public void onChanged(Result<String> tokenResult) {
                loginViewModel.isLogged.postValue(false);
                if (tokenResult.getResult() != null){
                    Log.d(TAG,"Login successful, token obtained.");
                    PreferencesProvider.providePreferences().edit().putString("token",
                            tokenResult.getResult()).commit();
                    Log.d(TAG,"Login successful, add token to SharedPreferences.");
                    openGameActivity();
                }
                else{
                    //Display Error
                    Log.d(TAG,"User not logged, token not obtained.");
                    Toast.makeText(getBaseContext(), "Error Login", Toast.LENGTH_SHORT).show();
                    //showLoginError(tokenResult.getError().getMessage());
                }
            }
        });





    }
    private void showLoginError(String errorMessage){
        //DialogInterface.OnClickListener positiveAction = (dialogInterface, i) -> dialogInterface.cancel();
        //UIUtils.showAlert(this,"Error", errorMessage, "Ok",positiveAction ,null,null, false);
    }

    private void initDataBinding() {
        activityLoginBinding =
                DataBindingUtil.setContentView(this,R.layout.activity_login);
        activityLoginBinding.setLoginViewModel(loginViewModel);
        activityLoginBinding.setLifecycleOwner(this);


    }

    public void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }

    public void openRegisterActivity(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    private void setup(){
        PreferencesProvider.init(this);
    }

    private void data(){
        String token = PreferencesProvider.providePreferences().getString("token", "");
        Log.d(TAG, "token: " + token);
        if (token.equals("")) {
            // If device has no token -> go to LoginActivity()
            //startActivity(new Intent(this, LoginActivity.class));
            //showLogin();
        } else {
            // If a userToken is stored on sharedPreferences go to MainActivity().
            startActivity(new Intent(this, GameActivity.class));
        }
        // Close the activity, the user don't need to enter again with back functionality
        //finish();
    }

}