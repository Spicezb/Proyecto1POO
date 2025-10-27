package com.mycompany.proyecto1;

public class ZombieChoque extends Zombie{

    private static final String TIPO = "Zombie de choque";
    private static final int ESPACIOS = 4;
    
    public ZombieChoque(int id, int danno, int velocidad, int velocidadDeAtaque, int nivelAparicion, String nombre, String imagen, int vida) {
        super(id,danno,velocidad, velocidadDeAtaque,nivelAparicion,nombre,imagen,vida,ESPACIOS,TIPO);
    }
    
    @Override
    public void atacar(Componente objetivo) {
        if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(5);
            this.morir(); // explota al atacar
        }
    }
    
    @Override
    public void moverse() {
    }
    
    @Override
    public Componente clonar(int id){
        return null;
    }

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }
    
}
