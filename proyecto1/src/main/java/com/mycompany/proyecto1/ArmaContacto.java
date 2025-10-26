package com.mycompany.proyecto1;

public class ArmaContacto extends DefensasAtacantes{
    private static final int NIVEL_APARICION = 1;
    private static final String NOMBRE = "Arma de contacto";
    private static final int DANNO = 5;
    private static final int VIDA = 40;
    private static final int GOLPES_SEGUNDO = 2;
    private static final int ESPACIOS = 2;
    private static final int RANGO = 1;
    
    
    public ArmaContacto(int id, String imagen) {
        super(DANNO, GOLPES_SEGUNDO, NIVEL_APARICION, RANGO, NOMBRE, imagen, VIDA, ESPACIOS,id);
    }

    
    
    @Override
    public void atacar(Componente objetivo) {
    }
    

    @Override
    public boolean estaEnRango(Componente objetivo) {
        return false;
    }


    
}
