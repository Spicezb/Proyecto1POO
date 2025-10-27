package com.mycompany.proyecto1;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.TransferHandler;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.datatransfer.Transferable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JComponent;

/**
 *
 * @author Xavier
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    private int siguienteId = 1;
    private Partida partida;
    private Casilla[][] matrizCasillas = new Casilla[25][25];
    private Componente componenteSeleccionado;
    private ArrayList<Defensa> todasDefensas = new ArrayList<>();
    private ArrayList<Defensa> equipo = new ArrayList<>();
    private ArrayList<IAtacar> atacantes = new ArrayList();
    private ArrayList<Componente> todos = new ArrayList();
    private ArrayList<Defensa> defensasDisponibles = new ArrayList<>();
    private JPanel pnlDefensas;
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName());
    
    /**
     * Creates new form VentanaPrincipal
     * @param partida
     */
    public VentanaPrincipal(Partida partida) {
        this.partida = partida;
        initComponents();
        inicializarTablero();
        getContentPane().setBackground(Color.blue);
        
        todasDefensas.add(new ArmaAerea(1,7,4,1,5,"Dron","/muro1.jpg",30));
        todasDefensas.add(new ArmaAtaqueMultiple(1,7,4,1,4,"canõn","/muro1.jpg",30));
        todasDefensas.add(new ArmaBloque(8,1,"Murillo","/muro1.jpg", 20));
        todasDefensas.add(new ArmaContacto(1,1,4,1,6,"barbaro","/muro1.jpg",30));
        todasDefensas.add(new ArmaImpacto(1,7,4,1,3,"ariete","/muro1.jpg",30));
        todasDefensas.add(new ArmaMedianoAlcance(1,7,4,1,4,"9mil","/muro1.jpg",30));
        todasDefensas.add(new ReliquiaVida(8));
        
        
        defensasTotales();
        
        pnlDefensas = new JPanel();
        pnlDefensas.setLayout(new BoxLayout(pnlDefensas, BoxLayout.Y_AXIS));
        pnlDefensas.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        pnlDefensas.setBackground(Color.WHITE);
        jScrollPane1.setViewportView(pnlDefensas);
        actualizarScrollDefensas();
    }
    
    private void defensasTotales(){
        defensasDisponibles.clear();
        for (int i = 0; i < todasDefensas.size(); i++) {
            Defensa d = todasDefensas.get(i);
        if (d.getNivelDeAparicion() <= partida.getNivel()) {
            defensasDisponibles.add(d);
    }
    }
    }

    public void actualizarScrollDefensas() {
    pnlDefensas.removeAll(); // Limpiamos el panel antes de agregar nuevos componentes

    for (int i = 0; i < defensasDisponibles.size(); i++) {
        Componente c = defensasDisponibles.get(i);

        // Panel “tarjeta” para cada componente
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.X_AXIS));
        card.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.DARK_GRAY, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        card.setBackground(Color.WHITE);
        card.setMaximumSize(new Dimension(250, 100));

        // Imagen 24x24
        JLabel lblImagen = new JLabel();
        ImageIcon icono = new ImageIcon(getClass().getResource(c.getImagen()));
        Image img = icono.getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH);
        lblImagen.setIcon(new ImageIcon(img));

        // Panel de información (nombre, tipo, vida, ataque si aplica, espacios)
        JPanel panelInfo = new JPanel();
        panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.Y_AXIS));
        panelInfo.setOpaque(false);

        JLabel lblNombre = new JLabel("Nombre: " + c.getNombre());
        lblNombre.setFont(new Font("Arial", Font.BOLD, 12));
        panelInfo.add(lblNombre);

        JLabel lblTipo = new JLabel("Tipo: " + c.getTipo());
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInfo.add(lblTipo);

        JLabel lblVida = new JLabel("Vida: " + c.getVida());
        lblVida.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInfo.add(lblVida);

        if (c instanceof IAtacar) {
            IAtacar atacante = (IAtacar) c;
            JLabel lblAtaque = new JLabel("Ataque: " + atacante.getDanno());
            lblAtaque.setFont(new Font("Arial", Font.PLAIN, 12));
            panelInfo.add(lblAtaque);
        }

        JLabel lblEspacios = new JLabel("Espacios: " + c.getCampos());
        lblEspacios.setFont(new Font("Arial", Font.PLAIN, 12));
        panelInfo.add(lblEspacios);

        // Agregar imagen e info al “card”
        card.add(lblImagen);
        card.add(Box.createRigidArea(new Dimension(10, 0)));
        card.add(panelInfo);

        // Drag & Drop funcional con ComponenteTransferible
        card.setTransferHandler(new TransferHandler() {
            @Override
            protected Transferable createTransferable(JComponent c1) {
                return new ComponenteTransferible(c);
            }

            @Override
            public int getSourceActions(JComponent c1) {
                return COPY;
            }
        });

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JComponent jc = (JComponent) e.getSource();
                jc.getTransferHandler().exportAsDrag(jc, e, TransferHandler.COPY);
            }
        });

        // Agregar tarjeta al panel principal con espacio vertical
        pnlDefensas.add(Box.createRigidArea(new Dimension(0, 5)));
        pnlDefensas.add(card);
    }

    pnlDefensas.revalidate();
    pnlDefensas.repaint();
}

    private void inicializarTablero() {
    pnlTablero.removeAll();
    pnlTablero.setLayout(new GridLayout(25, 25));

    for (int i = 0; i < 25; i++) {
        for (int j = 0; j < 25; j++) {
            Casilla casilla = new Casilla(i, j,this);
            matrizCasillas[i][j] = casilla;

            casilla.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    if (componenteSeleccionado != null && casilla.estaVacia()) {
                        componenteSeleccionado.colocarEn(casilla.getXPos(), casilla.getYPos());
                        casilla.colocarComponente(componenteSeleccionado);
                        componenteSeleccionado = null;
                    }
                }
            });

            pnlTablero.add(casilla);
        }
    }

    pnlTablero.revalidate();
    pnlTablero.repaint();
}
    
    public void agregarDefensaColocada(Componente c) {
        todos.add(c);
        System.out.println(c.getNombre() + " ha sido agregado al juego");
        if (c instanceof IAtacar) {
            atacantes.add((IAtacar) c);
        }
        equipo.add((Defensa) c);
 }
    
    public Componente cloneComponente(Componente plantilla) {
    // Suponemos que tenés un contador de IDs en la ventana
    int nuevoId = siguienteId++;  

    // Llamamos al método clonar de cada componente
    return plantilla.clonar(nuevoId);
}
    
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Partida partida = new Partida(); // Puedes pasar una lista vacía o zombies iniciales
        VentanaPrincipal ventana = new VentanaPrincipal(partida);
        ventana.setVisible(true);
    });
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlTablero = new javax.swing.JPanel();
        pnlObjetos = new javax.swing.JPanel();
        btnNivel = new javax.swing.JButton();
        btnComenzar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        pnlTablero.setBackground(new java.awt.Color(153, 153, 255));
        pnlTablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pnlTablero.setPreferredSize(new java.awt.Dimension(600, 600));
        pnlTablero.setLayout(new java.awt.GridLayout(25, 25));

        pnlObjetos.setBackground(new java.awt.Color(102, 153, 255));
        pnlObjetos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        pnlObjetos.setPreferredSize(new java.awt.Dimension(294, 600));

        btnNivel.setText("-->");
        btnNivel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNivelMouseClicked(evt);
            }
        });

        btnComenzar.setText("Comenzar");

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jLabel1.setText("Ejército:");

        jLabel2.setText("Nivel:");

        javax.swing.GroupLayout pnlObjetosLayout = new javax.swing.GroupLayout(pnlObjetos);
        pnlObjetos.setLayout(pnlObjetosLayout);
        pnlObjetosLayout.setHorizontalGroup(
            pnlObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObjetosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnComenzar)
                .addContainerGap())
            .addGroup(pnlObjetosLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlObjetosLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(pnlObjetosLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43))))
        );
        pnlObjetosLayout.setVerticalGroup(
            pnlObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlObjetosLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(36, 36, 36)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlObjetosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnComenzar)
                    .addComponent(btnNivel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlObjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlObjetos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlTablero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNivelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNivelMouseClicked
        partida.subirNivel();
        defensasTotales();
        actualizarScrollDefensas();
        System.out.println(partida.getNivel());
    }//GEN-LAST:event_btnNivelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComenzar;
    private javax.swing.JButton btnNivel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlObjetos;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
}
