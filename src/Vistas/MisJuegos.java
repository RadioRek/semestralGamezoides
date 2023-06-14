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
        getConexion().llenarTablaMisJuegos(tabJuegos, jlUsuario.getText());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelPrincipal = new javax.swing.JPanel();
        bActualizar = new javax.swing.JButton();
        bAgregarFavorito = new javax.swing.JButton();
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
        bActualizar.setMaximumSize(new java.awt.Dimension(150, 26));
        bActualizar.setMinimumSize(new java.awt.Dimension(150, 26));
        bActualizar.setPreferredSize(new java.awt.Dimension(150, 26));
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

        bAgregarFavorito.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bAgregarFavorito.setText("Añadir favorito");
        bAgregarFavorito.setMaximumSize(new java.awt.Dimension(150, 26));
        bAgregarFavorito.setMinimumSize(new java.awt.Dimension(150, 26));
        bAgregarFavorito.setPreferredSize(new java.awt.Dimension(150, 26));
        bAgregarFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarFavoritoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        panelPrincipal.add(bAgregarFavorito, gridBagConstraints);

        tabJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Favorito", "Codigo"
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
        quitarButton.setMaximumSize(new java.awt.Dimension(150, 26));
        quitarButton.setMinimumSize(new java.awt.Dimension(150, 26));
        quitarButton.setPreferredSize(new java.awt.Dimension(150, 26));
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
        venderButton.setMaximumSize(new java.awt.Dimension(150, 26));
        venderButton.setMinimumSize(new java.awt.Dimension(150, 26));
        venderButton.setPreferredSize(new java.awt.Dimension(150, 26));
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
        getConexion().llenarTablaMisJuegos(tabJuegos, jlUsuario.getText());
    }//GEN-LAST:event_bActualizarActionPerformed

    private void bAgregarFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarFavoritoActionPerformed
        int IdJuego = Integer.parseInt(String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 2)));
        getConexion().agregarFavorito(IdJuego);
    }//GEN-LAST:event_bAgregarFavoritoActionPerformed

    private void quitarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitarButtonActionPerformed
        int IdJuego = Integer.parseInt(String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 2)));
        getConexion().quitarFavorito(IdJuego);
    }//GEN-LAST:event_quitarButtonActionPerformed

    private void venderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderButtonActionPerformed
        ventaJuego ven = new ventaJuego();
        ven.codJuegoLabel.setText(String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 2)));
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
    private javax.swing.JButton bAgregarFavorito;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JLabel jlUsuario;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JButton quitarButton;
    private javax.swing.JTable tabJuegos;
    private javax.swing.JButton venderButton;
    // End of variables declaration//GEN-END:variables
}
