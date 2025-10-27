package com.mycompany.proyecto1;

public abstract class Defensa extends Componente{
       private int nivelAparicion;

    public Defensa(int nivelAparicion, String nombre, String imagen, int vida, int campos, int id, String tipo) {
        super(nombre, imagen, vida, campos, nivelAparicion, id, tipo);
        this.nivelAparicion = nivelAparicion;
    }

    public Defensa(Defensa original, int nuevoId) {
        super(original, nuevoId);
    }
    
     public void colocar(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

  
     
     
     
}
