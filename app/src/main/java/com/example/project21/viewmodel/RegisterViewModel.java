package com.example.project21.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.example.project21.models.User;
import com.example.project21.repo.UserRepo;
import com.example.project21.utils.AccountUtils;


public class RegisterViewModel {

    private String TAG = "Register Activity";

    public MutableLiveData<String> usernameLiveData;
    public MutableLiveData<String> emailLiveData;
    public MutableLiveData<String> nameLiveData;
    public MutableLiveData<String> surnameLiveData;
    public MutableLiveData<String> genderLiveData;
    public MutableLiveData<String> passwordLiveData;


    public UserRepo userRepo;

    public RegisterViewModel(){
        this.usernameLiveData = new MutableLiveData<>();
        this.emailLiveData = new MutableLiveData<>();
        this.nameLiveData = new MutableLiveData<>();
        this.surnameLiveData = new MutableLiveData<>();
        this.genderLiveData = new MutableLiveData<>();
        this.passwordLiveData = new MutableLiveData<>();

        this.userRepo = new UserRepo();
    }

    public void register() {
        Log.d(TAG, "In Register");


        String name = nameLiveData.getValue();
        String surname = surnameLiveData.getValue();
        String email = emailLiveData.getValue();
        String username = usernameLiveData.getValue();
        String password = passwordLiveData.getValue();
        String gender = genderLiveData.getValue();
        Log.d(TAG, "Name: --> " + name);
        Log.d(TAG, "surname: --> " + surname);
        Log.d(TAG, "email: --> " + email);
        Log.d(TAG, "username: --> " + username);
        Log.d(TAG, "password: --> " + password);
        Log.d(TAG, "gender: --> " + gender);

        User user = new User(username, password, email, name, surname, gender);
        this.userRepo.register(user);

        if(isFormValid(email, password, name, surname, username)){
            /*
            isRegisteredLiveData.postValue(true);
            User user = new User(username, email, name, surname, password);
            this.userRepo.registerUser(user);

             */
        }





    }

    private Boolean isFormValid(String email, String password, String name, String surname, String username){
        boolean isValid = true;

        String validEmail= AccountUtils.isEmailValid(email);
        if ( validEmail != null){
            isValid = false;
            ///errorEmailLiveData.postValue(validEmail);
        }
        if(password.length() < 6 ){
            isValid = false;
            ///Toast.makeText(getBaseContext(), "Password to short", Toast.LENGTH_SHORT).show();
        }
        if(name == null || surname == null || username == null){
            isValid = false;
        }

        return isValid;
    }


    public MutableLiveData<String> getUserNameLiveData() {
        return usernameLiveData;
    }

    public void setUserNameLiveData(MutableLiveData<String> userNameLiveData) {
        this.usernameLiveData = userNameLiveData;
    }

    public MutableLiveData<String> getEmailLiveData() {
        return emailLiveData;
    }

    public void setEmailLiveData(MutableLiveData<String> emailLiveData) {
        this.emailLiveData = emailLiveData;
    }

    public MutableLiveData<String> getNameLiveData() {
        return nameLiveData;
    }

    public void setNameLiveData(MutableLiveData<String> nameLiveData) {
        this.nameLiveData = nameLiveData;
    }

    public MutableLiveData<String> getSurnameLiveData() {
        return surnameLiveData;
    }

    public void setSurnameLiveData(MutableLiveData<String> surnameLiveData) {
        this.surnameLiveData = surnameLiveData;
    }

    public MutableLiveData<String> getGenderLiveData() {
        return genderLiveData;
    }

    public void setGenderLiveData(MutableLiveData<String> genderLiveData) {
        this.genderLiveData = genderLiveData;
    }

    public MutableLiveData<String> getPasswordLiveData() {
        return passwordLiveData;
    }

    public void setPasswordLiveData(MutableLiveData<String> passwordLiveData) {
        this.passwordLiveData = passwordLiveData;
    }
}

