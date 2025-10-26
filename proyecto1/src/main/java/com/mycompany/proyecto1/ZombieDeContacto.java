package com.mycompany.proyecto1;

public class ZombieDeContacto extends Zombie {

    public ZombieDeContacto(int id, String nombre, String imagen) {
        super(id, 3, 1, 1, 1, nombre, imagen, 30, 1);
    }
    
    @Override
    public void atacar(Componente objetivo) {
    }
    
    @Override
    public void moverse() {
    }
    

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }
}
