package com.mycompany.proyecto1;

public abstract class Zombie extends Componente implements IAtacar{
    private int id;
    private int danno;
    private int velocidad;
    private int velocidadDeAtaque;
    private int nivelDeAparicion;
   

    public Zombie(int id, int danno, int velocidad, int velocidadDeAtaque, int nivelDeAparicion, String nombre, String imagen, int vida, int campos) {
        super(nombre, imagen, vida, campos);
        this.id = id;
        this.danno = danno;
        this.velocidad = velocidad;
        this.velocidadDeAtaque = velocidadDeAtaque;
        this.nivelDeAparicion = nivelDeAparicion;
    }
    
    @Override
    public void recibirGolpe(int danio){
        
    }
    
    
    @Override
    public void atacar(Componente objetivo){
        
    }
    
    public void moverse(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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