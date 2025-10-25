package com.mycompany.proyecto1;

public class ZombieMedio extends Zombie{

    public ZombieMedio(int id, String nombre, String imagen) {
        super(id, 4, 1, 1, 5, nombre, imagen, 40, 1);
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
