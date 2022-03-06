package com.example.project21.models;


/***
 * AQUESTA CLASSE NO SUTILITZA DE MOMENT PERO LA FAREM SERVIR MES ENDEVANT
 */

public class Jugador {
    private int pv;
    private String name;
    private Carta[] cartas_jugador;

    public Carta[] getCartas_jugador() {
        return cartas_jugador;
    }

    public void setCartas_jugador(Carta[] cartas_jugador) {
        this.cartas_jugador = cartas_jugador;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
