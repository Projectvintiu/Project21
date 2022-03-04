package com.example.project21.models;

public class Joc {
    public Jugador player;
    public Jugador ia;
    public Baraja baraja;

    public Jugador getPlayer() {
        return player;
    }
    public void setPlayer(Jugador player) {
        this.player = player;
    }
    public Jugador getIa() {
        return ia;
    }
    public void setIa(Jugador ia) {
        this.ia = ia;
    }
    public Baraja getBaraja() {
        return baraja;
    }
    public void setBaraja(Baraja baraja) {
        this.baraja = baraja;
    }


    public String startGame(){
        Baraja playingBaraja = new Baraja();
        playingBaraja.createFullDeck(); //Creem la baraja
        Boolean fi = false;
        playingBaraja.shuffle();  //Barrejem la baralla

        String res = "";

        //Crear baraja per el jugador i el dealer
        Baraja playerDeck = new Baraja();
        Baraja dealerDeck = new Baraja();

        playerDeck.draw(playingBaraja);
        playerDeck.draw(playingBaraja);

        dealerDeck.draw(playingBaraja);
        dealerDeck.draw(playingBaraja);


        res = "La teva ma es: " + playerDeck.toString();
        res = res + "\n" + "Amb un valor total de: " + playerDeck.cardsValue();
        res = res + "\n" + "La primera carta del dealer es: " + dealerDeck.getCarta(0).toString();


        return res;


    }

    public void jugar(){
        Baraja playingBaraja = new Baraja();
        playingBaraja.createFullDeck(); //Creem la baraja
        Boolean fi = false;
        playingBaraja.shuffle();  //Barrejem la baralla

        //Crear baraja per el jugador i el dealer
        Baraja playerDeck = new Baraja();
        Baraja dealerDeck = new Baraja();



        //Game loop
        /*
        while(fi == false){
            //Donem dos cartes al jugador i al dealer
            playerDeck.draw(playingBaraja);
            playerDeck.draw(playingBaraja);

            dealerDeck.draw(playingBaraja);
            dealerDeck.draw(playingBaraja);


            while(true){
                //System.out.println("La teva ma es: ");
                //System.out.print(playerDeck.toString()); //cartes que tens
                //System.out.println("la teva ma te un valor de: " + playerDeck.cardsValue());
                //System.out.println("La primera carta del dealer es: " + dealerDeck.getCarta(0).toString());

                System.out.println("Si vols una altre carta apreta 1 si et vols plantar 2");
                int response = usuerInput.nextInt();
                if(response == 1){
                    playerDeck.draw(playingBaraja);
                    System.out.println("Has tret un: " + playerDeck.getCarta(playerDeck.deckSize() - 1).toString());
                    if(playerDeck.cardsValue() > 21){
                        System.out.println("GAME OVER, el valor de les teves cartes es de: " + playerDeck.cardsValue() + " el qual es mes de 21");
                        fi = true;
                        break;
                    }
                }
                if(resposne == 2){
                    break;
                }

            }
            //revelem les cartes del dealer
            System.out.println("Les Calrtes del dealer son: " + dealerDeck.toString());
            //mirar si el dealer te mes punts que el player
            if(dealerDeck.cardsValue() > playerDeck.cardsValue()){
                System.out.println("El dealer ha guanyat");
            }//si el dealer te un valor mes petit que el jugador treura cartes fins que guanyi empati o es pasi
            while(dealerDeck.cardsValue() <= playerDeck.cardsValue()){
                dealerDeck.draw(playerDeck);
                System.out.println("El dealer ha tret un: " + dealerDeck.getCarta(dealerDeck.deckSize() - 1).toString());

            }
            System.out.println("La ma final del dealer te un valor de: " + dealerDeck.cardsValue());
            if(dealerDeck.cardsValue() > 21){
                System.out.println("Has guanyat!!");

            }
            if(playerDeck.cardsValue() == dealerDeck.cardsValue()){
                System.out.println("Empate");
            }
            if(playerDeck.cardsValue() > dealerDeck.cardsValue()){
                System.out.println("Has guanyat, la teva ma val: " + playerDeck.cardsValue() + " i la ma del dealer es de: " + dealerDeck.cardsValue());
            }else{
                System.out.println("El dealer guanya te millor puntacio que tu");
            }

            playerDeck.moveAllToBaraja(playingBaraja);
            dealerDeck.moveAllToBaraja(playingBaraja);

            System.out.println("Fi de la partida");



        }*/




    }


}
