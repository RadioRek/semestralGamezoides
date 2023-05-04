package Vistas;

import Controlador.Conexion;
import Proyectogame.FiltroJuego;
import Proyectogame.FiltroNombre;
import Proyectogame.FiltroValor;
import Proyectogame.Juego;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.AbstractDocument;

public class AnadirJuego extends javax.swing.JFrame {

    JFileChooser selector = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG, JPG y JPEG", "png", "jpeg", "jpg");
    Juego ju = Juego.getJuego();
    File img = null;

    public AnadirJuego() {
        initComponents();
        selector.setFileFilter(filtro);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //filtros para campos de texto
        AbstractDocument document1 = (AbstractDocument) jtTitulo.getDocument();
        document1.setDocumentFilter(new FiltroJuego());

        AbstractDocument document2 = (AbstractDocument) jtEstudio.getDocument();
        document2.setDocumentFilter(new FiltroJuego());

        AbstractDocument document3 = (AbstractDocument) jtValor.getDocument();
        document3.setDocumentFilter(new FiltroValor());

        AbstractDocument document4 = (AbstractDocument) jtIdioma.getDocument();
        document4.setDocumentFilter(new FiltroNombre());

        AbstractDocument document5 = (AbstractDocument) jtPlataforma.getDocument();
        document5.setDocumentFilter(new FiltroJuego());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jtEstudio = new javax.swing.JTextField();
        jtIdioma = new javax.swing.JTextField();
        jtPlataforma = new javax.swing.JTextField();
        jtValor = new javax.swing.JTextField();
        bSelector = new javax.swing.JButton();
        bAnadir = new javax.swing.JButton();
        jlImg = new javax.swing.JLabel();
        cRating = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Titulo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Estudio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Rating:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Idioma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Plataforma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Valor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Caratula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel7, gridBagConstraints);

        jtTitulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtTitulo.setMaximumSize(new java.awt.Dimension(250, 25));
        jtTitulo.setMinimumSize(new java.awt.Dimension(250, 25));
        jtTitulo.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtTitulo, gridBagConstraints);

        jtEstudio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtEstudio.setMaximumSize(new java.awt.Dimension(250, 25));
        jtEstudio.setMinimumSize(new java.awt.Dimension(250, 25));
        jtEstudio.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtEstudio, gridBagConstraints);

        jtIdioma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtIdioma.setMaximumSize(new java.awt.Dimension(250, 25));
        jtIdioma.setMinimumSize(new java.awt.Dimension(250, 25));
        jtIdioma.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtIdioma, gridBagConstraints);

        jtPlataforma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtPlataforma.setMaximumSize(new java.awt.Dimension(250, 25));
        jtPlataforma.setMinimumSize(new java.awt.Dimension(250, 25));
        jtPlataforma.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtPlataforma, gridBagConstraints);

        jtValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtValor.setMaximumSize(new java.awt.Dimension(250, 25));
        jtValor.setMinimumSize(new java.awt.Dimension(250, 25));
        jtValor.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtValor, gridBagConstraints);

        bSelector.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bSelector.setText("Seleccionar Archivo...");
        bSelector.setMaximumSize(new java.awt.Dimension(150, 25));
        bSelector.setMinimumSize(new java.awt.Dimension(150, 25));
        bSelector.setPreferredSize(new java.awt.Dimension(150, 25));
        bSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSelectorActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(bSelector, gridBagConstraints);

        bAnadir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bAnadir.setText("Añadir juego");
        bAnadir.setMaximumSize(new java.awt.Dimension(150, 25));
        bAnadir.setMinimumSize(new java.awt.Dimension(150, 25));
        bAnadir.setPreferredSize(new java.awt.Dimension(150, 25));
        bAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(bAnadir, gridBagConstraints);

        jlImg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jlImg, gridBagConstraints);

        cRating.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cRating.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "EC", "E", "E+10", "T", "M", "AO", "RP" }));
        cRating.setMaximumSize(new java.awt.Dimension(250, 25));
        cRating.setMinimumSize(new java.awt.Dimension(250, 25));
        cRating.setPreferredSize(new java.awt.Dimension(250, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        panelPrincipal.add(cRating, gridBagConstraints);

        jLabel8.setText("Descripcion: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel8, gridBagConstraints);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jScrollPane1, gridBagConstraints);

        jLabel9.setText("Dueño: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jTextField1, gridBagConstraints);

        getContentPane().add(panelPrincipal, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectorActionPerformed
        int carga = selector.showOpenDialog(null);
        if (carga == JFileChooser.APPROVE_OPTION) {
            File img = selector.getSelectedFile();
            try {
                ImageIcon imagen = new ImageIcon(img.getAbsolutePath());
                Image imagenEscalada = imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                FileInputStream fis = new FileInputStream(img);
                ju.setCaratula(fis);
                jlImg.setIcon(new ImageIcon(imagenEscalada));
                pack();
                JOptionPane.showMessageDialog(null, "La imagen se ha cargado correctamente.", "Imagen cargada", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podido cargar la imagen", "Error al cargar la imagen", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bSelectorActionPerformed

    private void bAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirActionPerformed
        if (!jtTitulo.getText().trim().isEmpty()
                || !jtEstudio.getText().trim().isEmpty()
                || !jtIdioma.getText().trim().isEmpty()
                || !jtPlataforma.getText().trim().isEmpty()
                || !jtValor.getText().trim().isEmpty()
                || (img != null)) {
            ju.setEstudio(jtEstudio.getText());
            ju.setIdioma(jtIdioma.getText());
            ju.setPlataforma(jtPlataforma.getText());
            ju.setRating(String.valueOf(cRating.getSelectedItem()));
            ju.setTitulo(jtTitulo.getText());
            ju.setValor(Integer.valueOf(jtValor.getText()));
            Conexion con = Conexion.getConexion();
            con.conectar();
            con.agregarJuego(ju);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellenar campos", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bAnadirActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnadirJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAnadir;
    private javax.swing.JButton bSelector;
    private javax.swing.JComboBox<String> cRating;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel jlImg;
    private javax.swing.JTextField jtEstudio;
    private javax.swing.JTextField jtIdioma;
    private javax.swing.JTextField jtPlataforma;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JTextField jtValor;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
