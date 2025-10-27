package com.mycompany.proyecto1;

public abstract class Zombie extends Componente implements IAtacar{
    private int danno;
    private int rango;
    private int velocidad;
    private int velocidadDeAtaque;

    public Zombie(int id, int danno, int velocidad, int velocidadDeAtaque, int nivelAparicion, String nombre, String imagen, int vida, int campos,String tipo) {
        super(nombre,imagen,vida,campos,nivelAparicion,id,tipo);
        this.danno = danno;
        this.rango = rango;
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