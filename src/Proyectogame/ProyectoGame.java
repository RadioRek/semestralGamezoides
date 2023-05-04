package Proyectogame;

import Vistas.*;
import com.formdev.flatlaf.FlatDarculaLaf;
import javax.swing.UIManager;

public class ProyectoGame {

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(new FlatDarculaLaf());
        } catch (Exception e) {

        }

        new InicioSesion().setVisible(true);
    }
}
