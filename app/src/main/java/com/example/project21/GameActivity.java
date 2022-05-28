package com.example.project21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.project21.models.Carta;
import com.example.project21.models.Joc;
import com.example.project21.utils.PreferencesProvider;

public class GameActivity extends AppCompatActivity {

    private static final String GAME_END_DIALOG_TAG = "game_end_dialog_tag";
    String TAG = "GameActivity";
    String TAGGAME = "GameChat";

    public Joc joc = new Joc();
    private  Button stop_button;
    private  Button pull_button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        startGame();
        stop_button = (Button) findViewById(R.id.stop_button);
        stop_button.setBackgroundColor(Color.RED);
        stop_button.setTextColor(Color.WHITE);
        stop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!joc.checkEndGame)
                stopButtonActivity();

            }

        });

        pull_button = (Button) findViewById(R.id.pull_button);
        pull_button.setBackgroundColor(Color.BLACK);
        pull_button.setTextColor(Color.WHITE);
        pull_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((!joc.checkEndGame) && (joc.playerDeck.cardsValue() <= 21))
                pullButtonActivity();
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
        fiPartida();
        showEndGameDialog();



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

        if(joc.playerDeck.cardsValue() > 21){
            showEndGameDialog();
            fiPartida();
        }
    }

    public void fiPartida(){
        int trofeos = PreferencesProvider.providePreferences().getInt("trofeos", 0);
        int muertes = PreferencesProvider.providePreferences().getInt("muertes", 0);

        if(PreferencesProvider.providePreferences().getInt("videsP", 0) <= 0){
            PreferencesProvider.providePreferences().edit().putInt("muertes", muertes + 1).commit();
            PreferencesProvider.providePreferences().edit().putInt("videsP",10).commit();
            PreferencesProvider.providePreferences().edit().putInt("videsD",10).commit();
            openMainActivity();

        }else if(PreferencesProvider.providePreferences().getInt("videsD", 0) <= 0){
            PreferencesProvider.providePreferences().edit().putInt("trofeos", trofeos + 1).commit();
            PreferencesProvider.providePreferences().edit().putInt("videsP",10).commit();
            PreferencesProvider.providePreferences().edit().putInt("videsD",10).commit();
            openMainActivity();
        }

    }

    public void startGame(){
        ImageView valorP = findViewById(R.id.number);
        ImageView valorD = findViewById(R.id.numberD);

        ImageView videsPlayer = findViewById(R.id.videsPlayer);
        ImageView videsDealer = findViewById(R.id.videsDealer);

        ImageView playerCard1 = findViewById(R.id.playerCard1);
        ImageView playerCard2 = findViewById(R.id.playerCard2);
        ImageView playerCard3 = findViewById(R.id.playerCard3);
        ImageView playerCard4 = findViewById(R.id.playerCard4);
        ImageView playerCard5 = findViewById(R.id.playerCard5);
        ImageView playerCard6 = findViewById(R.id.playerCard6);

        ImageView dealerCard1 = findViewById(R.id.dealerCard1);
        ImageView dealerCard2 = findViewById(R.id.dealerCard2);
        ImageView dealerCard3 = findViewById(R.id.dealerCard3);
        ImageView dealerCard4 = findViewById(R.id.dealerCard4);
        ImageView dealerCard5 = findViewById(R.id.dealerCard5);
        ImageView dealerCard6 = findViewById(R.id.dealerCard6);

        joc.startGame();
        Log.d(TAGGAME,"Empieza el juego");
        Log.d(TAGGAME,joc.getChatLog());

        playerCard1.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(0))));
        playerCard2.setImageDrawable(getDrawable(imageCard(joc.playerDeck.getCarta(1))));
        playerCard3.setImageDrawable(getDrawable(R.drawable.transparent));
        playerCard4.setImageDrawable(getDrawable(R.drawable.transparent));
        playerCard5.setImageDrawable(getDrawable(R.drawable.transparent));
        playerCard6.setImageDrawable(getDrawable(R.drawable.transparent));

        dealerCard1.setImageDrawable(getDrawable(R.drawable.backcard));
        dealerCard2.setImageDrawable(getDrawable(imageCard(joc.dealerDeck.getCarta(1))));
        dealerCard3.setImageDrawable(getDrawable(R.drawable.transparent));
        dealerCard4.setImageDrawable(getDrawable(R.drawable.transparent));
        dealerCard5.setImageDrawable(getDrawable(R.drawable.transparent));
        dealerCard6.setImageDrawable(getDrawable(R.drawable.transparent));

        valorP.setImageDrawable(getDrawable(imageNumber(joc.playerDeck.cardsValue())));
        valorD.setImageDrawable(getDrawable(imageNumber(joc.dealerDeck.secondCardValue())));

        int videsP = PreferencesProvider.providePreferences().getInt("videsP", 0);
        int videsD = PreferencesProvider.providePreferences().getInt("videsD", 0);
        videsPlayer.setImageDrawable(getDrawable(imageRedNumber(videsP)));
        videsDealer.setImageDrawable(getDrawable(imageRedNumber(videsD)));
    }
    public void openMainActivity(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    public void showEndGameDialog(){
        final Dialog dialog = new Dialog(GameActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.dialog_end_game);
        dialog.getWindow().setGravity(Gravity.TOP);

        Button playAgainButton = dialog.findViewById(R.id.button_playAgain);
        Button exitButton = dialog.findViewById(R.id.button_exit);
        ImageView winOrLose = dialog.findViewById(R.id.winOrLoseImg);

        if(joc.getWinner() == 0)//perds
        {
            winOrLose.setImageDrawable(getDrawable(R.drawable.ulose));
        }else if(joc.getWinner() == 2){//guanyes
            winOrLose.setImageDrawable(getDrawable(R.drawable.uwin));
        }else{//empates
            winOrLose.setImageDrawable(getDrawable(R.drawable.utied));
        }

        playAgainButton.setOnClickListener((view) -> {
            dialog.dismiss();
            startGame();

        });
        exitButton.setOnClickListener((view) -> {
            openMainActivity();

        });

        dialog.show();

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