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

    public ArmaAerea(String nombre, String imagen) {
        super(5, 2, 1, 2, 2, nombre, imagen, 30, 2);
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
