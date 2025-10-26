package com.mycompany.proyecto1;

public class DefensasAtacantes extends Defensa implements IAtacar{
    private int danno;
    private int rango;
    private int golpesSegundo;
    
    
    public DefensasAtacantes(int danno,int GolpesPorSegundo, int nivelAparicion, int rango, String nombre, String imagen, int vida, int campos,int id) {
        super(nivelAparicion, nombre, imagen, vida, campos,id);
        this.danno=danno;
    }
    

    @Override
    public void atacar(Componente objetivo) {
        if (estaEnRango(objetivo)) {
            objetivo.recibirGolpe(5);
        }
    }

    @Override
    public boolean estaEnRango(Componente objetivo) {
        if (objetivo == null) return false;
        int distancia = Math.abs(this.getPosX() - objetivo.getPosX()) + Math.abs(this.getPosY() - objetivo.getPosY());
        return true;
    }
    
    
}
