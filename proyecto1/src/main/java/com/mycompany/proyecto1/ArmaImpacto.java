package com.mycompany.proyecto1;

public class ArmaImpacto extends DefensasAtacantes{
    private static final int NIVEL_APARICION = 7;
    private static final String NOMBRE = "Arma de impacto";
    private static final int DANNO = 8;
    private static final int VIDA = 60;
    private static final int GOLPES_SEGUNDO = 1;
    private static final int ESPACIOS = 3;
    private static final int RANGO = 1;
    private int radioExplosion;

    public ArmaImpacto(int id, String imagen) {
        super(DANNO, GOLPES_SEGUNDO, NIVEL_APARICION, RANGO, NOMBRE, imagen, VIDA, ESPACIOS,id);
        this.radioExplosion = 3;
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
