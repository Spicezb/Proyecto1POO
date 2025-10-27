package com.mycompany.proyecto1;

/**
 *
 * @author Paula Rodríguez A
 */
public class ReliquiaVida extends Defensa{
    private static final String IMAGEN = "/muro1.jpg";
    private static final String NOMBRE = "arbolito";
    private static final String TIPO = "ReliquiaVida";
    private static final int VIDA = 40;
    private static final int CAMPOS = 0;
    private static final int NIVEL_APARICION = 0;
    

    public ReliquiaVida(int id) {
        super(NIVEL_APARICION, NOMBRE, IMAGEN, VIDA, CAMPOS, id, TIPO);
    }
    
    public ReliquiaVida(ReliquiaVida original, int nuevoId) {
        super(original, nuevoId);
    }
    
    @Override
    public Componente clonar(int nuevoId) {
        return new ReliquiaVida(this, nuevoId);
    }
    
    public boolean esDestruida() {
        return !estaVivo();
    }
}
