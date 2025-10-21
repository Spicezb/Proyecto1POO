/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public abstract class Defensa extends Componente{
    
    private int danio;
    private int nivel;
    private int cantGolpesTiempo;
    private int nivelAparicion;
    private int rango;

    public Defensa(int danio, int nivel, int cantGolpesTiempo, int nivelAparicion, int rango, String nombre, String imagen, int vida, int campos) {
        super(nombre, imagen, vida, campos);
        this.danio = danio;
        this.nivel = nivel;
        this.cantGolpesTiempo = cantGolpesTiempo;
        this.nivelAparicion = nivelAparicion;
        this.rango = rango;
    }

    
     public void colocar(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }
}
