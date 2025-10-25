package com.mycompany.proyecto1;

public class ZombieChoque extends Zombie{

    public ZombieChoque(int id, String nombre, String imagen) {
        super(id, 60, 2, 1, 1, nombre, imagen, 50, 1);
    }
    
    @Override
    public void atacar(Componente objetivo) {
        if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(calcularDanio());
            this.morir(); // explota al atacar
        }
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
