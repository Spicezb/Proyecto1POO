package com.mycompany.proyecto1;

public class ArmaMedianoAlcance extends DefensasAtacantes{
    private static final int NIVEL_APARICION = 5;
    private static final String NOMBRE = "Arma de mediano alcance";
    private static final int DANNO = 9;
    private static final int VIDA = 25;
    private static final int GOLPES_SEGUNDO = 2;
    private static final int ESPACIOS = 3;
    private static final int RANGO = 3;
    
    public ArmaMedianoAlcance(int id, String imagen) {
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
