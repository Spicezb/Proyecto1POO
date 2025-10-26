package com.mycompany.proyecto1;

public abstract class Zombie extends Componente implements IAtacar{
    private int id;
    private int danno;
    private int rango;
    private int nivel;
    private int velocidad;
    private int velocidadDeAtaque;

    
   

    public Zombie(int id, int danno, int velocidad, int velocidadDeAtaque, int nivelDeAparicion, String nombre, String imagen, int vida, int campos) {
        super(nombre,imagen,vida,campos,nivelDeAparicion,id);
        this.id = id;
        this.danno = danno;
        this.rango = rango;
        this.nivel = nivel;
        this.velocidad = velocidad;
        this.velocidadDeAtaque = velocidadDeAtaque;

    }
    
    
    
    @Override
    public void atacar(Componente objetivo){
        if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(5);
        }
        
    }
    

    @Override
    public boolean estaEnRango(Componente objetivo){
        if (objetivo == null) return false;
        int distancia = Math.abs(this.getPosX() - objetivo.getPosX()) + Math.abs(this.getPosY() - objetivo.getPosY());
        return distancia <= rango;
    }
    
    public abstract void moverse();

    
    public long getId() {
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
}