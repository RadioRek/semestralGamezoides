
package Vistas;

public class PopUpVenta extends javax.swing.JFrame {

    public PopUpVenta() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        labelVendedor = new javax.swing.JLabel();
        labelJuego = new javax.swing.JLabel();
        labelVendName = new javax.swing.JLabel();
        labelJuegoName = new javax.swing.JLabel();
        botonPagar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();
        labelPrecio = new javax.swing.JLabel();
        labelPrecioCambiar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        mainPanel.setLayout(new java.awt.GridBagLayout());

        labelVendedor.setText("El usuario: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelVendedor, gridBagConstraints);

        labelJuego.setText("Quiere venderte el juego: ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelJuego, gridBagConstraints);

        labelVendName.setText("PlaceHolder");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelVendName, gridBagConstraints);

        labelJuegoName.setText("PlaceHolder");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelJuegoName, gridBagConstraints);

        botonPagar.setText("Proceder al pago");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(botonPagar, gridBagConstraints);

        botonCancelar.setText("Cancelar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(botonCancelar, gridBagConstraints);

        labelPrecio.setText("Al precio:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelPrecio, gridBagConstraints);

        labelPrecioCambiar.setText("PlaceHolder");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 15, 15, 15);
        mainPanel.add(labelPrecioCambiar, gridBagConstraints);

        getContentPane().add(mainPanel, new java.awt.GridBagConstraints());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PopUpVenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonPagar;
    private javax.swing.JLabel labelJuego;
    public javax.swing.JLabel labelJuegoName;
    private javax.swing.JLabel labelPrecio;
    public javax.swing.JLabel labelPrecioCambiar;
    public javax.swing.JLabel labelVendName;
    private javax.swing.JLabel labelVendedor;
    private javax.swing.JPanel mainPanel;
    // End of variables declaration//GEN-END:variables
}
