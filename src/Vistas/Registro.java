package Vistas;

import Controlador.Conexion;
import static Controlador.Conexion.getConexion;
import static Proyectogame.Usuario.getUsuario;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.time.Year;
import javax.swing.JOptionPane;

public class Registro extends javax.swing.JFrame {

    Conexion con = getConexion();

    public Registro() {
        initComponents();

        con.conectar();
        setLocationRelativeTo(null);

        for (int i = 1; i < 32; i++) {
            cDia.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cMes.addItem(String.valueOf(i));
        }
        for (int i = 1960; i < 2023; i++) {
            cAno.addItem(String.valueOf(i));
        }
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
        jtCorreo = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        cDia = new javax.swing.JComboBox<>();
        cMes = new javax.swing.JComboBox<>();
        cAno = new javax.swing.JComboBox<>();
        cSexo = new javax.swing.JComboBox<>();
        jpContraseña = new javax.swing.JPasswordField();
        bRegistro = new javax.swing.JButton();
        bCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        panelPrincipal.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Correo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel2.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel3.setText("Apellido:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel4.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel5.setText("Fecha nacimiento:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel5, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel6.setText("Sexo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jLabel6, gridBagConstraints);

        jtCorreo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtCorreo.setMinimumSize(new java.awt.Dimension(64, 25));
        jtCorreo.setPreferredSize(new java.awt.Dimension(71, 25));
        jtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtCorreoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtCorreo, gridBagConstraints);

        jtNombre.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtNombre.setMinimumSize(new java.awt.Dimension(64, 25));
        jtNombre.setPreferredSize(new java.awt.Dimension(71, 25));
        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtNombreKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtNombre, gridBagConstraints);

        jtApellido.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtApellido.setMinimumSize(new java.awt.Dimension(64, 25));
        jtApellido.setPreferredSize(new java.awt.Dimension(71, 25));
        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtApellidoKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jtApellido, gridBagConstraints);

