/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Paula Rodríguez A
 */
public class ReliquiaVida extends Componente{

    public ReliquiaVida(String nombre, String imagen, int vida, int campos) {
        super(nombre, imagen, vida, campos);
    }
    
    public boolean esDestruida() {
        return !estaVivo();
    }
}
