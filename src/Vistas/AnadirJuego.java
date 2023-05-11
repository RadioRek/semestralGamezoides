package Vistas;

import static Controlador.Conexion.getConexion;
import static Proyectogame.Juego.getJuego;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class AnadirJuego extends javax.swing.JFrame {

    JFileChooser selector = new JFileChooser();
    FileNameExtensionFilter filtro = new FileNameExtensionFilter("PNG, JPG y JPEG", "png", "jpeg", "jpg");
    File img = null;
    Image imagenEscalada;
    ImageIcon imagen;
    FileInputStream fis;
            
    public AnadirJuego() {
        initComponents();
        selector.setFileFilter(filtro);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
        jtaDesc = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jtOwner = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Titulo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Estudio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Rating:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Idioma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Plataforma:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Valor:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel7.setText("Caratula:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel7, gridBagConstraints);

        jtTitulo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtTitulo.setMaximumSize(new java.awt.Dimension(250, 25));
        jtTitulo.setMinimumSize(new java.awt.Dimension(250, 25));
        jtTitulo.setPreferredSize(new java.awt.Dimension(250, 25));
        jtTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTituloKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtTitulo, gridBagConstraints);

        jtEstudio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtEstudio.setMaximumSize(new java.awt.Dimension(250, 25));
        jtEstudio.setMinimumSize(new java.awt.Dimension(250, 25));
        jtEstudio.setPreferredSize(new java.awt.Dimension(250, 25));
        jtEstudio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEstudioKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtEstudio, gridBagConstraints);

        jtIdioma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtIdioma.setMaximumSize(new java.awt.Dimension(250, 25));
        jtIdioma.setMinimumSize(new java.awt.Dimension(250, 25));
        jtIdioma.setPreferredSize(new java.awt.Dimension(250, 25));
        jtIdioma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtIdiomaKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtIdioma, gridBagConstraints);

        jtPlataforma.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtPlataforma.setMaximumSize(new java.awt.Dimension(250, 25));
        jtPlataforma.setMinimumSize(new java.awt.Dimension(250, 25));
        jtPlataforma.setPreferredSize(new java.awt.Dimension(250, 25));
        jtPlataforma.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPlataformaKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtPlataforma, gridBagConstraints);

        jtValor.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtValor.setMaximumSize(new java.awt.Dimension(250, 25));
        jtValor.setMinimumSize(new java.awt.Dimension(250, 25));
        jtValor.setPreferredSize(new java.awt.Dimension(250, 25));
        jtValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtValorKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(bAnadir, gridBagConstraints);

        jlImg.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(cRating, gridBagConstraints);

        jLabel8.setText("Descripcion: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel8, gridBagConstraints);

        jtaDesc.setColumns(20);
        jtaDesc.setLineWrap(true);
        jtaDesc.setRows(5);
        jtaDesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtaDescKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jtaDesc);

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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel9, gridBagConstraints);

        jtOwner.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtOwnerKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtOwner, gridBagConstraints);

        getContentPane().add(panelPrincipal, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSelectorActionPerformed
        int carga = selector.showOpenDialog(null);
        if (carga == JFileChooser.APPROVE_OPTION) {
            File img = selector.getSelectedFile();
            try {
                imagen = new ImageIcon(img.getAbsolutePath());
                imagenEscalada = imagen.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
                fis = new FileInputStream(img);
                getJuego().setCaratula(fis);
                jlImg.setIcon(new ImageIcon(imagenEscalada));
                pack();
                setLocationRelativeTo(null);
                JOptionPane.showMessageDialog(null, "La imagen se ha cargado correctamente.", "Imagen cargada", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "No se ha podido cargar la imagen", "Error al cargar la imagen", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_bSelectorActionPerformed

    private void bAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirActionPerformed
        if (!jtTitulo.getText().trim().isEmpty()
                || !jtEstudio.getText().trim().isEmpty()
                || !jtaDesc.getText().trim().isEmpty()
                || !jtIdioma.getText().trim().isEmpty()
                || !jtPlataforma.getText().trim().isEmpty()
                || !jtValor.getText().trim().isEmpty()
                || (img != null)
                || !jtOwner.getText().trim().isEmpty()
                && jtOwner.getText().trim().matches("^[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,4}$")) {

            getJuego().setTitulo(jtTitulo.getText());
            getJuego().setEstudio(jtEstudio.getText());
            getJuego().setDescripcion(jtaDesc.getText());
            getJuego().setRating(String.valueOf(cRating.getSelectedItem()));
            getJuego().setIdioma(jtIdioma.getText());
            getJuego().setPlataforma(jtPlataforma.getText());
            getJuego().setValor(Integer.valueOf((String) jtValor.getText()));
            getJuego().setCorreoDueño(jtOwner.getText());
            getConexion().conectar();
            if(getConexion().agregarJuego(getJuego())){
                dispose();
            }
            
            
            
            
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellenar campos", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bAnadirActionPerformed

    private void jtTituloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTituloKeyTyped
        if (jtTitulo.getText().trim().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jtTituloKeyTyped

    private void jtEstudioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEstudioKeyTyped
        if (jtEstudio.getText().trim().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jtEstudioKeyTyped

    private void jtaDescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtaDescKeyTyped
        if (jtaDesc.getText().trim().length() >= 300) {
            evt.consume();
        }
    }//GEN-LAST:event_jtaDescKeyTyped

    private void jtIdiomaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtIdiomaKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isLetter(c)) {
            evt.consume();
        }
        if (jtIdioma.getText().trim().length() >= 30) {
            evt.consume();
        }
    }//GEN-LAST:event_jtIdiomaKeyTyped

    private void jtPlataformaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPlataformaKeyTyped
        if (jtPlataforma.getText().trim().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtPlataformaKeyTyped

    private void jtValorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtValorKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (jtValor.getText().trim().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_jtValorKeyTyped

    private void jtOwnerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtOwnerKeyTyped
        char c = evt.getKeyChar();
        if (c == ' ') {
            evt.consume();
        }
        if (jtOwner.getText().trim().length() >= 80) {
            evt.consume();
        }
    }//GEN-LAST:event_jtOwnerKeyTyped

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
    private javax.swing.JLabel jlImg;
    private javax.swing.JTextField jtEstudio;
    private javax.swing.JTextField jtIdioma;
    private javax.swing.JTextField jtOwner;
    private javax.swing.JTextField jtPlataforma;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JTextField jtValor;
    private javax.swing.JTextArea jtaDesc;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
