/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public class ArmaImpacto extends DefensasAtacantes{
    
    private int radioExplosion;

    public ArmaImpacto(String nombre, String imagen) {
        super(10, 3, 1, 4, 1, nombre, imagen, 10, 1);
        this.radioExplosion = 3;
    }
    
    @Override
    public void atacar(Componente objetivo) {
       if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(calcularDanio());
            this.morir(); // se autodestruye
        }
    }
    

    public int getRadioExplosion() {
        return radioExplosion;
    }
    
    
}
