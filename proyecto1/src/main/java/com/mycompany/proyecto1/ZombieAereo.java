package com.mycompany.proyecto1;

public class ZombieAereo extends Zombie{

    public ZombieAereo(int id, String nombre, String imagen) {
        super(id, 3, 2, 3, 2, nombre, imagen, 30, 1);
    }
    
    
    
    @Override
    public void atacar(Componente objetivo) {
    }

    @Override
    public void moverse() {
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