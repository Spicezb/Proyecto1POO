/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public interface IAtacar {

    public void atacar(Componente objetivo);
    public boolean estaEnRango(Componente objetivo);
    public int getDanno();
}
