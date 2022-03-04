package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.project21.models.Joc;

public class GameActivity extends AppCompatActivity {

    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";

    Joc joc = new Joc();
    private  Button stop_button;
    private  Button pull_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView msg = findViewById(R.id.textView_pueva);

        joc.startGame();
        msg.setText(joc.printChat());

        stop_button = (Button) findViewById(R.id.stop_button);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopButtonActivity();
            }
        });
        pull_button = (Button) findViewById(R.id.pull_button);
        pull_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pullButtonActivity();
            }
        });




    }
    public String getMsg(){
        return joc.getChatLog();
    }

    void stopButtonActivity(){
        joc.esPlanta();
        TextView msg = findViewById(R.id.textView_pueva);
        msg.setText(joc.printChat());

        GameEndDialog dialog = GameEndDialog.newInstance(this);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(),GAME_END_DIALOG_TAG);

    }

    void pullButtonActivity(){
        joc.esDemana();
        TextView msg = findViewById(R.id.textView_pueva);
        msg.setText(joc.printChat());



    }

    public void showAlertDialogButtonClicked(View view) {

        // setup the alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("AlertDialog");
        builder.setMessage("Would you like to continue learning how to use Android alerts?");

        // add the buttons
        builder.setPositiveButton("Continue", null);
        builder.setNegativeButton("Cancel", null);

        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}