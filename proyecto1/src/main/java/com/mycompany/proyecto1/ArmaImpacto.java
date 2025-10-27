package com.mycompany.proyecto1;

public class ArmaImpacto extends DefensasAtacantes{
    private static final String TIPO = "Impacto";
    private static final int ESPACIOS = 2;
    private int radioExplosion;

    public ArmaImpacto(int id,int danno, int golpesSegundo,int rango, int nivelAparicion, String nombre,String imagen, int vida) {
        super(danno,golpesSegundo, nivelAparicion, rango, nombre, imagen, vida, ESPACIOS,id, TIPO);
        this.radioExplosion = 3;
    }
    
    public ArmaImpacto(ArmaImpacto original, int nuevoId) {
        super(original, nuevoId);
    }
    
    @Override
    public Componente clonar(int nuevoId) {
        return new ArmaImpacto(this, nuevoId);
    }
    
    @Override
    public void atacar(Componente objetivo) {
       if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(5);
            this.morir(); // se autodestruye
        }
    }
    

    public int getRadioExplosion() {
        return radioExplosion;
    }
    
    
}
