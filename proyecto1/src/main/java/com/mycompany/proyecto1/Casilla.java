package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.datatransfer.*;
import javax.swing.*;

public class Casilla extends JPanel {

    private VentanaPrincipal refVentana;
    private int x, y;
    private Componente componente;
    private boolean estado; // true si hay un componente
    public static final DataFlavor COMPONENTE_FLAVOR = new DataFlavor(Componente.class, "Componente");

    public Casilla(int x, int y, VentanaPrincipal refVentana) {
        this.refVentana = refVentana;
        this.x = x;
        this.y = y;
        setPreferredSize(new Dimension(24, 24));
        setBorder(BorderFactory.createLineBorder(Color.GRAY));
        setBackground((y < 2 || y > 22 || x < 2 || x > 22) ? Color.PINK : Color.WHITE);

        // Drop handler
        setTransferHandler(new TransferHandler() {
            @Override
            public boolean canImport(TransferSupport support) {
                return support.isDataFlavorSupported(COMPONENTE_FLAVOR);
            }

            @Override
            public boolean importData(TransferHandler.TransferSupport support) {
                try {
                    Componente base = (Componente) support.getTransferable()
                            .getTransferData(ComponenteTransferible.COMPONENTE_FLAVOR);

                    if (base != null && estaVacia()) {
                        // Crear clon con ID único
                        Componente nuevaDefensa = refVentana.cloneComponente(base);
                        colocarComponente(nuevaDefensa);
                        refVentana.agregarDefensaColocada(nuevaDefensa); // agrega a arrayLists de la ventana
                        return true;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return false;
            }
        });
    }

    public void colocarComponente(Componente c) {
        this.componente = c;
        this.estado = true;
        repaint();
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
            ImageIcon icono = new ImageIcon(getClass().getResource(componente.getImagen()));
            g.drawImage(icono.getImage(), 2, 2, 24, 24, this);
        }
    }
}

