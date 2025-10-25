/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public class ArmaContacto extends DefensasAtacantes{

    public ArmaContacto(String nombre, String imagen) {
        super(3, 1, 1, 1, 1, nombre, imagen, 20, 1);
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
