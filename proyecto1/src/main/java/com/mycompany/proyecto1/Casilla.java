package com.mycompany.proyecto1;

import java.awt.*;
import java.awt.datatransfer.*;
import java.net.URL;
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
        
                        Componente nuevaDefensa = refVentana.cloneComponente(base);
                        colocarComponente(nuevaDefensa);
                        refVentana.agregarDefensaColocada(nuevaDefensa); 
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
        this.refVentana.agregarDefensaColocada(c);
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
            ImageIcon icono = null;

            URL imageUrl = getClass().getResource(componente.getImagen()); 

            if (imageUrl != null) {
                icono = new ImageIcon(imageUrl);
            } else {
     
                try {
                    java.io.File imageFile = new java.io.File(componente.getImagen());
                    if (imageFile.exists()) {
                        icono = new ImageIcon(imageFile.getAbsolutePath());
                    } else {
           
                        System.out.println("ADVERTENCIA: Imagen no encontrada para componente: " + componente.getNombre());
                    }
                } catch (Exception e) {
    
                    e.printStackTrace(); 
                }
            }

          
            if (icono != null) {
                Image img = icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
                
                g.drawImage(img, 0, 0, this); 
            }

           
        }
    }
}

