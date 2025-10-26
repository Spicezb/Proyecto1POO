package com.mycompany.proyecto1;

public class ArmaAtaqueMultiple extends DefensasAtacantes{
    private static final int NIVEL_APARICION = 5;
    private static final String NOMBRE = "Arma múltiple";
    private static final int DANNO = 8;
    private static final int VIDA = 50;
    private static final int GOLPES_SEGUNDO = 1;
    private static final int ESPACIOS = 4;
    private static final int RANGO = 6;
    int cantidadAtaques;

    public ArmaAtaqueMultiple(int id, String imagen) {
        super(DANNO, GOLPES_SEGUNDO, NIVEL_APARICION, RANGO, NOMBRE, imagen, VIDA, ESPACIOS,id);
        this.cantidadAtaques = 10;
    }

   

    public int getCantidadAtaques() {
        return cantidadAtaques;
    }
    
}
