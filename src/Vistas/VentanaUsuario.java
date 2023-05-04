package Vistas;

public class VentanaUsuario extends javax.swing.JFrame {

    public VentanaUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        jlBienvenido = new javax.swing.JLabel();
        bMisJuegos = new javax.swing.JButton();
        bBuscarJuegos = new javax.swing.JButton();
        bAnadir = new javax.swing.JButton();
        labelBienvenido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());
        getContentPane().add(panelPrincipal, new java.awt.GridBagConstraints());

        jlBienvenido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jlBienvenido.setText("PlaceHolder");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(jlBienvenido, gridBagConstraints);

        bMisJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bMisJuegos.setText("Mis juegos");
        bMisJuegos.setMaximumSize(new java.awt.Dimension(150, 25));
        bMisJuegos.setMinimumSize(new java.awt.Dimension(150, 25));
        bMisJuegos.setPreferredSize(new java.awt.Dimension(150, 25));
        bMisJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMisJuegosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bMisJuegos, gridBagConstraints);

        bBuscarJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bBuscarJuegos.setText("Buscar juegos");
        bBuscarJuegos.setMaximumSize(new java.awt.Dimension(150, 25));
        bBuscarJuegos.setMinimumSize(new java.awt.Dimension(150, 25));
        bBuscarJuegos.setPreferredSize(new java.awt.Dimension(150, 25));
        bBuscarJuegos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarJuegosActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bBuscarJuegos, gridBagConstraints);

        bAnadir.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bAnadir.setText("Añadir juegos");
        bAnadir.setMaximumSize(new java.awt.Dimension(150, 25));
        bAnadir.setMinimumSize(new java.awt.Dimension(150, 25));
        bAnadir.setPreferredSize(new java.awt.Dimension(150, 25));
        bAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAnadirActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(bAnadir, gridBagConstraints);

        labelBienvenido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelBienvenido.setText("Bienvenido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(labelBienvenido, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAnadirActionPerformed
        new AnadirJuego().setVisible(true);
    }//GEN-LAST:event_bAnadirActionPerformed

    private void bBuscarJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarJuegosActionPerformed
        if (jlBienvenido.equals("ADMIN")) {
            BuscarJuegos buscar1 = new BuscarJuegos();
            buscar1.jlUsuario.setText(jlBienvenido.getText());
            buscar1.bFavorito.setVisible(false);
            buscar1.setVisible(true);
        } else {
            BuscarJuegos buscar = new BuscarJuegos();
            buscar.jlUsuario.setText(jlBienvenido.getText());
            buscar.bFavorito.setVisible(true);
            buscar.setVisible(true);
        }
    }//GEN-LAST:event_bBuscarJuegosActionPerformed

    private void bMisJuegosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMisJuegosActionPerformed
        MisJuegos mJu = new MisJuegos();
        mJu.jlUsuario.setText(jlBienvenido.getText());
        mJu.setVisible(true);
    }//GEN-LAST:event_bMisJuegosActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton bAnadir;
    public javax.swing.JButton bBuscarJuegos;
    public javax.swing.JButton bMisJuegos;
    public javax.swing.JLabel jlBienvenido;
    private javax.swing.JLabel labelBienvenido;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
