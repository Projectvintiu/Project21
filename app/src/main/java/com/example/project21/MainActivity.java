package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.project21.utils.PreferencesProvider;

public class MainActivity extends AppCompatActivity {

    private Button start_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView trofeos = findViewById(R.id.trofeosImg);
        ImageView deaths = findViewById(R.id.deathImg);

        int copas = PreferencesProvider.providePreferences().getInt("trofeos", 0);
        trofeos.setImageDrawable(getDrawable(imageRedNumber(copas)));

        int muertes = PreferencesProvider.providePreferences().getInt("muertes", 0);
        deaths.setImageDrawable(getDrawable(imageRedNumber(muertes)));


        start_button = (Button) findViewById(R.id.start_button);
        start_button.setBackgroundColor(Color.WHITE);
        start_button.setTextColor(Color.BLACK);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        });
    }

    /**
     * Funció que es crida quan premem el boto de strat i que ens porta de MainActivity a GameActivity
     */
    public void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);

    }


    public int imageRedNumber(int value){
        switch (value){
            case 1:
                return R.drawable.runo;
            case 2:
                return R.drawable.rdos;
            case 3:
                return R.drawable.rtres;
            case 4:
                return R.drawable.rcuatro;
            case 5:
                return R.drawable.rcinco;
            case 6:
                return R.drawable.rseis;
            case 7:
                return R.drawable.rsiete;
            case 8:
                return R.drawable.rocho;
            case 9:
                return R.drawable.rnueve;
            case 10:
                return R.drawable.rdiez;
            default:
                return R.drawable.rzero;

        }

    }


}