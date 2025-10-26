package com.mycompany.proyecto1;

/**
 *
 * @author Paula Rodríguez A
 */
public class ReliquiaVida extends Componente{

    public ReliquiaVida(String nombre, String imagen, int vida, int campos, int nivelAparicion, int id) {
        super(nombre, imagen, vida, campos, nivelAparicion, id);
    }
    
    public boolean esDestruida() {
        return !estaVivo();
    }
}
