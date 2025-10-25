package com.mycompany.proyecto1;

public abstract class Zombie {
    private int id;
    private int vida;
    private int danno;
    private int velocidad;
    private int velocidadDeAtaque;
    private int nivelDeAparicion;
    
    public Zombie(int id,int vida,int danno,int velocidad, int velocidadDeAtaque, int nivelDeAparicion){
        this.id = id;
        this.vida = vida;
        this.danno = danno;
        this.velocidad = velocidad;
        this.velocidadDeAtaque = velocidadDeAtaque;
        this.nivelDeAparicion = nivelDeAparicion;
    }
    
//    public void recibirAtaque(){
//        
//    }
//    
//    public void morir(){
//        
//    }
//    
//    public void atacar(){
//        
//    }
//    
//    public void moverse(){
//        
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDanno() {
        return danno;
    }

    public void setDanno(int danno) {
        this.danno = danno;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidadDeAtaque() {
        return velocidadDeAtaque;
    }

    public void setVelocidadDeAtaque(int velocidadDeAtaque) {
        this.velocidadDeAtaque = velocidadDeAtaque;
    }

    public int getNivelDeAparicion() {
        return nivelDeAparicion;
    }

    public void setNivelDeAparicion(int nivelDeAparicion) {
        this.nivelDeAparicion = nivelDeAparicion;
    }
   
}