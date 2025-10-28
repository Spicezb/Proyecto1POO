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
                    } else if (tipoSeleccionado.equals("Zombie")) {
                        actualizarSubtiposZombie();
                        habilitarCamposZombie(); 
                    } else {
                        cmbSubtipo.setModel(new DefaultComboBoxModel<>());
                        habilitarCamposDefensa(true); 
                    }
                }
            }
        });
        
        cmbSubtipo.addItemListener(new java.awt.event.ItemListener() {
            @Override
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
                    String tipoSeleccionado = cmbTipo.getSelectedItem().toString();
                    String subtipoSeleccionado = (String) cmbSubtipo.getSelectedItem();
                    boolean esBloque = "Bloque".equals(subtipoSeleccionado);
                        if (esBloque){
                            txfDanio.setEnabled(false);
                            txfGolpes.setEnabled(false);
                            txfRango.setEnabled(false);
                        }
                        else
                            if(tipoSeleccionado.equals("Defensa"))
                                habilitarCamposDefensa(true);
                            else
                                habilitarCamposZombie();
                }
            }
        });
    }
    
    private void habilitarCamposDefensa(boolean habilitar) {
        
        txfDanio.setEnabled(habilitar);
        txfGolpes.setEnabled(habilitar);
        txfRango.setEnabled(habilitar);
        txfVelocidad.setEnabled(false);
    }
    
    private void habilitarCamposZombie() {
        
        txfDanio.setEnabled(true);
        txfGolpes.setEnabled(true);
        txfRango.setEnabled(true);
        txfVelocidad.setEnabled(true);
    }


    private void actualizarSubtiposDefensa() {
        // Subtipos de Defensas (DefensasAtacantes y Bloque)
        String[] subtiposDefensa = {
            "Bloque",          
            "Contacto",         
            "Mediano Alcance",   
            "Aerea",          
            "Impacto",          
            "Ataque Múltiple"    
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txfGolpes = new javax.swing.JTextField();
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
        jLabel8 = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        txfDanio = new javax.swing.JTextField();
        txfNivelAparicion = new javax.swing.JTextField();
        txfVida = new javax.swing.JTextField();
        txfVelocidad = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txfRango = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));

        txfGolpes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfGolpesActionPerformed(evt);
            }
        });

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Zombie", "Defensa", " " }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        cmbSubtipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Contacto", "Aereo", "Impacto", " " }));
        cmbSubtipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbSubtipoItemStateChanged(evt);
            }
        });

        btnImagen.setBackground(new java.awt.Color(0, 204, 204));
        btnImagen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnImagen.setForeground(new java.awt.Color(0, 102, 102));
        btnImagen.setText("Seleccionar Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(102, 255, 102));
        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(51, 102, 0));
        btnGuardar.setText("Guardar Componente");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnVerLista.setBackground(new java.awt.Color(102, 204, 255));
        btnVerLista.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVerLista.setForeground(new java.awt.Color(0, 0, 153));
        btnVerLista.setText("Ver Componentes Guardados");
        btnVerLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerListaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SimSun-ExtG", 1, 24)); // NOI18N
        jLabel1.setText("Crear Componente");

        jLabel2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel2.setText("Tipo");

        jLabel3.setText("Vida");

        jLabel4.setText("Daño");

        jLabel5.setText("Nivel de Aparición");

        jLabel6.setText("Golpes por Segundo");

        jLabel7.setText("Rango de Ataque");

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        jLabel9.setText("SubTipo");

        jLabel10.setText("Nombre");

        lblImagen.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lblImagen.setOpaque(true);

        jLabel8.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 24)); // NOI18N
        jLabel8.setText("Características");

        txfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreActionPerformed(evt);
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

        txfVida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfVidaActionPerformed(evt);
            }
        });

        txfVelocidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfVelocidadActionPerformed(evt);
            }
        });

        jLabel11.setText("Velocidad");

        txfRango.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfRangoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnImagen)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(77, 77, 77)
                            .addComponent(jLabel8))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(287, 287, 287)
                            .addComponent(btnVerLista))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(167, 167, 167)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(58, 58, 58)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cmbSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txfGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfNivelAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfRango, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfVida, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnGuardar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel9))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbSubtipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfNombre))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfVida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfDanio, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfGolpes, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txfNivelAparicion, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(btnImagen))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txfRango, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txfVelocidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnGuardar))
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btnVerLista)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfGolpesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfGolpesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfGolpesActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        try {
            
            if (txfNombre.getText().trim().isEmpty() || txfVida.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "El nombre y la vida son obligatorios.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (rutaImagen == null || rutaImagen.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor selecciona una imagen antes de guardar.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

           

            String nombre = txfNombre.getText().trim();
            String tipo = cmbTipo.getSelectedItem().toString();
            String subtipo = cmbSubtipo.getSelectedItem().toString();

            
            int vida = Integer.parseInt(txfVida.getText().trim());

           
            int nivel = 0;
            int Velocidad = 0;
            int danio = 0;
            int golpes = 0;
            int rango = 0;

            String nivelText = txfNivelAparicion.getText().trim();
            if (!nivelText.isEmpty()) {
                nivel = Integer.parseInt(nivelText);
            }

     
            String velocidadText = txfVelocidad.getText().trim();
            if (!velocidadText.isEmpty()) {
                Velocidad = Integer.parseInt(velocidadText);
            }


            String danioText = txfDanio.getText().trim();
            if (!danioText.isEmpty()) {
                danio = Integer.parseInt(danioText);
            }

     
            String golpesText = txfGolpes.getText().trim();
            if (!golpesText.isEmpty()) {
                golpes = Integer.parseInt(golpesText);
            }

     
            String rangoText = txfRango.getText().trim();
            if (!rangoText.isEmpty()) {
                rango = Integer.parseInt(rangoText);
            }


            if (tipo.equals("Defensa")) {
                Velocidad = 0; 
            }

            if (!subtipo.equals("Bloque")) {
                if (danio <= 0 || golpes <= 0) {
                    JOptionPane.showMessageDialog(this, "El daño y los golpes por segundo deben ser mayores a 0 para componentes atacantes.", "Error de Validación", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } else {
  
                danio = 0;
                golpes = 0;
                rango = 0;
            }

    
            TipoComponente componente = new TipoComponente(nombre, vida, danio, nivel, golpes, rango, tipo, subtipo, rutaImagen, Velocidad);
            GestorComponentes.guardarComponente(componente);
            JOptionPane.showMessageDialog(this, "Componente '" + nombre + "' guardado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

         
            txfNombre.setText("");
            txfVida.setText("");
            txfDanio.setText("");
            txfNivelAparicion.setText("");
            txfGolpes.setText("");
            txfRango.setText("");
            txfVelocidad.setText("");
            lblImagen.setIcon(null);
            lblImagen.setText(""); 

    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: Asegúrate de que los campos numéricos contengan números enteros válidos.", "Error de Formato", JOptionPane.ERROR_MESSAGE);
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

        JTextArea textArea = new JTextArea(sb.toString());
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 300));

        JOptionPane.showMessageDialog(this, scrollPane, "Lista de Componentes Cargados", JOptionPane.INFORMATION_MESSAGE);
    
    }//GEN-LAST:event_btnVerListaActionPerformed

    private void txfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreActionPerformed

    private void txfDanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfDanioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfDanioActionPerformed

    private void txfNivelAparicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNivelAparicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNivelAparicionActionPerformed

    private void txfVidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfVidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfVidaActionPerformed

    private void txfVelocidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfVelocidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfVelocidadActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txfRangoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfRangoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfRangoActionPerformed

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
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JTextField txfDanio;
    private javax.swing.JTextField txfGolpes;
    private javax.swing.JTextField txfNivelAparicion;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfRango;
    private javax.swing.JTextField txfVelocidad;
    private javax.swing.JTextField txfVida;
    // End of variables declaration//GEN-END:variables
}
