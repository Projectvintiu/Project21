package com.example.project21.models;

public class Joc {

    Baraja playingBaraja = new Baraja();
    public Baraja playerDeck = new Baraja();
    public Baraja dealerDeck = new Baraja();
    public boolean checkEndGame = false;
    public int winner = 0;

    public Joc() {
        playerDeck.setVides(10);
        dealerDeck.setVides(10);
    }

    String chatLog;


    /***
     * getter de guanyador
     * 0 perds 1 empate i 2 guanyes
     * @return guanyador
     */
    public int getWinner() {
        return winner;
    }
    /***
     * seter de guanyador
     * 0 perds 1 empate i 2 guanyes
     *
     */
    public void setWinner(int winner) {
        this.winner = winner;
    }

    /***
     * getter del parametre chatLog
     *
     * @return chatLog text que es mostra per pantalla
     *
     * @version 1.0
     */
    public String getChatLog(){
        return chatLog;
    }

    /***
     * setter del parametre chatLog
     *
     * @param chatlog text que es mostra per pantalla
     *
     * @version 1.0
     */
    public void setChatLog(String chatlog){
        chatLog = chatlog;
    }

    /***
     *  Funció per a comprovar si estem al mitg de un torn o si la partida ja sha acabat
     *
     * @return chekEndgame boolea public que comprova si ha finalitzat el joc
     *
     * @version 1.0
     */
    public boolean checkGameEnded(){
        return checkEndGame;
    }

    /***
     *Funció que es crida quan el jugador es planta
     *
     * @version 1.0
     */
    public void esPlanta(){
        chatLog = "";
        chatLog = "La teva ma es: " + playerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + playerDeck.cardsValue();

        chatLog = chatLog + "\n" + "La ma del dealer es: " + dealerDeck.toString();
        chatLog = chatLog + "\n" + "Amb un valor total de: " + dealerDeck.cardsValue();

        winner();

    }

    /***
     *Funció que es crida quan el jugador demana una carta
     *
     * @version 1.0
     */
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


    /***
     *  Funció que crea les baralles per el jugador, la ia i la baralla en la que es roben les cartes,
     *  es crida cada cop que vulguem començar una partida
     *
     * @return chatLog String que es va mostrant per pantalla
     *
     * @version 1.0
     */
    public String startGame(){

        checkEndGame = false;
        playerDeck.moveAllToBaraja(playingBaraja);
        dealerDeck.moveAllToBaraja(playingBaraja);

        playingBaraja.createFullDeck(); //Creem la baraja
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

    /***
     *  Funció que comprova qui es el guanyador de la partida i que finalment retorna les cartes del
     *  jugador i la ia a la baralla principal
     *
     *
     * @version 1.0
     */
    public void winner(){
        checkEndGame = true;
        if(playerDeck.cardsValue() > 21){
            chatLog = chatLog + "\n" + "Has passat de 21, el dealer ha guanyat";
            playerDeck.setVides(playerDeck.getVides() - 1);
            setWinner(0);
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
                dealerDeck.setVides(dealerDeck.getVides() - 1);
                setWinner(2);
            }else
            if(dealerDeck.cardsValue() > playerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "El dealer ha guanyat";
                playerDeck.setVides(playerDeck.getVides() - 1);
                setWinner(0);
            }else
            if(playerDeck.cardsValue() == dealerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "Has empatat";
                setWinner(1);
            }else
            if(playerDeck.cardsValue() > dealerDeck.cardsValue()){
                chatLog = chatLog + "\n" + "Has guanyat, la teva ma val: " + playerDeck.cardsValue() + " i la ma del dealer es de: " + dealerDeck.cardsValue();
                dealerDeck.setVides(dealerDeck.getVides() - 1);
                setWinner(2);
            }else{
                chatLog = chatLog + "\n" + "El dealer guanya, la teva ma val: " + playerDeck.cardsValue() + " i la ma del dealer es de: " + dealerDeck.cardsValue();
                setWinner(0);
                playerDeck.setVides(playerDeck.getVides() - 1);
            }
        }


        chatLog = chatLog + "\n" + "Fi de la partida";



    }




}
