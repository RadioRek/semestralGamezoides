package Vistas;

import static Controlador.Conexion.getConexion;
import javax.swing.table.DefaultTableModel;

public class MisJuegos extends javax.swing.JFrame {

    public MisJuegos() {
        initComponents();
        jlUsuario.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getConexion().conectar();
        DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
        model.setRowCount(0);
        getConexion().llenarTablaFavoritos(tabJuegos, jlUsuario.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        bActualizar = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabJuegos = new javax.swing.JTable();
        quitarButton = new javax.swing.JButton();
        venderButton = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        bActualizar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bActualizar.setText("Actualizar");
        bActualizar.setMaximumSize(new java.awt.Dimension(150, 25));
        bActualizar.setMinimumSize(new java.awt.Dimension(150, 25));
        bActualizar.setPreferredSize(new java.awt.Dimension(150, 25));
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(bActualizar, gridBagConstraints);

        bVolver.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bVolver.setText("Volver");
        bVolver.setMaximumSize(new java.awt.Dimension(150, 25));
        bVolver.setMinimumSize(new java.awt.Dimension(150, 25));
        bVolver.setPreferredSize(new java.awt.Dimension(150, 25));
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(bVolver, gridBagConstraints);

        tabJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Codigo", "Favorito", "Adquirido"
            }
        ));
        jScrollPane2.setViewportView(tabJuegos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(jScrollPane2, gridBagConstraints);

        quitarButton.setText("Quitar favorito");
        quitarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(quitarButton, gridBagConstraints);

        venderButton.setText("Vender Juego");
        venderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(venderButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        panelPrincipal.add(jlUsuario, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelPrincipal, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        getConexion().llenarTablaFavoritos(tabJuegos, jlUsuario.getText());
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        dispose();
    }//GEN-LAST:event_bVolverActionPerformed

    private void quitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarButtonActionPerformed
        String strIdJuego = String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 1));
        int intIdJuego = Integer.parseInt(strIdJuego);
        getConexion().quitarFavorito(intIdJuego, jlUsuario.getText());
    }//GEN-LAST:event_quitarButtonActionPerformed

    private void venderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderButtonActionPerformed
        ventaJuego ven = new ventaJuego();
        ven.usuarioLabel.setText(jlUsuario.getText());
        ven.setVisible(true);
    }//GEN-LAST:event_venderButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MisJuegos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bVolver;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton quitarButton;
    private javax.swing.JTable tabJuegos;
    private javax.swing.JButton venderButton;
    // End of variables declaration//GEN-END:variables
}
