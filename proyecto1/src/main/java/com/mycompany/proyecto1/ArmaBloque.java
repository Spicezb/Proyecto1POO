package com.mycompany.proyecto1;

public class ArmaBloque extends Defensa{
    private static final int NIVEL_APARICION = 1;
    private static final String NOMBRE = "Bloque";
    private static final int VIDA = 50;
    private static final int ESPACIOS = 1;
    
    public ArmaBloque(int id, String imagen) {
        super(NIVEL_APARICION, NOMBRE, imagen, VIDA, ESPACIOS,id);
    }

    

   
    
}
