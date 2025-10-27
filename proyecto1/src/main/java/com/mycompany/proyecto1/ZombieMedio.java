package com.mycompany.proyecto1;

public class ZombieMedio extends Zombie{
    
    private static final String TIPO = "Zombie medio alcance";
    private static final int ESPACIOS = 3;

    public ZombieMedio(int id, int danno, int velocidad, int velocidadDeAtaque, int nivelAparicion, String nombre, String imagen, int vida) {
        super(id,danno,velocidad, velocidadDeAtaque,nivelAparicion,nombre,imagen,vida,ESPACIOS,TIPO);
    }
    
    
    
    @Override
    public void atacar(Componente objetivo) {
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
