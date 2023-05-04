package Vistas;

import Controlador.Conexion;
import Proyectogame.FiltroPassword;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class InicioSesion extends javax.swing.JFrame {
    Conexion con = Conexion.getConexion();

    public InicioSesion() {
        initComponents();
        setLocationRelativeTo(null);
        AbstractDocument document1 = (AbstractDocument) jpContraseña.getDocument();
        document1.setDocumentFilter(new FiltroPassword());
        con.conectar();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jpContraseña = new javax.swing.JTextField();
        bInicio = new javax.swing.JButton();
        bRegistro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Nombre de usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jLabel2, gridBagConstraints);

        jtUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtUsuario.setMaximumSize(new java.awt.Dimension(200, 25));
        jtUsuario.setMinimumSize(new java.awt.Dimension(200, 25));
        jtUsuario.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jtUsuario, gridBagConstraints);

        jpContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jpContraseña.setMaximumSize(new java.awt.Dimension(200, 25));
        jpContraseña.setMinimumSize(new java.awt.Dimension(200, 25));
        jpContraseña.setPreferredSize(new java.awt.Dimension(200, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(jpContraseña, gridBagConstraints);

        bInicio.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bInicio.setText("Iniciar sesion");
        bInicio.setMaximumSize(new java.awt.Dimension(150, 25));
        bInicio.setMinimumSize(new java.awt.Dimension(150, 25));
        bInicio.setPreferredSize(new java.awt.Dimension(150, 25));
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(bInicio, gridBagConstraints);

        bRegistro.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bRegistro.setText("Registrarse");
        bRegistro.setMaximumSize(new java.awt.Dimension(150, 25));
        bRegistro.setMinimumSize(new java.awt.Dimension(150, 25));
        bRegistro.setPreferredSize(new java.awt.Dimension(150, 25));
        bRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bRegistroActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(bRegistro, gridBagConstraints);

        getContentPane().add(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed
        
        con.conectar();

        if (jtUsuario.getText().trim().matches("^[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,4}$")) {
            if (con.iniciarSesion(jtUsuario.getText(), jpContraseña.getText())) {
                VentanaUsuario veUs = new VentanaUsuario();
                veUs.jlBienvenido.setText(jtUsuario.getText());
                veUs.bAnadir.setVisible(false);
                veUs.setVisible(true);
                dispose();
            }
        } else if (jtUsuario.getText().equals("ADMIN") && jpContraseña.getText().equals("123")) {
            VentanaUsuario veUs = new VentanaUsuario();
            veUs.jlBienvenido.setText(jtUsuario.getText());
            veUs.bMisJuegos.setVisible(false);
            veUs.bAnadir.setVisible(true);
            veUs.setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "El correo es invalido", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bInicioActionPerformed

    private void bRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistroActionPerformed
        new Registro().setVisible(true);
    }//GEN-LAST:event_bRegistroActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jpContraseña;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
