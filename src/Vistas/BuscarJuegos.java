package Vistas;

import static Controlador.Conexion.getConexion;

import javax.swing.table.DefaultTableModel;

public class BuscarJuegos extends javax.swing.JFrame {

    public BuscarJuegos() {
        initComponents();
        getConexion().conectar();
        getConexion().llenarTabla(tabJuegos);
        jlUsuario.setVisible(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        cBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabJuegos = new javax.swing.JTable();
        labelBuscar = new javax.swing.JLabel();
        jtBusqueda = new javax.swing.JTextField();
        bBuscar = new javax.swing.JButton();
        bMasInfo = new javax.swing.JButton();
        jlUsuario = new javax.swing.JLabel();
        buyButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        cBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        cBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titulo", "Estudio" }));
        cBuscar.setMinimumSize(new java.awt.Dimension(92, 25));
        cBuscar.setPreferredSize(new java.awt.Dimension(92, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(cBuscar, gridBagConstraints);

        jScrollPane1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N

        tabJuegos.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        tabJuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titulo", "Estudio", "Precio"
            }
        ));
        jScrollPane1.setViewportView(tabJuegos);
        if (tabJuegos.getColumnModel().getColumnCount() > 0) {
            tabJuegos.getColumnModel().getColumn(0).setPreferredWidth(175);
            tabJuegos.getColumnModel().getColumn(2).setPreferredWidth(50);
        }

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(jScrollPane1, gridBagConstraints);

        labelBuscar.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        labelBuscar.setText("Buscar por:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(labelBuscar, gridBagConstraints);

        jtBusqueda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jtBusqueda.setMinimumSize(new java.awt.Dimension(64, 25));
        jtBusqueda.setPreferredSize(new java.awt.Dimension(64, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
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
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        mainPanel.add(bMasInfo, gridBagConstraints);

        jlUsuario.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        mainPanel.add(jlUsuario, gridBagConstraints);

        buyButton.setText("Comprar juego");
        buyButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyButtonActionPerformed(evt);
            }
        });
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
        if (jtBusqueda.getText().trim().isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            getConexion().llenarTabla(tabJuegos);
        } else {
            DefaultTableModel model = (DefaultTableModel) tabJuegos.getModel();
            model.setRowCount(0);
            String filtro = "tituloJuego";
            if (String.valueOf(cBuscar.getSelectedItem()).equals("Titulo")) {
                filtro = "tituloJuego";
            } else if (String.valueOf(cBuscar.getSelectedItem()).equals("Estudio")) {
                filtro = "estudioJuego";
            }
            getConexion().llenarTablaFiltro(tabJuegos, jtBusqueda.getText(), filtro);
        }
    }//GEN-LAST:event_bBuscarActionPerformed

    private void bMasInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMasInfoActionPerformed
        MasInfo mInfo = new MasInfo();
        String strIdJuego = String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 2));
        int intIdJuego = Integer.parseInt(strIdJuego);
        getConexion().obtenerMasInfo(intIdJuego, mInfo.jlImagen, mInfo.jtaDesc);
        mInfo.revalidate();
        mInfo.repaint();
        mInfo.pack();
        mInfo.setLocationRelativeTo(null);
        mInfo.setVisible(true);
    }//GEN-LAST:event_bMasInfoActionPerformed

    private void buyButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyButtonActionPerformed
        String strIdJuego = String.valueOf(tabJuegos.getModel().getValueAt(tabJuegos.getSelectedRow(), 2));
        int intIdJuego = Integer.parseInt(strIdJuego);
        getConexion().comprarJuegoGamezoides(jlUsuario.getText(), intIdJuego);
    }//GEN-LAST:event_buyButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarJuegos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bBuscar;
    private javax.swing.JButton bMasInfo;
    private javax.swing.JButton buyButton;
    private javax.swing.JComboBox<String> cBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JLabel jlUsuario;
    private javax.swing.JTextField jtBusqueda;
    private javax.swing.JLabel labelBuscar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable tabJuegos;
    // End of variables declaration//GEN-END:variables
}
