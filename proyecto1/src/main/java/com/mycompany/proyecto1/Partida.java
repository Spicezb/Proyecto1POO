package com.mycompany.proyecto1;

import java.io.Serializable;
import configurador.componentes.GestorComponentes;
import configurador.componentes.TipoComponente;
import configurador.componentes.GuardarComponentes;
import java.io.*;
import java.util.ArrayList;


public class Partida implements Serializable{
    
    private static final long serialVersionUID = 1L; 
    private String nombreJugador;
    private int nivel;
    private ArrayList<Defensa> defensasBase;
    private ArrayList<Zombie> zombiesBase;
    private ArrayList<Defensa> defensasEstandar;
    
    
    
    
    public Partida(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        this.nivel = 1;
        this.defensasBase = new ArrayList<>();
        this.zombiesBase = new ArrayList<>();
        
        cargarComponentesDelConfigurador();
    }
    
    private void cargarComponentesDelConfigurador() {
        ArrayList<TipoComponente> configuraciones = GestorComponentes.cargarComponentes();

        for (TipoComponente config : configuraciones) {
            try {
                Componente componenteReal = GuardarComponentes.crearComponente(config);

                if ("Defensa".equals(config.getTipo())) {
                    defensasBase.add(new ReliquiaVida(1));
                    defensasBase.add((Defensa) componenteReal);
                } else if ("Zombie".equals(config.getTipo())) {
                    zombiesBase.add((Zombie) componenteReal);
                }
            } catch (Exception e) {
                System.err.println("Error al cargar componente: " + config.getNombre() + " -> " + e.getMessage());
            }
        }
         
    }
    
    public void guardarPartida() {
        try (FileOutputStream fileOut = new FileOutputStream(nombreJugador + ".ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            
            objectOut.writeObject(this);
            System.out.println("Partida guardada con éxito en " + nombreJugador + ".ser");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la partida.");
        }
    }
    
    public static Partida cargarPartida(String nombreArchivo) {
        Partida partida = null;
        File archivo = new File(nombreArchivo);
        
        if (archivo.exists()) {
            try (FileInputStream fileIn = new FileInputStream(archivo);
                 ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {

                partida = (Partida) objectIn.readObject();
                System.out.println("Partida cargada con éxito: " + partida.getNombreJugador());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                System.err.println("Error al cargar la partida. Se iniciará una nueva.");
            }
        }
        return partida;
    }
    
    void subirNivel(){
        this.nivel++;
    }
    
    public int getNivel(){
        return nivel;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public ArrayList<Defensa> getDefensasBase() {
        return defensasBase;
    }

    public void setDefensasBase(ArrayList<Defensa> defensasBase) {
        this.defensasBase = defensasBase;
    }

    public ArrayList<Zombie> getZombiesBase() {
        return zombiesBase;
    }

    public void setZombiesBase(ArrayList<Zombie> zombiesBase) {
        this.zombiesBase = zombiesBase;
    }

    public ArrayList<Defensa> getDefensasEstandar() {
        return defensasEstandar;
    }

    public void setDefensasEstandar(ArrayList<Defensa> defensasEstandar) {
        this.defensasEstandar = defensasEstandar;
    }
    
    
}