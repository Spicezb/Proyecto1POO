/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package configurador.componentes;

import java.io.Serializable;

/**
 *
 * @author Paula Rodríguez A
 */
public class TipoComponente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private String nombre;
    private int vida;
    private int danio;
    private int nivelAparicion;
    private int golpesPorTiempo;
    private int rango;
    private String tipo;      
    private String subtipo;   
    private String imagen;    
    private int Velocidad;
    
    public TipoComponente(String nombre, int vida, int danio, int nivelAparicion,
                          int golpesPorTiempo, int rango, String tipo, String subtipo, String imagen, int Velocidad) {
        this.nombre = nombre;
        this.vida = vida;
        this.danio = danio;
        this.nivelAparicion = nivelAparicion;
        this.golpesPorTiempo = golpesPorTiempo;
        this.rango = rango;
        this.tipo = tipo;
        this.subtipo = subtipo;
        this.imagen = imagen;
        this.Velocidad = Velocidad;
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getSubtipo() {
        return subtipo;
    }

    public void setSubtipo(String subtipo) {
        this.subtipo = subtipo;
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

    public int getDanio() {
        return danio;
    }

    public void setDanio(int danio) {
        this.danio = danio;
    }

    public int getNivelAparicion() {
        return nivelAparicion;
    }

    public void setNivelAparicion(int nivelAparicion) {
        this.nivelAparicion = nivelAparicion;
    }

    public int getGolpesPorTiempo() {
        return golpesPorTiempo;
    }

    public void setGolpesPorTiempo(int golpesPorTiempo) {
        this.golpesPorTiempo = golpesPorTiempo;
    }

    public int getRango() {
        return rango;
    }

    public void setRango(int rango) {
        this.rango = rango;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }
    
    
    
}
