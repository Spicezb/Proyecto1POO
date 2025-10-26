/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package configurador.componentes;

import javax.swing.JOptionPane;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.HeadlessException;
import java.awt.Image;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Paula Rodríguez A
 */
public class VentanaConfiguracion extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaConfiguracion.class.getName());

    /**
     * Creates new form VentanaConfiguracion
     */
    
    private String rutaImagen = "";   
    private String nombreArchivoImagen = "";
    public VentanaConfiguracion() {
        initComponents();
        
        inicializarComponentes();
    }
    
    
    private void inicializarComponentes() {
        // Inicializar cmbTipo (Solo "Zombie" o "Defensa")
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Defensa", "Zombie" }));
        
        // Cargar los subtipos de defensa inicialmente
        actualizarSubtiposDefensa();
        
        // Añadir el listener para cambiar los subtipos al cambiar el Tipo principal
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    String tipoSeleccionado = cmbTipo.getSelectedItem().toString();
                    if (tipoSeleccionado.equals("Defensa")) {
                        actualizarSubtiposDefensa();
                        // Habilitar campos de daño y rango, excepto para 'Bloque'
                        habilitarCamposDefensa(true); 
                    } else if (tipoSeleccionado.equals("Zombie")) {
                        actualizarSubtiposZombie();
                        habilitarCamposDefensa(true); 
                    } else {
                        // En caso de que se necesiten otros tipos
                        cmbSubtipo.setModel(new DefaultComboBoxModel<>());
                        habilitarCamposDefensa(true); 
                    }
                }
            }
        });
        
        // Listener para el ComboBox de Subtipo, solo para deshabilitar daño si es 'Bloque'
        cmbSubtipo.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    String subtipoSeleccionado = (String) cmbSubtipo.getSelectedItem();
                    // Solo el subtipo Bloque no ataca, por lo tanto no necesita Daño ni Rango
                    boolean esBloque = "Bloque".equals(subtipoSeleccionado);
                    txfDanio.setEnabled(!esBloque);
                    txfRango.setEnabled(!esBloque);
                    txfGolpes.setEnabled(!esBloque);
                }
            }
        });
    }
    
    // Método auxiliar para manejar la visibilidad de campos
    private void habilitarCamposDefensa(boolean habilitar) {
        // Daño y Rango se habilitan/deshabilitan en el itemStateChanged de cmbSubtipo, 
        // así que por defecto los habilitamos aquí.
        txfDanio.setEnabled(habilitar);
        txfRango.setEnabled(habilitar);
        txfGolpes.setEnabled(habilitar);
    }


    private void actualizarSubtiposDefensa() {
        // Subtipos de Defensas (DefensasAtacantes y Bloque)
        String[] subtiposDefensa = {
            "Bloque",           // No ataca
            "Contacto",         // Muro de pinchos, Valla eléctrica, Martillo
            "MedianoAlcance",   // Lanzallamas, Cañón, Metralleta
            "Aerea",            // Dron, Globo, Helicóptero armado
            "Impacto",          // Mina, Barril explosivo
            "AtaqueMultiple"    // Arco de flechas, Lanzador de misiles, Cañón de clavos, Torre ametralladora
        };
        cmbSubtipo.setModel(new javax.swing.DefaultComboBoxModel<>(subtiposDefensa));
    }
    
    private void actualizarSubtiposZombie() {
        // Subtipos de Zombies
        String[] subtiposZombie = {
            "Aereo", 
            "Contacto", 
            "Choque", 
            "Medio"
        };
        cmbSubtipo.setModel(new javax.swing.DefaultComboBoxModel<>(subtiposZombie));
    }

    private void seleccionarImagen() {
        JFileChooser chooser = new JFileChooser();
        File directorioImagenes = new File("imagenes");
        
        if (directorioImagenes.exists() && directorioImagenes.isDirectory()) {
        chooser.setCurrentDirectory(directorioImagenes);
    }
        chooser.setFileFilter(new FileNameExtensionFilter("Imágenes", "jpg", "png", "jpeg"));
        
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File archivo = chooser.getSelectedFile();
            String rutaRelativa = "imagenes" + File.separator + archivo.getName();
            String nombreArchivo = archivo.getName();
            rutaImagen = archivo.getAbsolutePath();
            nombreArchivoImagen = nombreArchivo;
            ImageIcon icon = new ImageIcon(new ImageIcon(rutaImagen).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
            lblImagen.setIcon(icon);
        }
    }

    private void guardarEnJson(TipoComponente nuevo) {
        List<TipoComponente> lista = new ArrayList<>();
        File archivo = new File("componentes.json");

        if (archivo.exists()) {
            try (Reader reader = new FileReader(archivo)) {
                lista = new Gson().fromJson(reader, new TypeToken<List<TipoComponente>>(){}.getType());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        lista.add(nuevo);

        try (Writer writer = new FileWriter(archivo)) {
            new Gson().toJson(lista, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfNombre = new javax.swing.JTextField();
        txfVida = new javax.swing.JTextField();
        txfDanio = new javax.swing.JTextField();
        txfNivelAparicion = new javax.swing.JTextField();
        txfGolpes = new javax.swing.JTextField();
        txfRango = new javax.swing.JTextField();
        cmbTipo = new javax.swing.JComboBox<>();
        cmbSubtipo = new javax.swing.JComboBox<>();
        btnImagen = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnVerLista = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreActionPerformed(evt);
            }
        });

        txfVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfVidaActionPerformed(evt);
            }
        });

        txfDanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfDanioActionPerformed(evt);
            }
        });

        txfNivelAparicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNivelAparicionActionPerformed(evt);
            }
        });

        txfGolpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfGolpesActionPerformed(evt);
            }
        });

        txfRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRangoActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zombie", "Defensa", " " }));

        cmbSubtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacto", "Aereo", "Impacto", " " }));
        cmbSubtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSubtipoItemStateChanged(evt);
            }
        });

        btnImagen.setText("Seleccionar Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar Componente");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVerLista.setText("Ver Componentes Guardados");
        btnVerLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerListaActionPerformed(evt);
            }
        });

        jLabel1.setText("Crear Componente");

        jLabel2.setText("Tipo");

        jLabel3.setText("Vida");

        jLabel4.setText("Daño");

        jLabel5.setText("Nivel de Aparición");

        jLabel6.setText("Golpes por Segundo");

        jLabel7.setText("Rango de Ataque");

        jLabel9.setText("Tipo");

        jLabel10.setText("Nombre");

        lblImagen.setText("Imagen");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(149, 149, 149)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txfNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
                                    .addComponent(txfVida)
                                    .addComponent(txfDanio)
                                    .addComponent(txfNivelAparicion)
                                    .addComponent(txfGolpes)
                                    .addComponent(txfRango)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(228, 228, 228)
                                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(228, 228, 228)
                                    .addComponent(cmbSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, Short.MAX_VALUE)
                        .addComponent(btnVerLista))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(btnImagen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(btnGuardar)
                        .addGap(30, 30, 30)
                        .addComponent(btnVerLista)
                        .addGap(72, 72, 72))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cmbSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(txfVida, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txfDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txfNivelAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfRango, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImagen)
                        .addGap(49, 49, 49)
                        .addComponent(btnImagen)
                        .addGap(29, 29, 29))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreActionPerformed

    private void txfVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfVidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfVidaActionPerformed

    private void txfDanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDanioActionPerformed

    private void txfNivelAparicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNivelAparicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNivelAparicionActionPerformed

    private void txfGolpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfGolpesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfGolpesActionPerformed

    private void txfRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRangoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            // Validaciones básicas
            if (txfNombre.getText().trim().isEmpty() || txfVida.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre y la vida son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (rutaImagen == null || rutaImagen.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona una imagen antes de guardar.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Obtener datos
            String nombre = txfNombre.getText().trim();
            String tipo = cmbTipo.getSelectedItem().toString();
            String subtipo = cmbSubtipo.getSelectedItem().toString();
            int vida = Integer.parseInt(txfVida.getText());
            int nivel = Integer.parseInt(txfNivelAparicion.getText());
            
            // Si el subtipo es "Bloque", no tiene daño, golpes ni rango. Se guardan en 0.
            int danio = 0;
            int golpes = 0;
            int rango = 0;

            if (!subtipo.equals("Bloque")) {
                danio = Integer.parseInt(txfDanio.getText());
                golpes = Integer.parseInt(txfGolpes.getText());
                rango = Integer.parseInt(txfRango.getText());
                
                if (danio <= 0 || golpes <= 0) {
                     JOptionPane.showMessageDialog(this, "El daño y los golpes por segundo deben ser mayores a 0 para componentes atacantes.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                     return;
                }
            }


            TipoComponente componente = new TipoComponente(nombre, vida, danio, nivel, golpes, rango, tipo, subtipo, rutaImagen);
            GestorComponentes.guardarComponente(componente);
            JOptionPane.showMessageDialog(this, "Componente '" + nombre + "' guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Limpiar campos después de guardar
            txfNombre.setText("");
            txfVida.setText("");
            txfDanio.setText("");
            txfNivelAparicion.setText("");
            txfGolpes.setText("");
            txfRango.setText("");
            lblImagen.setIcon(null);
            lblImagen.setText("Imagen");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: Asegúrate de que los campos de Vida, Daño, Nivel, Golpes y Rango contengan números enteros válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (HeadlessException e) {
            logger.log(java.util.logging.Level.SEVERE, "Error al guardar componente", e);
            JOptionPane.showMessageDialog(this, "Error al guardar: " + e.getMessage(), "Error Desconocido", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    
    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        seleccionarImagen();
    }//GEN-LAST:event_btnImagenActionPerformed

    private void cmbSubtipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbSubtipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbSubtipoItemStateChanged

    private void btnVerListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerListaActionPerformed
        List<TipoComponente> componentes = GestorComponentes.cargarComponentes();
    
        // 2. Construir el mensaje a mostrar
        if (componentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No hay componentes guardados.", "Lista Vacía", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- Componentes Guardados (Total: ").append(componentes.size()).append(") ---\n");

        for (TipoComponente c : componentes) {
            sb.append("\n");
            sb.append("Nombre: ").append(c.getNombre()).append(" (").append(c.getTipo()).append("/").append(c.getSubtipo()).append(")\n");
            sb.append("Vida: ").append(c.getVida()).append(" | Daño: ").append(c.getDanio()).append("\n");
            sb.append("Imagen: ").append(c.getImagen()).append("\n");
        }

        // 3. Mostrar el resultado en una ventana de diálogo
        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Componentes Cargados", JOptionPane.INFORMATION_MESSAGE);
    
    }//GEN-LAST:event_btnVerListaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new VentanaConfiguracion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnVerLista;
    private javax.swing.JComboBox<String> cmbSubtipo;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txfDanio;
    private javax.swing.JTextField txfGolpes;
    private javax.swing.JTextField txfNivelAparicion;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfRango;
    private javax.swing.JTextField txfVida;
    // End of variables declaration//GEN-END:variables
}