        cDia.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cDia.setMinimumSize(new java.awt.Dimension(72, 25));
        cDia.setPreferredSize(new java.awt.Dimension(72, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(cDia, gridBagConstraints);

        cMes.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cMes.setMinimumSize(new java.awt.Dimension(72, 25));
        cMes.setPreferredSize(new java.awt.Dimension(72, 25));
        cMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cMesActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(cMes, gridBagConstraints);

        cAno.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cAno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1959" }));
        cAno.setMinimumSize(new java.awt.Dimension(72, 25));
        cAno.setPreferredSize(new java.awt.Dimension(72, 25));
        cAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cAnoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(cAno, gridBagConstraints);

        cSexo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "Otro" }));
        cSexo.setMinimumSize(new java.awt.Dimension(72, 25));
        cSexo.setPreferredSize(new java.awt.Dimension(72, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(cSexo, gridBagConstraints);

        jpContraseña.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jpContraseña.setPreferredSize(new java.awt.Dimension(71, 25));
        jpContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jpContraseñaKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(jpContraseña, gridBagConstraints);

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
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(bRegistro, gridBagConstraints);

        bCancelar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bCancelar.setText("Cancelar");
        bCancelar.setMaximumSize(new java.awt.Dimension(150, 25));
        bCancelar.setMinimumSize(new java.awt.Dimension(150, 25));
        bCancelar.setPreferredSize(new java.awt.Dimension(150, 25));
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        panelPrincipal.add(bCancelar, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        getContentPane().add(panelPrincipal, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bRegistroActionPerformed
        if ((!jtNombre.getText().trim().isEmpty()
                || !jtApellido.getText().trim().isEmpty()
                || !jpContraseña.getText().trim().isEmpty())
                || !jtCorreo.getText().trim().isEmpty()
                && jtCorreo.getText().trim().matches("^[a-zA-Z0-9_\\-\\.]+@[a-zA-Z0-9_\\-\\.]+\\.[a-zA-Z]{2,4}$")) {

            getUsuario().setCorreo(jtCorreo.getText());
            getUsuario().setNombre(jtNombre.getText());
            getUsuario().setApellido(jtApellido.getText());
            getUsuario().setPassword(jpContraseña.getText());
            getUsuario().setSexo(String.valueOf(cSexo.getSelectedItem()));
            getUsuario().setFecNac(Date.valueOf(
                    String.valueOf(cAno.getSelectedItem())
                    + "-" + String.valueOf(cMes.getSelectedItem())
                    + "-" + String.valueOf(cDia.getSelectedItem())
            ));

            if (con.agregarUsuario(getUsuario())) {
                dispose();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Falta rellenar campos o el correo electronico es incorrecto", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bRegistroActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_bCancelarActionPerformed

    private void cMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cMesActionPerformed
        if (cMes.getSelectedIndex() == 0
                || cMes.getSelectedIndex() == 2
                || cMes.getSelectedIndex() == 4
                || cMes.getSelectedIndex() == 6
                || cMes.getSelectedIndex() == 7
                || cMes.getSelectedIndex() == 9
                || cMes.getSelectedIndex() == 11) {
            cDia.removeAllItems();
            for (int i = 1; i < 32; i++) {
                cDia.addItem(String.valueOf(i));
            }
        } else if (cMes.getSelectedIndex() == 3
                || cMes.getSelectedIndex() == 5
                || cMes.getSelectedIndex() == 8
                || cMes.getSelectedIndex() == 10) {
            cDia.removeAllItems();
            for (int i = 1; i < 31; i++) {
                cDia.addItem(String.valueOf(i));
            }
        }
        if (Year.isLeap(Integer.parseInt((String) cAno.getSelectedItem()))) {
            if (cMes.getSelectedIndex() == 1) {
                cDia.removeAllItems();
                for (int i = 1; i < 30; i++) {
                    cDia.addItem(String.valueOf(i));
                }
            }
        } else {
            if (cMes.getSelectedIndex() == 1) {
                cDia.removeAllItems();
                for (int i = 1; i < 29; i++) {
                    cDia.addItem(String.valueOf(i));
                }
            }
        }
    }//GEN-LAST:event_cMesActionPerformed

    private void cAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cAnoActionPerformed
        if (Year.isLeap(Integer.parseInt((String) cAno.getSelectedItem()))) {
            if (cMes.getSelectedIndex() == 1) {
                cDia.removeAllItems();
                for (int i = 1; i < 30; i++) {
                    cDia.addItem(String.valueOf(i));
                }
            }
        } else {
            if (cMes.getSelectedIndex() == 1) {
                cDia.removeAllItems();
                for (int i = 1; i < 29; i++) {
                    cDia.addItem(String.valueOf(i));
                }
            }
        }
    }//GEN-LAST:event_cAnoActionPerformed

    private void jtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyPressed
        char c = evt.getKeyChar();
        int keyCode = evt.getKeyCode();
        if (!(Character.isLetter(c) || keyCode == KeyEvent.VK_DELETE || keyCode == KeyEvent.VK_BACK_SPACE || keyCode == KeyEvent.VK_LEFT || keyCode == KeyEvent.VK_RIGHT)) {
            evt.consume();
        }
        if (jtNombre.getText().trim().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jtNombreKeyPressed

    private void jtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyPressed
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c)) || !(c == evt.VK_DELETE)) {
            evt.consume();
        }
        if (jtApellido.getText().trim().length() >= 50) {
            evt.consume();
        }
    }//GEN-LAST:event_jtApellidoKeyPressed

    private void jtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtCorreoKeyPressed
        char c = evt.getKeyChar();
        if (c == ' ') {
            evt.consume();
        }
        if (jtCorreo.getText().trim().length() >= 80) {
            evt.consume();
        }
    }//GEN-LAST:event_jtCorreoKeyPressed

    private void jpContraseñaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jpContraseñaKeyPressed
        char c = evt.getKeyChar();
        if (c == ' ') {
            evt.consume();
        }
        if (jpContraseña.getText().trim().length() >= 80) {
            evt.consume();
        }
    }//GEN-LAST:event_jpContraseñaKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bRegistro;
    private javax.swing.JComboBox<String> cAno;
    private javax.swing.JComboBox<String> cDia;
    private javax.swing.JComboBox<String> cMes;
    private javax.swing.JComboBox<String> cSexo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPasswordField jpContraseña;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtCorreo;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JPanel panelPrincipal;
    // End of variables declaration//GEN-END:variables
}
