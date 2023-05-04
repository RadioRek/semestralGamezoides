package Vistas;

import Controlador.Conexion;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class BuscarJuegos extends javax.swing.JFrame {

    Conexion con = Conexion.getConexion();

    public BuscarJuegos() {
        initComponents();
        con.conectar();
        con.llenarTabla(tabJuegos);
        jlUsuario.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        bFavorito.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        cBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabJuegos = new javax.swing.JTable();
        bFavorito = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jtBusqueda = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bMasInfo = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        cBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titulo", "Estudio", "Plataforma", "Rating" }));
        cBuscar.setMinimumSize(new java.awt.Dimension(92, 25));
        cBuscar.setPreferredSize(new java.awt.Dimension(92, 25));
        cBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(cBuscar, gridBagConstraints);

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tabJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Estudio", "Plataforma", "Idioma", "Valor", "Rating", "Codigo"
            }
        ));
        jScrollPane1.setViewportView(tabJuegos);
        if (tabJuegos.getColumnModel().getColumnCount() > 0) {
            tabJuegos.getColumnModel().getColumn(0).setPreferredWidth(175);
            tabJuegos.getColumnModel().getColumn(3).setPreferredWidth(50);
            tabJuegos.getColumnModel().getColumn(4).setPreferredWidth(50);
            tabJuegos.getColumnModel().getColumn(5).setPreferredWidth(50);
            tabJuegos.getColumnModel().getColumn(6).setPreferredWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(jScrollPane1, gridBagConstraints);

        bFavorito.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bFavorito.setText("Añadir a favoritos");
        bFavorito.setMaximumSize(new java.awt.Dimension(150, 25));
        bFavorito.setMinimumSize(new java.awt.Dimension(150, 25));
        bFavorito.setPreferredSize(new java.awt.Dimension(150, 25));
        bFavorito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFavoritoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(bFavorito, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jLabel1.setText("Buscar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(jLabel1, gridBagConstraints);

        jtBusqueda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtBusqueda.setMinimumSize(new java.awt.Dimension(64, 25));
        jtBusqueda.setPreferredSize(new java.awt.Dimension(64, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 175;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(jtBusqueda, gridBagConstraints);

        bBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bBuscar.setText("Buscar");
        bBuscar.setMaximumSize(new java.awt.Dimension(150, 25));
        bBuscar.setMinimumSize(new java.awt.Dimension(150, 25));
        bBuscar.setPreferredSize(new java.awt.Dimension(150, 25));
        bBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(bBuscar, gridBagConstraints);

        bMasInfo.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        bMasInfo.setText("Mas Informacion");
        bMasInfo.setMaximumSize(new java.awt.Dimension(150, 25));
        bMasInfo.setMinimumSize(new java.awt.Dimension(150, 25));
        bMasInfo.setPreferredSize(new java.awt.Dimension(150, 25));
        bMasInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMasInfoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(bMasInfo, gridBagConstraints);

        jlUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        mainPanel.add(jlUsuario, gridBagConstraints);

        buyButton.setText("Comprar juego");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(buyButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(mainPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarActionPerformed

        if (cBuscar.getSelectedItem().equals("Titulo")) {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            con.conectar();
            con.llenarTablaTitulo(tabJuegos, jtBusqueda.getText());

        } else if (cBuscar.getSelectedItem().equals("Estudio")) {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            con.conectar();
            con.llenarTablaEstudio(tabJuegos, jtBusqueda.getText());

        } else if (cBuscar.getSelectedItem().equals("Plataforma")) {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            con.conectar();
            con.llenarTablaPlataforma(tabJuegos, jtBusqueda.getText());

        } else if (cBuscar.getSelectedItem().equals("Rating")) {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            con.conectar();
            con.llenarTablaRating(tabJuegos, jtBusqueda.getText());
        } else {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            con.conectar();
            con.llenarTabla(tabJuegos);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bFavoritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFavoritoActionPerformed
        con.conectar();
        String strIdJuego = String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 6));
        Integer intIdJuego = Integer.valueOf(strIdJuego);
        if (con.revisarFavorito(intIdJuego, jlUsuario.getText())) {
            con.agregarFavorito(intIdJuego, jlUsuario.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Ya tienes ese juego como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_bFavoritoActionPerformed

    private void bMasInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasInfoActionPerformed

        MasInfo mInfo = new MasInfo();
        String strIdJuego = String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 6));
        Integer intIdJuego = Integer.valueOf(strIdJuego);
        con.obtenerCaratula(intIdJuego, mInfo.jlImagen);
        mInfo.revalidate();
        mInfo.repaint();
        mInfo.pack();
        mInfo.setVisible(true);
    }//GEN-LAST:event_bMasInfoActionPerformed

    private void cBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cBuscarActionPerformed
        
    }//GEN-LAST:event_cBuscarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarJuegos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    public javax.swing.JButton bFavorito;
    private javax.swing.JButton bMasInfo;
    private javax.swing.JButton buyButton;
    private javax.swing.JComboBox<String> cBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tabJuegos;
    // End of variables declaration//GEN-END:variables
}
