package com.mycompany.proyecto1;

public class ArmaContacto extends DefensasAtacantes{
    private static final String TIPO = "Contacto";
    private static final int ESPACIOS = 2;
    
    
    public ArmaContacto(int id,int danno, int golpesSegundo,int rango, int nivelAparicion, String nombre,String imagen, int vida) {
        super(danno,golpesSegundo, nivelAparicion, rango, nombre, imagen, vida, ESPACIOS,id, TIPO);
    }

    public ArmaContacto(ArmaContacto original, int nuevoId) {
        super(original, nuevoId);
    }
    
    @Override
    public Componente clonar(int nuevoId) {
        return new ArmaContacto(this, nuevoId);
    }
    
    @Override
    public void atacar(Componente objetivo) {
    }
    

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }


    
}
