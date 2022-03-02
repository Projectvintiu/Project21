package com.example.project21.models;

import com.example.project21.models.Palos;
import com.example.project21.models.Numeros;

public class Carta {
    private  Palos palo;
    private Numeros numero;


    public Carta(Palos palo, Numeros numero){
        this.numero = numero;
        this.palo = palo;

    }


    public String toString(){
        return  this.palo.toString() + "-" + this.numero.toString();
    }

    public Numeros getNumero(){
        return this.numero;
    }


}
