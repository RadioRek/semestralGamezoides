package Proyectogame;

import Vistas.InicioSesion;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;

public class ProyectoGame {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        new InicioSesion().setVisible(true);

    }
}
