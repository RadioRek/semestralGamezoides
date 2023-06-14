package Vistas;

import static Controlador.Conexion.getConexion;
import static Proyectogame.Transaccion.getTransaccion;
import javax.swing.JOptionPane;

public class ventaJuego extends javax.swing.JFrame {

    public ventaJuego() {
        initComponents();
        getConexion().conectar();
        codJuegoLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        precioLabel = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        enviarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        paraLabel = new javax.swing.JLabel();
        codJuegoLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        precioLabel.setText("Precio: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(precioLabel, gridBagConstraints);

        campoUser.setPreferredSize(new java.awt.Dimension(200, 26));
        campoUser.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoUserKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(campoUser, gridBagConstraints);

        campoPrecio.setPreferredSize(new java.awt.Dimension(200, 26));
        campoPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoPrecioKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(campoPrecio, gridBagConstraints);

        enviarButton.setText("Enviar solicitud venta");
        enviarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(enviarButton, gridBagConstraints);

        cancelarButton.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(cancelarButton, gridBagConstraints);

        paraLabel.setText("Para: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(paraLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        mainPanel.add(codJuegoLabel, gridBagConstraints);

        getContentPane().add(mainPanel, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoUserKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoUserKeyTyped
        char c = evt.getKeyChar();
        if (c == ' ') {
            evt.consume();
        }
        if (campoUser.getText().trim().length() >= 80) {
            evt.consume();
        }
    }//GEN-LAST:event_campoUserKeyTyped

    private void campoPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoPrecioKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (campoPrecio.getText().trim().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_campoPrecioKeyTyped

    private void enviarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarButtonActionPerformed
        if (!campoPrecio.getText().trim().isEmpty()
                || !campoUser.getText().trim().isEmpty()) {
            getTransaccion().setCodigo(Integer.parseInt(codJuegoLabel.getText()));
            getTransaccion().setIdEstado(1);
            getTransaccion().setPrecio(Integer.parseInt(campoPrecio.getText()));
            getTransaccion().setTipoTransaccion("Venta");
            getTransaccion().setUsuario(campoUser.getText());

            getConexion().ingresarVenta(getTransaccion());
        } else {
            JOptionPane.showMessageDialog(null, "Falta rellenar campos", "Error", JOptionPane.PLAIN_MESSAGE);

        }
    }//GEN-LAST:event_enviarButtonActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ventaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ventaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ventaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ventaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ventaJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoUser;
    private javax.swing.JButton cancelarButton;
    public javax.swing.JLabel codJuegoLabel;
    private javax.swing.JButton enviarButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel paraLabel;
    private javax.swing.JLabel precioLabel;
    // End of variables declaration//GEN-END:variables
}
