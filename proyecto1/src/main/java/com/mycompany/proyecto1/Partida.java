/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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