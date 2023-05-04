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
import javax.swing.table.DefaultTableModel;

public class Conexion {

    public Connection con;
    
    public static Conexion miConexion;

    private Conexion() {
    }

    public static synchronized Conexion getConexion() {
        if (miConexion == null) {
            miConexion = new Conexion();
        }
        return miConexion;
    }

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
            }else {
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

    public void agregarJuego(Juego ju) {

        try {
            String insertSQL
                    = "INSERT INTO videojuego "
                    + "(titulo, nombre_estudio, rating_esrb, idioma, plataforma, caratula, valor) " // genero =! sexo
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setString(1, ju.getTitulo());
            dec.setString(2, ju.getEstudio());
            dec.setString(3, ju.getRating());
            dec.setString(4, ju.getIdioma());
            dec.setString(5, ju.getPlataforma());
            dec.setBlob(6, ju.getCaratula());
            dec.setInt(7, ju.getValor());
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego el juego", "Exito", JOptionPane.PLAIN_MESSAGE);
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

    public void llenarTabla(JTable tabla) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, nombre_estudio, rating_esrb, idioma, plataforma, valor, id_videojuego "
                    + "FROM videojuego";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("nombre_estudio");
                String rating = resultado.getString("rating_esrb");
                String idioma = resultado.getString("idioma");
                String plataforma = resultado.getString("plataforma");
                String valor = String.valueOf(resultado.getInt("valor"));
                String idJuego = String.valueOf(resultado.getInt("id_videojuego"));
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

    public void llenarTablaTitulo(JTable tabla, String buscarTi) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, nombre_estudio, rating_esrb, idioma, plataforma, valor, id_videojuego "
                    + "FROM videojuego "
                    + "WHERE titulo = '" + buscarTi + "'";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);

            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("nombre_estudio");
                String rating = resultado.getString("rating_esrb");
                String idioma = resultado.getString("idioma");
                String plataforma = resultado.getString("plataforma");
                String valor = String.valueOf(resultado.getInt("valor"));
                String idJuego = String.valueOf(resultado.getInt("id_videojuego"));
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

    public void llenarTablaEstudio(JTable tabla, String buscarEs) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, nombre_estudio, rating_esrb, idioma, plataforma, valor, id_videojuego "
                    + "FROM videojuego "
                    + "WHERE titulo = '" + buscarEs + "'";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);

            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("nombre_estudio");
                String rating = resultado.getString("rating_esrb");
                String idioma = resultado.getString("idioma");
                String plataforma = resultado.getString("plataforma");
                String valor = String.valueOf(resultado.getInt("valor"));
                String idJuego = String.valueOf(resultado.getInt("id_videojuego"));
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

    public void llenarTablaPlataforma(JTable tabla, String buscarPl) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, nombre_estudio, rating_esrb, idioma, plataforma, valor, id_videojuego "
                    + "FROM videojuego "
                    + "WHERE titulo = '" + buscarPl + "'";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("nombre_estudio");
                String rating = resultado.getString("rating_esrb");
                String idioma = resultado.getString("idioma");
                String plataforma = resultado.getString("plataforma");
                String valor = String.valueOf(resultado.getInt("valor"));
                String idJuego = String.valueOf(resultado.getInt("id_videojuego"));
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

    public void llenarTablaRating(JTable tabla, String buscarRa) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, nombre_estudio, rating_esrb, idioma, plataforma, valor, id_videojuego "
                    + "FROM videojuego "
                    + "WHERE titulo = '" + buscarRa + "'";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);

            while (resultado.next()) {
                String titulo = resultado.getString("titulo");
                String estudio = resultado.getString("nombre_estudio");
                String rating = resultado.getString("rating_esrb");
                String idioma = resultado.getString("idioma");
                String plataforma = resultado.getString("plataforma");
                String valor = String.valueOf(resultado.getInt("valor"));
                String idJuego = String.valueOf(resultado.getInt("id_videojuego"));
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

    public Boolean revisarFavorito(Integer idJuego, String usuario) {

        try {
            String declaracionSQL
                    = "SELECT * "
                    + "FROM videojuego_usuarios "
                    + "WHERE id_videojuego = ? AND email = ?";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setInt(1, idJuego);
            declaracion.setString(2, usuario);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                declaracion.close();
                return false;
            } else {
                declaracion.close();
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
            return false;
        }
    }

    public void agregarFavorito(Integer idJuego, String usuario) {

        try {
            String insertSQL
                    = "INSERT INTO videojuego_usuarios "
                    + "(id_videojuego, email) "
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

    public void obtenerCaratula(Integer codJuego, JLabel label) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "caratula "
                    + "FROM videojuego "
                    + "WHERE id_videojuego = '" + codJuego + "'";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery(declaracionSQL);
            if (resultado.next()) {
                byte[] bytes = resultado.getBytes("caratula");
                ImageIcon img = new ImageIcon(bytes);
                Image imagenEscalada = img.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenEscalada));
            } else {
                JOptionPane.showMessageDialog(null, "El juego no tiene imagen", "Error", JOptionPane.PLAIN_MESSAGE);
            }
            declaracion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion", "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }

}
