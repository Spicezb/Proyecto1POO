/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.util.ArrayList;

public class Partida {
    private int nivel;
    private ArrayList<Zombie> zombies;
    private ArrayList<Tropas> tropas;
    private ArrayList<Defensa> defensas;
    
    public Partida(ArrayList zombies){
        nivel = 1;
        //this.defensas = defensas;
        this.zombies = zombies;
        //this.tropas = todos;
    }
    
    void subirNivel(){
        this.nivel++;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    public ArrayList getZombies(){
        return zombies;
}
}