package com.mycompany.proyecto1;

public class ArmaBloque extends Defensa{
    private static final String TIPO = "Bloque";
    private static final int ESPACIOS = 2;
    
    public ArmaBloque(int id,int nivelAparicion,String nombre,String imagen, int vida) {
        super(nivelAparicion, nombre, imagen, vida, ESPACIOS,id,TIPO);
    }
    
    public ArmaBloque(ArmaBloque original, int nuevoId) {
        super(original, nuevoId);
    }
    
    @Override
    public Componente clonar(int nuevoId) {
        return new ArmaBloque(this, nuevoId);
    }
    

   
    
}
