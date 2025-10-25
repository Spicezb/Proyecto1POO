/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public class ArmaAerea extends DefensasAtacantes{

    public ArmaAerea(int danio, int nivel, int cantGolpesTiempo, int nivelAparicion, int rango, String nombre, String imagen, int vida, int campos) {
        super(danio, nivel, cantGolpesTiempo, nivelAparicion, rango, nombre, imagen, vida, campos);
    }

    

    @Override
    public void atacar(Componente objetivo) {
    }


    @Override
    public int calcularDanio() {
        return 0;

    }

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }
    
    public void moverse(){
    }
    
}
