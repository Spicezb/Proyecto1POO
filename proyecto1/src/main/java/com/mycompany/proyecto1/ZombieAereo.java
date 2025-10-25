package com.mycompany.proyecto1;

public class ZombieAereo extends Zombie{
    private static final int NIVEL = 3;
    
    public ZombieAereo(int id){
        super(id,30,3,3,1,NIVEL);
    }
}