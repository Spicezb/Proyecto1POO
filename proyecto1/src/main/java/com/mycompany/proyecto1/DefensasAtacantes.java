package com.mycompany.proyecto1;

public abstract class DefensasAtacantes extends Defensa implements IAtacar{
    private int danno;
    private int rango;
    private int golpesSegundo;
    
    
    public DefensasAtacantes(int danno,int GolpesPorSegundo, int nivelAparicion, int rango, String nombre, String imagen, int vida, int campos,int id,String tipo) {
        super(nivelAparicion, nombre, imagen, vida, campos,id,tipo);
        this.danno=danno;
    }
    
    public DefensasAtacantes(DefensasAtacantes original, int nuevoId) {
        super(original, nuevoId);
        this.danno = original.danno;
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
    
    @Override
    public int getDanno(){
        return danno;
    }
}

