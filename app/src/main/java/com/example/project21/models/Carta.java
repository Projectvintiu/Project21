package com.example.project21.models;

import com.example.project21.models.Palos;
import com.example.project21.models.Numeros;

public class Carta {
    private  Palos palo;
    private Numeros numero;


    /***
     * Constructor de la classe Carta
     *
     * @param palo pal de la carta (Piques, diamants..)
     * @param numero numerp de la carta (1, 2, 3, J, Q, K..)
     *
     * @version 1.0
     */
    public Carta(Palos palo, Numeros numero){
        this.numero = numero;
        this.palo = palo;

    }

    /***
     * Funció per a pasar una carta a String
     *
     * @return String del valor de la carta, es a dir, pal i numero de la carta
     *
     * @version 1.0
     */
    public String toString(){
        return  this.palo.toString() + "-" + this.numero.toString();
    }

    /***
     * getter del numero
     *
     *
     * @return numero de la carta
     *
     * @version 1.0
     */
    public Numeros getNumero(){
        return this.numero;
    }


}
