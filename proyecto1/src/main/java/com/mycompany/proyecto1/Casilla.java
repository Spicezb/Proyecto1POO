/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Paula Rodríguez A
 */
public class Casilla extends JPanel{
    
    private int x, y;
    private Componente componente;

    public Casilla(int x, int y) {
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(24, 24));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground(Color.WHITE);
    }

    public void colocarComponente(Componente c) {
        this.componente = c;
        repaint();
    }

    public Componente getComponente() {
        return componente;
    }

    public boolean estaVacia() {
        return componente == null;
    }

    public int getXPos() {
        return x;
    }

    public int getYPos() {
        return y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (componente != null) {
            g.setColor(Color.BLACK);
            g.drawString(componente.getNombre().substring(0, 1), 10, 15);
        }
    }
}
