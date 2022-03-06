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
    private  Button playAgain_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView msg = findViewById(R.id.textView_pueva);

        joc.startGame();
        msg.setText(joc.getChatLog());

        stop_button = (Button) findViewById(R.id.stop_button);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!joc.checkEndGame)
                stopButtonActivity();
            }
        });
        pull_button = (Button) findViewById(R.id.pull_button);
        pull_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!joc.checkEndGame) && (joc.playerDeck.cardsValue() <= 21))
                pullButtonActivity();
            }
        });

        playAgain_button = (Button) findViewById(R.id.playAgain_button);
        playAgain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(joc.checkEndGame)
                playAgainActivity();
            }
        });




    }

    /***
     * getter de msg
     *
     * @return retorna el Log que es veu per pantalla
     *
     * @version 1.0
     */
    public String getMsg(){
        return joc.getChatLog();
    }

    /***
     * Funció que s'executa quan apreten el botto de plantarse, cosa que fa que es tingui que comprovar
     * qui es el guanyador de la partida
     *
     * @version 1.0
     */
    void stopButtonActivity(){
        joc.esPlanta();
        TextView msg = findViewById(R.id.textView_pueva);
        msg.setText(joc.getChatLog());

        /*

        GameEndDialog dialog = GameEndDialog.newInstance(this);
        dialog.setCancelable(false);
        dialog.show(getSupportFragmentManager(),GAME_END_DIALOG_TAG);
        */


    }

    /***
     * Funció que s'executa quan premem el boto de demanar una carta, el qual dona una carta mes al jugador
     *
     *
     * @version 1.0
     */
    void pullButtonActivity(){
        joc.esDemana();
        TextView msg = findViewById(R.id.textView_pueva);
        msg.setText(joc.getChatLog());



    }

    /***
     * Funció que s'executa quan premem el boto de tornar a jugar, cosa que reinicia el joc per a que el
     * jugador pugui tornar a començar
     *
     *
     * @version 1.0
     */
    void playAgainActivity(){
        TextView msg = findViewById(R.id.textView_pueva);
        joc.setChatLog("");
        joc.startGame();
        msg.setText(joc.getChatLog());

    }



}