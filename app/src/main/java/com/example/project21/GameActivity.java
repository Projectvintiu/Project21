package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project21.models.Joc;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView msg = findViewById(R.id.textView_pueva);
        msg.setText("Se fue");

        Joc joc = new Joc();
        msg.setText(joc.startGame());


    }


}