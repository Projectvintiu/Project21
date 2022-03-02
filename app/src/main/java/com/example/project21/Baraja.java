package com.example.project21;

import com.example.project21.models.Numeros;
import com.example.project21.models.Palos;

import java.util.ArrayList;
import java.util.Random;

public class Baraja {

    //instacia
    private ArrayList<Carta> cartas;

    //Constructor
    public Baraja(){
        this.cartas = new ArrayList<Carta>();
    }


    public void createFullDeck(){

        for(Palos cardPalo : Palos.values()){ // itera dins dels "4" palos que tinguem
            for(Numeros cardNumero : Numeros.values()){ //itera dins del numero de cartes que tingeum
                this.cartas.add(new Carta(cardPalo, cardNumero));
            }
        }

    }

    // Creem una barja temporal on anirem afegint cartes de index aleatori de la baralla
    // Fins a deixar la baralla original buida i la temporal plena pero ordenada aleatoriament
    // i finalment igualem la baraja original a la temporal
    public void shuffle(){
        ArrayList<Carta> tmpBaraja = new ArrayList<Carta>();
        Random random = new Random();

        int randCardIndex = 0;
        int originalSize = this.cartas.size();

        for(int i = 0; i < originalSize; i++){
            //Generar Random --> rand.nextInt((max - min)  + 1) + min;
            randCardIndex = random.nextInt((this.cartas.size() - 1 - 0)+ 1) + 0;
            tmpBaraja.add(this.cartas.get(randCardIndex)); //Afegim a la baralla temporal
            this.cartas.remove(randCardIndex);
        }

        this.cartas = tmpBaraja;
    }

    //Enviar cartes de una baralla a una altre
    public void draw(Baraja comingFrom){
        this.cartas.add(comingFrom.getCarta(0));
        comingFrom.removeCarta(0);

    }

    public void moveAllToBaraja(Baraja moveTo){
        int thisDeckSize = this.cartas.size();

        for(int i = 0; i < thisDeckSize; i++){
            moveTo.addCarta(this.getCarta(i));
        }
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCarta(0);
        }

    }




    public void removeCarta(int i){
        this.cartas.remove(i);
    }

    public Carta getCarta(int i){
        return this.cartas.get(i);
    }

    public void addCarta(Carta addCarta){
        this.cartas.add(addCarta);
    }

    public int deckSize(){
        return this.cartas.size();
    }

    //retura el valor total de les cartes de la teva ma
    public int cardsValue(){
    int totalValue = 0;
    int aces = 0;

    for(Carta aCarta: this.cartas){
        switch (aCarta.getNumero()){
            case DOS: totalValue += 2; break;
            case TRES: totalValue += 3; break;
            case CUATRO: totalValue += 4; break;
            case CINCO: totalValue += 5; break;
            case SEIS: totalValue += 6; break;
            case SIETE: totalValue += 7; break;
            case OCHO: totalValue += 8; break;
            case NUEVE: totalValue += 9; break;
            case DIEZ: totalValue += 10; break;
            case J: totalValue += 10; break;
            case Q: totalValue += 10; break;
            case K: totalValue += 10; break;
            case A: aces += 1; break;
        }
    }
    for(int i = 0; i < aces; i++){
        if(totalValue > 10){
            totalValue += 1;
        }
        else{
            totalValue += 11;
        }
    }

    return totalValue;
    }





    public String toString(){ //Comprovacions
        String cardListOutput = "";
        for(Carta aCarta : this.cartas){
            cardListOutput += "\n" + aCarta.toString();

        }
        return cardListOutput;
    }


}
