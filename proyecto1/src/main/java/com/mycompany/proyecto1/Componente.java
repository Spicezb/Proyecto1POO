package com.mycompany.proyecto1;

public abstract class Componente {
    private String tipo;
    private String nombre;
    private String imagen;
    private int vida;
    private int campos;
    private int nivelAparicion;
    private int posX;
    private int posY;
    private int id;

    public Componente(String nombre, String imagen, int vida, int campos, int nivelAparicion,int id,String tipo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.vida = vida;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
        this.id = id;
        this.tipo = tipo;
    }
 
    public Componente(Componente original,int id) {
        this.nombre = original.getNombre();
        this.vida = original.getVida();
        this.campos = original.getCampos();
        this.tipo = original.getTipo();
        this.imagen = original.getImagen();
        this.nivelAparicion = original.getNivelDeAparicion();
        this.id = id;
    }

    public abstract Componente clonar(int nuevoId);
    
    public void recibirGolpe(int danio){
        this.vida -= danio;
        if (vida <= 0) {
            morir();
        }
    }
      
    
    public void morir(){
        this.vida = 0;
    }
    
    public boolean estaVivo() {
        return vida > 0;
    }
    
    public void colocarEn(int x, int y) {
        this.setPosX(x);
        this.setPosY(y);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getCampos() {
        return campos;
    }

    public void setCampos(int campos) {
        this.campos = campos;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
    
    public int getNivelDeAparicion(){
        return nivelAparicion;
    }
    
    public String getTipo(){
        return tipo;
    }
}
