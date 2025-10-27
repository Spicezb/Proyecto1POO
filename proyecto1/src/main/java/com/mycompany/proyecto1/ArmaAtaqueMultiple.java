package com.mycompany.proyecto1;

public class ArmaAtaqueMultiple extends DefensasAtacantes{
    private static final String TIPO = "Ataque múltiple";
    private static final int ESPACIOS = 2;
    int cantidadAtaques;

    public ArmaAtaqueMultiple(int id,int danno, int golpesSegundo,int rango, int nivelAparicion, String nombre,String imagen, int vida) {
        super(danno,golpesSegundo, nivelAparicion, rango, nombre, imagen, vida, ESPACIOS,id, TIPO);
        this.cantidadAtaques = 10;
    }

   public ArmaAtaqueMultiple(ArmaAtaqueMultiple original, int nuevoId) {
        super(original, nuevoId);
    }

   @Override
    public Componente clonar(int nuevoId) {
        return new ArmaAtaqueMultiple(this, nuevoId);
    }
   
    public int getCantidadAtaques() {
        return cantidadAtaques;
    }
    
}
