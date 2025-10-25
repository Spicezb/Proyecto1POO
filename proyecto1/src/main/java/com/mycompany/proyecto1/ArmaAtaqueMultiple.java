/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public class ArmaAtaqueMultiple extends DefensasAtacantes{
    
    int cantidadAtaques;

    public ArmaAtaqueMultiple(String nombre, String imagen) {
        super(2, 2, 1, 2, 3, nombre, imagen, 20, 2);
        this.cantidadAtaques = 10;
    }

    
    @Override
    public int calcularDanio() {
        return cantidadAtaques * super.calcularDanio();
    }

    public int getCantidadAtaques() {
        return cantidadAtaques;
    }
    
}
