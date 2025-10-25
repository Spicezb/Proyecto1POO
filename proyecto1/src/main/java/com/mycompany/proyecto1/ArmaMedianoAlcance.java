/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public class ArmaMedianoAlcance extends DefensasAtacantes{

    public ArmaMedianoAlcance(String nombre, String imagen) {
        super(4, 2, 1, 1, 3, nombre, imagen, 25, 2);
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
    
    
}
