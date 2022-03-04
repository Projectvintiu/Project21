package com.example.project21.models;

public class Joc {

    Baraja playingBaraja = new Baraja();
    Baraja playerDeck = new Baraja();
    Baraja dealerDeck = new Baraja();

    String chatLog;

    public String getChatLog(){
        return chatLog;
    }


    public void esPlanta(){
        chatLog = "";
        chatLog = "La teva ma es: " + playerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + playerDeck.cardsValue();

        chatLog = chatLog + "\n" + "La ma del dealer es: " + dealerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + dealerDeck.cardsValue();

        winner();

    }

    public void esDemana(){
        playerDeck.draw(playingBaraja);

        chatLog = "";
        chatLog = "La teva nova ma es: " + playerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + playerDeck.cardsValue();

        chatLog = chatLog + "\n" + "La primera carta del dealer es: " + dealerDeck.getCarta(0).toString();

        if(playerDeck.cardsValue() > 21){
            winner();
        }

    }

    public String printChat(){
        return chatLog;
    }


    public String startGame(){

        playingBaraja.createFullDeck(); //Creem la baraja
        Boolean fi = false;
        playingBaraja.shuffle();  //Barrejem la baralla


        playerDeck.draw(playingBaraja);
        playerDeck.draw(playingBaraja);

        dealerDeck.draw(playingBaraja);
        dealerDeck.draw(playingBaraja);


        chatLog = "La teva ma es: " + playerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + playerDeck.cardsValue();
        chatLog = chatLog + "\n" + "La primera carta del dealer es: " + dealerDeck.getCarta(0).toString();


        return chatLog;


    }

    public void winner(){
        if(playerDeck.cardsValue() > 21){
            chatLog = chatLog + "\n" + "Has passat de 21, el dealer ha guanyat";
        }else{
            //Dealer agafa cartes fins que es pasa de 21 o es > player
            if(dealerDeck.cardsValue() < playerDeck.cardsValue()){
                while(dealerDeck.cardsValue() < playerDeck.cardsValue()){
                    dealerDeck.draw(playingBaraja);
                }
                chatLog = chatLog + "\n" + "El diler agafa cartes i la seva ma final es: " + dealerDeck.toString();
                chatLog = chatLog + "\n" + "La ma final del dealer te un valor de: " + dealerDeck.cardsValue();
            }
            if(dealerDeck.cardsValue() > 21){
                chatLog = chatLog + "\n" + "Has guanyat!!";
            }else
            if(dealerDeck.cardsValue() > playerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "El dealer ha guanyat";
            }else
            if(playerDeck.cardsValue() == dealerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "Has empatat";
            }else
            if(playerDeck.cardsValue() > dealerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "Has guanyat, la teva ma val: " + playerDeck.cardsValue() + " i la ma del dealer es de: " + dealerDeck.cardsValue();
            }else{
                chatLog = chatLog + "\n" + "El dealer guanya, la teva ma val: " + playerDeck.cardsValue() + " i la ma del dealer es de: " + dealerDeck.cardsValue();
            }
        }
        playerDeck.moveAllToBaraja(playingBaraja);
        dealerDeck.moveAllToBaraja(playingBaraja);

        chatLog = chatLog + "\n" + "Fi de la partida";
    }




}
