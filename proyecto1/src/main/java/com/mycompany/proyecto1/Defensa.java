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

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCantGolpesTiempo() {
        return cantGolpesTiempo;
    }

    public void setCantGolpesTiempo(int cantGolpesTiempo) {
        this.cantGolpesTiempo = cantGolpesTiempo;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }
     
     
     
}
