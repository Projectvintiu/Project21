package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project21.models.Joc;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Joc j = new Joc();

        j.jugar();



    }
}