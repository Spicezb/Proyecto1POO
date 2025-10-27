package com.mycompany.proyecto1;

public class Partida {
    private int nivel;
    
    public Partida(){
          nivel = 1;
    }
    
    void subirNivel(){
        this.nivel++;
    }
    
    public int getNivel(){
        return nivel;
    }
}