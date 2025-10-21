package com.mycompany.proyecto1;

public class ZombieChoque extends Zombie{

    public ZombieChoque(int id, String nombre, String imagen) {
        super(id, 60, 1, 1, 7, nombre, imagen, 50, 1);
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
