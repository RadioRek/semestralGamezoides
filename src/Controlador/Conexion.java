package Controlador;

import Proyectogame.Juego;
import Proyectogame.Usuario;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Conexion {

    public Connection con;
    public static Conexion miConexion;

    // CONSTRUCTOR PRIVADO SINGLETON
    private Conexion() {
    }

    // METODO GET PARA PATRON SINGLETON
    public static synchronized Conexion getConexion() {
        if (miConexion == null) {
            miConexion = new Conexion();
        }
        return miConexion;
    }

    // METODO PARA CONECTAR LISTO!
    public void conectar() {
        try {
            con = DriverManager.getConnection(
                    "jdbc:mysql://142.44.241.162:3306/gamezoides",
                    "gamezoides",
                    "gamezoides");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    // METODO PARA INICIAR SESION LISTO!
    public Boolean iniciarSesion(String correoUsuario, String contrasenaUsuario) {
        try {
            String declaracionSQL
                    = "SELECT correoUsuario "
                    + "FROM usuario "
                    + "WHERE correoUsuario = ? AND password = ?";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, correoUsuario);
            declaracion.setString(2, contrasenaUsuario);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                declaracion.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto", "No se ha podido ingresar", JOptionPane.PLAIN_MESSAGE);
                declaracion.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexion de la base de datos", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            return false;
        }
    }

    // METODO PARA AGREGAR USUARIO LISTO!
    public boolean agregarUsuario(Usuario us) {
        try {
            String insertSQL
                    = "INSERT INTO usuario "
                    + "(correoUsuario, nombre, apellido, password, fechaNacimiento, sexo) "
                    + "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setString(1, us.getCorreo());
            dec.setString(2, us.getNombre());
            dec.setString(3, us.getApellido());
            dec.setString(4, us.getPassword());
            dec.setDate(5, us.getFecNac());
            dec.setString(6, us.getSexo());
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego al usuario", "Exito", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
            return false;
        }
    }

    // METODO PARA AGREGAR JUEGO LISTO!
    public boolean agregarJuego(Juego ju) {
        try {
            String insertSQL
                    = "INSERT INTO juego "
                    + "(titulo, estudio, descripcion, rating, idioma, plataforma, precio, caratula, correoUsuario) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setString(1, ju.getTitulo());
            dec.setString(2, ju.getEstudio());
            dec.setString(3, ju.getDescripcion());
            dec.setString(4, ju.getRating());
            dec.setString(5, ju.getIdioma());
            dec.setString(6, ju.getPlataforma());
            dec.setInt(7, ju.getValor());
            dec.setBlob(8, ju.getCaratula());
            dec.setString(9, ju.getCorreoDueño());
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego el juego", "Exito", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
            return false;
        }
    }

    // METODO PARA LLENAR TABLA SIN FILTRO LISTO!
    public void llenarTabla(JTable tabla) {
        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, estudio, plataforma, idioma, precio, rating, codJuego "
                    + "FROM juego;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("estudio");
                String plataforma = resultado.getString("plataforma");
                String idioma = resultado.getString("idioma");
                String valor = String.valueOf(resultado.getInt("precio"));
                String rating = resultado.getString("rating");
                String idJuego = String.valueOf(resultado.getInt("codJuego"));
                String datostabla[] = {titulo, estudio, plataforma, idioma, valor, rating, idJuego};
                DefaultTableModel dtb = (DefaultTableModel) tabla.getModel();
                dtb.addRow(datostabla);
            }
            declaracion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    // METODO LLENAR TABLA CON FILTRO LISTO!
    public void llenarTablaFiltro(JTable tabla, String busqueda, String filtro) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, estudio, plataforma, idioma, precio, rating, codJuego "
                    + "FROM juego "
                    + "WHERE " + filtro + " = '" + busqueda + "';";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);

            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("estudio");
                String plataforma = resultado.getString("plataforma");
                String idioma = resultado.getString("idioma");
                String valor = String.valueOf(resultado.getInt("precio"));
                String rating = resultado.getString("rating");
                String idJuego = String.valueOf(resultado.getInt("codJuego"));
                String datostabla[] = {titulo, estudio, plataforma, idioma, valor, rating, idJuego};
                DefaultTableModel dtb = (DefaultTableModel) tabla.getModel();
                dtb.addRow(datostabla);
            }
            declaracion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    public void agregarFavorito(int idJuego, String usuario) {

        try {
            String insertSQL
                    = "INSERT INTO favorito "
                    + "(codJuego, correoUsuario) "
                    + "VALUES (?, ?)";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setInt(1, idJuego);
            dec.setString(2, usuario);
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego el juego como favorito", "Exito", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    public boolean revisarFavorito(int idJuego, String usuario) {

        try {
            String declaracionSQL
                    = "SELECT * "
                    + "FROM favorito "
                    + "WHERE codJuego = ? AND correoUsuario = ?";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setInt(1, idJuego);
            declaracion.setString(2, usuario);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                declaracion.close();
                return true;
            } else {
                declaracion.close();
                JOptionPane.showMessageDialog(null, "Ya tienes ese juego como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
                return false;

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
            return false;
        }
    }

    public void obtenerMasInfo(int codJuego, JLabel label, JTextArea tArea) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "caratula, descripcion "
                    + "FROM juego "
                    + "WHERE codJuego = '" + codJuego + "';";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);
            if (resultado.next()) {
                byte[] bytes = resultado.getBytes("caratula");
                ImageIcon img = new ImageIcon(bytes);
                Image imagenEscalada = img.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenEscalada));
                tArea.setText(resultado.getString("descripcion"));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener la informacion", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            declaracion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }
    
    public void llenarTablaFavoritos(JTable tabla, String Usuario) {

        try {
            String declaracionSQL
                    = "SELECT  "
                    + "videojuego.titulo, videojuego_usuarios.id_videojuego "
                    + "FROM videojuego_usuarios JOIN videojuego ON videojuego_usuarios.id_videojuego = videojuego.id_videojuego "
                    + "WHERE email = '" + Usuario + "'";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("videojuego.titulo");
                String codJuego = resultado.getString("videojuego_usuarios.id_videojuego");
                String datostabla[] = {titulo, codJuego};
                DefaultTableModel dtb = (DefaultTableModel) tabla.getModel();
                dtb.addRow(datostabla);
            }
            declaracion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    public void quitarFavorito(Integer codJuego, String Usuario) {

        try {
            String insertSQL
                    = "DELETE FROM videojuego_usuarios "
                    + "WHERE id_videojuego = '" + codJuego + "' AND email = '" + Usuario + "'";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se borro el favorito con exito", "Exito", JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

    

}
