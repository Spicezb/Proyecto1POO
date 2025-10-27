package com.mycompany.proyecto1;

public class ArmaMedianoAlcance extends DefensasAtacantes{
    private static final String TIPO = "Mediano alcance";
    private static final int ESPACIOS = 2;
    
    public ArmaMedianoAlcance(int id,int danno, int golpesSegundo,int rango, int nivelAparicion, String nombre,String imagen, int vida) {
        super(danno,golpesSegundo, nivelAparicion, rango, nombre, imagen, vida, ESPACIOS,id, TIPO);
    }
    
    public ArmaMedianoAlcance(ArmaMedianoAlcance original, int nuevoId) {
        super(original, nuevoId);
    }
    
    @Override
    public Componente clonar(int nuevoId) {
        return new ArmaMedianoAlcance(this, nuevoId);
    }
    
    @Override
    public void atacar(Componente objetivo) {
       
    }
    

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }
    
    
}
