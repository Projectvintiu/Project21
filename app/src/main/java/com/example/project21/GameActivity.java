package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project21.models.Carta;
import com.example.project21.models.Joc;

public class GameActivity extends AppCompatActivity {

    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    String TAG = "GameActivity";
    String TAGGAME = "GameChat";

    Joc joc = new Joc();
    private  Button stop_button;
    private  Button pull_button;
    private  Button playAgain_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        ImageView valorP = findViewById(R.id.number);
        ImageView valorD = findViewById(R.id.numberD);

        ImageView playerCard1 = findViewById(R.id.playerCard1);
        ImageView playerCard2 = findViewById(R.id.playerCard2);

        ImageView dealerCard1 = findViewById(R.id.dealerCard1);
        ImageView dealerCard2 = findViewById(R.id.dealerCard2);

        joc.startGame();
        Log.d(TAGGAME,"Empieza el juego");
        Log.d(TAGGAME,joc.getChatLog());


        playerCard1.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(0))));
        playerCard2.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(1))));

        dealerCard1.setImageDrawable(getDrawable(R.drawable.back_side));
        dealerCard2.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(1))));



        valorP.setImageDrawable(getDrawable(imageNumber(joc.playerDeck.cardsValue())));
        valorD.setImageDrawable(getDrawable(imageNumber(joc.dealerDeck.secondCardValue())));


        //TODO: @Didac. Us proposo que abans del taulell, es mostri una pantalla on es vegui el logo i un boto per començar a jugar. Aquest comença a jugar us ha de portar aquí al GameActivity. Ho teniu fet. Afegiu el logo que us quedara mes xula.
        //TODO: @Didac. Hem de millorar la part visual.

        //TODO: @Didac està bé la idea pero hauriem d'intentar utilitzar un viewmodel (dijous mirem com fer-ho).
        stop_button = (Button) findViewById(R.id.stop_button);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!joc.checkEndGame)
                stopButtonActivity();
            }
        });

        //TODO: @Didac està bé la idea pero hauriem d'intentar utilitzar un viewmodel (dijous mirem com fer-ho).

        pull_button = (Button) findViewById(R.id.pull_button);
        pull_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((!joc.checkEndGame) && (joc.playerDeck.cardsValue() <= 21))
                pullButtonActivity();
            }
        });

        //TODO: @Didac. Aquest botó podria estar només activat quan la partida ha acabat. Per defecte no s'hauria de deixar jugar.
        //TODO: @Didac. Inclús, per fer-ho millor es podria mostrar un DialogFragment que pregunti si vol tornar a jugar.
        //TODO: @Didac. Per anar bé, el resultat de la partida s'hauria de poder guardar en la part de backend un cop finalitzi. La petició de guardar/crear partida.
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
        ImageView valorD = findViewById(R.id.numberD);
        joc.esPlanta();
        Log.d(TAGGAME,joc.getChatLog());
        ImageView dealerCard1 = findViewById(R.id.dealerCard1);
        dealerCard1.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(0))));

        Log.d(TAGGAME,String.valueOf(joc.dealerDeck.deckSize()));

        ImageView dealerCard3 = findViewById(R.id.dealerCard3);
        ImageView dealerCard4 = findViewById(R.id.dealerCard4);
        ImageView dealerCard5 = findViewById(R.id.dealerCard5);
        ImageView dealerCard6 = findViewById(R.id.dealerCard6);
        if(joc.dealerDeck.deckSize() > 2){
            for(int i = 0; i < (joc.dealerDeck.deckSize() - 2); i++){
                switch(i + 3) {
                    case 3:
                        dealerCard3.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(2))));
                        break;
                    case 4:
                        dealerCard4.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(3))));
                        break;
                    case 5:
                        dealerCard5.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(4))));
                        break;
                    case 6:
                        dealerCard6.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(5))));
                        break;

                }
            }
        }
        valorD.setImageDrawable(getDrawable(imageNumber(joc.dealerDeck.cardsValue())));




    }

    /***
     * Funció que s'executa quan premem el boto de demanar una carta, el qual dona una carta mes al jugador
     *
     *
     * @version 1.0
     */
    void pullButtonActivity(){
        ImageView valorP = findViewById(R.id.number);
        ImageView playerCard3 = findViewById(R.id.playerCard3);
        ImageView playerCard4 = findViewById(R.id.playerCard4);
        ImageView playerCard5 = findViewById(R.id.playerCard5);
        ImageView playerCard6 = findViewById(R.id.playerCard6);
        joc.esDemana();
        Log.d(TAGGAME,joc.getChatLog());
        valorP.setImageDrawable(getDrawable(imageNumber(joc.playerDeck.cardsValue())));

        switch(joc.playerDeck.deckSize()) {
            case 3:
                playerCard3.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(2))));
                break;
            case 4:
                playerCard4.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(3))));
                break;
            case 5:
                playerCard5.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(4))));
                break;
            case 6:
                playerCard6.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(5))));
                break;

        }



    }

    /***
     * Funció que s'executa quan premem el boto de tornar a jugar, cosa que reinicia el joc per a que el
     * jugador pugui tornar a començar
     *
     *
     * @version 1.0
     */
    void playAgainActivity(){
        /*TextView msg = findViewById(R.id.textView_pueva);
        joc.setChatLog("");
        joc.startGame();
        msg.setText(joc.getChatLog());*/
        openGameActivity();
    }

    public void openGameActivity(){
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    //TODO @Didac: Això hauria d'estar implementat en la classe joc o carta
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


    public int imageNumber(int value){
        switch (value){
            case 1:
                return R.drawable.uno;
            case 2:
                return R.drawable.dos;
            case 3:
                return R.drawable.tres;
            case 4:
                return R.drawable.cuatro;
            case 5:
                return R.drawable.cinco;
            case 6:
                return R.drawable.seis;
            case 7:
                return R.drawable.siete;
            case 8:
                return R.drawable.ocho;
            case 9:
                return R.drawable.nueve;
            case 10:
                return R.drawable.diez;
            case 11:
                return R.drawable.once;
            case 12:
                return R.drawable.doce;
            case 13:
                return R.drawable.trece;
            case 14:
                return R.drawable.catorce;
            case 15:
                return R.drawable.quince;
            case 16:
                return R.drawable.dieziseis;
            case 17:
                return R.drawable.diezisiete;
            case 18:
                return R.drawable.dieziocho;
            case 19:
                return R.drawable.diezinueve;
            case 20:
                return R.drawable.veinte;
            case 21:
                return R.drawable.veintiuno;
            default:
                return R.drawable.zero;

        }

    }

}