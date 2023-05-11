package Vistas;

import static Controlador.Conexion.getConexion;

public class ventaJuego extends javax.swing.JFrame {

    public ventaJuego() {
        initComponents();
        getConexion().conectar();
        usuarioLabel.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        precioLabel = new javax.swing.JLabel();
        codLabel = new javax.swing.JLabel();
        campoUser = new javax.swing.JTextField();
        campoPrecio = new javax.swing.JTextField();
        campoCod = new javax.swing.JTextField();
        enviarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();
        paraLabel = new javax.swing.JLabel();
        usuarioLabel = new javax.swing.JLabel();

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

        codLabel.setText("Codigo juego: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(codLabel, gridBagConstraints);

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

        campoCod.setPreferredSize(new java.awt.Dimension(200, 26));
        campoCod.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoCodKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(campoCod, gridBagConstraints);

        enviarButton.setText("Enviar solicitud venta");
        enviarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
        mainPanel.add(enviarButton, gridBagConstraints);

        cancelarButton.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
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
        mainPanel.add(usuarioLabel, gridBagConstraints);

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

    private void campoCodKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoCodKeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)) {
            evt.consume();
        }
        if (campoCod.getText().trim().length() >= 6) {
            evt.consume();
        }
    }//GEN-LAST:event_campoCodKeyTyped

    private void enviarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarButtonActionPerformed
        getConexion().venderJuego(usuarioLabel.getText(), campoUser.getText(), Integer.parseInt(campoCod.getText()) , Integer.parseInt(campoPrecio.getText()));
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
    private javax.swing.JTextField campoCod;
    private javax.swing.JTextField campoPrecio;
    private javax.swing.JTextField campoUser;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JLabel codLabel;
    private javax.swing.JButton enviarButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel paraLabel;
    private javax.swing.JLabel precioLabel;
    public javax.swing.JLabel usuarioLabel;
    // End of variables declaration//GEN-END:variables
}
