/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Paula Rodríguez A
 */
public class DefensasAtacantes extends Defensa implements IAtacar{

    public DefensasAtacantes(int danio, int nivel, int cantGolpesTiempo, int nivelAparicion, int rango, String nombre, String imagen, int vida, int campos) {
        super(danio, nivel, cantGolpesTiempo, nivelAparicion, rango, nombre, imagen, vida, campos);
    }
    

    @Override
    public void atacar(Componente objetivo) {
        if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(calcularDanio());
        }
    }

    @Override
    public int calcularDanio() {
        return (int)(this.getCantGolpesTiempo() * (1 + (this.getNivel() * 0.1)));
    }

    @Override
    public boolean estaEnRango(Componente objetivo) {
        if (objetivo == null) return false;
        int distancia = Math.abs(this.getPosX() - objetivo.getPosX()) + Math.abs(this.getPosY() - objetivo.getPosY());
        return distancia <= this.getRango();
    }
    
    
}
