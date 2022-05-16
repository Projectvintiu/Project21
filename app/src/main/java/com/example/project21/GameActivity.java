package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project21.models.Carta;
import com.example.project21.models.Joc;

public class GameActivity extends AppCompatActivity {

    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    String TAG = "GameActivity";

    Joc joc = new Joc();
    private  Button stop_button;
    private  Button pull_button;
    private  Button playAgain_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        TextView msg = findViewById(R.id.textView_pueva);
        ImageView playerCard = findViewById(R.id.cardViewPlayer);

        joc.startGame();
        msg.setText(joc.getChatLog());
        Log.d(TAG, "Esta es la carta que se imprimira --> " + joc.playerDeck.getCarta(0).toString());
        playerCard.setImageAlpha(imageCard(joc.playerDeck.getCarta(0)));

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

    //Intento de poner las imagenes en pantalla
    public int imageCard(Carta card){
        switch (card.toString()){
            case "PIQUES-A":
                return R.drawable.ace_of_spades;
            case "PIQUES-DOS":
                return R.drawable.two_of_spades;
            case "PIQUES-TRES":
                return R.drawable.three_of_spades;
            case "PIQUES-QUATRE":
                return R.drawable.four_of_spades;
            case "PIQUES-CINC":
                return R.drawable.five_of_spades;
            case "PIQUES-SIS":
                return R.drawable.six_of_spades;
            case "PIQUES-SET":
                return R.drawable.seven_of_spades;
            case "PIQUES-VUIT":
                return R.drawable.eight_of_spades;
            case "PIQUES-NOU":
                return R.drawable.nine_of_spades;
            case "PIQUES-DEU":
                return R.drawable.ten_of_spades;
            case "PIQUES-J":
                return R.drawable.jack_of_spades;
            case "PIQUES-Q":
                return R.drawable.queen_of_spades;
            case "PIQUES-K":
                return R.drawable.king_of_spades;
            case "DIAMANT-A":
                return R.drawable.ace_of_diamonds;
            case "DIAMANT-DOS":
                return R.drawable.two_of_diamonds;
            case "DIAMANT-TRES":
                return R.drawable.three_of_diamonds;
            case "DIAMANT-QUATRE":
                return R.drawable.four_of_diamonds;
            case "DIAMANT-CINC":
                return R.drawable.five_of_diamonds;
            case "DIAMANT-SIS":
                return R.drawable.six_of_diamonds;
            case "DIAMANT-SET":
                return R.drawable.seven_of_diamonds;
            case "DIAMANT-VUIT":
                return R.drawable.eight_of_diamonds;
            case "DIAMANT-NOU":
                return R.drawable.nine_of_diamonds;
            case "DIAMANT-DEU":
                return R.drawable.ten_of_diamonds;
            case "DIAMANT-J":
                return R.drawable.jack_of_diamonds;
            case "DIAMANT-Q":
                return R.drawable.queen_of_diamonds;
            case "DIAMANT-K":
                return R.drawable.king_of_diamonds;
            case "COR-A":
                return R.drawable.ace_of_hearts;
            case "COR-DOS":
                return R.drawable.two_of_hearts;
            case "COR-TRES":
                return R.drawable.three_of_hearts;
            case "COR-QUATRE":
                return R.drawable.four_of_hearts;
            case "COR-CINC":
                return R.drawable.five_of_hearts;
            case "COR-SIS":
                return R.drawable.six_of_hearts;
            case "COR-SET":
                return R.drawable.seven_of_hearts;
            case "COR-VUIT":
                return R.drawable.eight_of_hearts;
            case "COR-NOU":
                return R.drawable.nine_of_hearts;
            case "COR-DEU":
                return R.drawable.ten_of_hearts;
            case "COR-J":
                return R.drawable.jack_of_hearts;
            case "COR-Q":
                return R.drawable.queen_of_hearts;
            case "COR-K":
                return R.drawable.king_of_hearts;
            case "TREBOL-A":
                return R.drawable.ace_of_clubs;
            case "TREBOL-DOS":
                return R.drawable.two_of_clubs;
            case "TREBOL-TRES":
                return R.drawable.three_of_clubs;
            case "TREBOL-QUATRE":
                return R.drawable.four_of_clubs;
            case "TREBOL-CINC":
                return R.drawable.five_of_clubs;
            case "TREBOL-SIS":
                return R.drawable.six_of_clubs;
            case "TREBOL-SET":
                return R.drawable.seven_of_clubs;
            case "TREBOL-VUIT":
                return R.drawable.eight_of_clubs;
            case "TREBOL-NOU":
                return R.drawable.nine_of_clubs;
            case "TREBOL-DEU":
                return R.drawable.ten_of_clubs;
            case "TREBOL-J":
                return R.drawable.jack_of_clubs;
            case "TREBOL-Q":
                return R.drawable.queen_of_clubs;
            case "TREBOL-K":
                return R.drawable.king_of_clubs;
            default:
                return R.drawable.joker;
        }
    }

}