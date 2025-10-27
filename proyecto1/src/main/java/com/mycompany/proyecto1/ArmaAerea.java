package com.mycompany.proyecto1;

public class ArmaAerea extends DefensasAtacantes{
    private static final String TIPO = "Aerea";
    private static final int ESPACIOS = 2;
    
    public ArmaAerea(int id,int danno, int golpesSegundo,int rango, int nivelAparicion, String nombre,String imagen, int vida) {
        super(danno,golpesSegundo, nivelAparicion, rango, nombre, imagen, vida, ESPACIOS,id, TIPO);
    }

    public ArmaAerea(ArmaAerea original, int nuevoId) {
        super(original, nuevoId);
    }

    @Override
    public Componente clonar(int nuevoId) {
        return new ArmaAerea(this, nuevoId);
    }
    
    @Override
    public void atacar(Componente objetivo) {
    }

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }
    
    public void moverse(){
    }
    
}
