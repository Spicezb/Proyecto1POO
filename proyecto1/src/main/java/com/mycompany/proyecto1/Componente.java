/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

/**
 *
 * @author Pau
 */
public abstract class Componente {
    private String nombre;
    private String imagen;
    private int vida;
    private int campos;
    private int nivelAparicion;
    private int posX;
    private int posY;

    public Componente(String nombre, String imagen, int vida, int campos, int nivelAparicion) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.vida = vida;
        this.campos = campos;
        this.nivelAparicion = nivelAparicion;
    }
 
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
    
    
}
