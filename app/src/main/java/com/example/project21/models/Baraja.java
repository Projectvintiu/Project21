package com.example.project21.models;

import java.util.ArrayList;
import java.util.Random;

public class Baraja {

    private ArrayList<Carta> cartas;


    /***
     *  Constructor de la classe
     *
     * @version 1.0
     */
    public Baraja(){
        this.cartas = new ArrayList<Carta>();
    }

    /***
     * Funció que crea la baralla tenint en compte els pals i els diferents numeros o valors, que tenim en els enums "Numeros" i "Palos"
     * i les afagueix a l'ArrayList Cartas
     *
     * @version 1.0
     */
    public void createFullDeck(){

        for(Palos cardPalo : Palos.values()){ // itera dins dels "4" palos que tinguem
            for(Numeros cardNumero : Numeros.values()){ //itera dins del numero de cartes que tingeum
                this.cartas.add(new Carta(cardPalo, cardNumero));
            }
        }

    }

    /***
     * Funció que barreja la baralla de cartes per a poder jugar cada partida, la qual ho fa de la seguent manera:
     * Crea una baralla temporal on va afegint cartes aleatories de la baralla principal la qual esta ordenada fins
     * a tenir una baralla desordenada, i passem els valors a la vairable ArrrayList cartas
     *
     *
     * @version 1.0
     */
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


    /***
     * Funció que serveix per a moure cartes de una baralla a una alre
     *
     * @param comingFrom Baralla de la qual treiem una carta
     *
     * @version 1.0
     */
    public void draw(Baraja comingFrom){
        this.cartas.add(comingFrom.getCarta(0));
        comingFrom.removeCarta(0);

    }

    /***
     * Funció que sutilitza prinicpalment al final de les partides, i que serveix per a retornar totes
     * totes les cartes de les barralles que tinguem obertes cap a la principal
     *
     * @param moveTo
     *
     * @version 1.0
     */
    public void moveAllToBaraja(Baraja moveTo){
        int thisDeckSize = this.cartas.size();

        for(int i = 0; i < thisDeckSize; i++){
            moveTo.addCarta(this.getCarta(i));
        }
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCarta(0);
        }

    }


    /***
     * Funció per a treure una carta especifica de una baralla
     *
     * @param i posicio de la carta que volguem treue
     *
     * @version 1.0
     */
    public void removeCarta(int i){
        this.cartas.remove(i);
    }

    /***
     * Funció per a obtenir una carta de una posicio espesifica de la baralla
     *
     * @param i posicio de la carta que volem
     * @return valor de la carta que volguem comprovar o utilizar
     *
     * @version 1.0
     */
    public Carta getCarta(int i){
        return this.cartas.get(i);
    }

    /***
     * Funció per afegir una carta a la baralla
     *
     * @param addCarta
     *
     * @version 1.0
     */
    public void addCarta(Carta addCarta){
        this.cartas.add(addCarta);
    }

    /***
     * Funció per a saber el tampany actual de la baralla
     *
     * @return tamany actual de la baralla
     *
     * @version 1.0
     */
    public int deckSize(){
        return this.cartas.size();
    }


    /***
     * Funció per a saber el valor total que te la baralla, es fara servir en les baralles del jugador i
     * la ia, totes les cartes tenen el valor de el seu numero menys J, Q, K que valen 10, i A que pot valdre
     * 1 o 11, depenent de que et sigui mes adient
     *
     * @return
     *
     * @version 1.0
     */
    public int cardsValue(){
    int totalValue = 0;
    int aces = 0;

    for(Carta aCarta: this.cartas){
        switch (aCarta.getNumero()){
            case DOS: totalValue += 2; break;
            case TRES: totalValue += 3; break;
            case QUATRE: totalValue += 4; break;
            case CINC: totalValue += 5; break;
            case SIS: totalValue += 6; break;
            case SET: totalValue += 7; break;
            case VUIT: totalValue += 8; break;
            case NOU: totalValue += 9; break;
            case DEU: totalValue += 10; break;
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

    public int secondCardValue(){
        int totalValue = 0;

            switch (cartas.get(1).getNumero()){
                case DOS: totalValue += 2; break;
                case TRES: totalValue += 3; break;
                case QUATRE: totalValue += 4; break;
                case CINC: totalValue += 5; break;
                case SIS: totalValue += 6; break;
                case SET: totalValue += 7; break;
                case VUIT: totalValue += 8; break;
                case NOU: totalValue += 9; break;
                case DEU: totalValue += 10; break;
                case J: totalValue += 10; break;
                case Q: totalValue += 10; break;
                case K: totalValue += 10; break;
                case A: totalValue += 1; break;
            }

        return totalValue;
    }

    /***
     *
     * Funció per a pasar a format String
     *
     * @return String de les cartes de la baralla
     *
     * @version 1.0
     */
    public String toString(){ //Comprovacions
        String cardListOutput = "";
        for(Carta aCarta : this.cartas){
            cardListOutput += "\n" + aCarta.toString();

        }
        return cardListOutput;
    }


}
