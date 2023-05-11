package Controlador;

import Proyectogame.Juego;
import Proyectogame.Usuario;
import com.mysql.cj.jdbc.Blob;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexion de la base de datos" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA INICIAR SESION LISTO!
    public boolean iniciarSesion(String correoUsuario, String contrasenaUsuario) {
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
                resultado.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto", "No se ha podido ingresar", JOptionPane.PLAIN_MESSAGE);
                declaracion.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la conexion de la base de datos" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO PARA LLENAR TABLA SIN FILTRO LISTO!
    public void llenarTabla(JTable tabla) {
        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, estudio, plataforma, idioma, precio, rating, codJuego, correoUsuario "
                    + "FROM juego;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery();

            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultado);

            declaracion.close();
            resultado.close();

            String[] columnNames = {"Titulo", "Estudio", "Plataforma", "Idioma", "Valor", "Rating", "Codigo"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

            while (cachedRowSet.next()) {
                String dueno = cachedRowSet.getString("correoUsuario");
                if (dueno.equals("gamezoides")) {
                    String titulo = cachedRowSet.getString("titulo");
                    String estudio = cachedRowSet.getString("estudio");
                    String plataforma = cachedRowSet.getString("plataforma");
                    String idioma = cachedRowSet.getString("idioma");
                    String valor = String.valueOf(cachedRowSet.getInt("precio"));
                    String rating = cachedRowSet.getString("rating");
                    String idJuego = String.valueOf(cachedRowSet.getInt("codJuego"));
                    String[] rowData = {titulo, estudio, plataforma, idioma, valor, rating, idJuego};
                    dtm.addRow(rowData);
                }
            }
            tabla.setModel(dtm);
            cachedRowSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO LLENAR TABLA CON FILTRO LISTO!
    public void llenarTablaFiltro(JTable tabla, String busqueda, String filtro) {

        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, estudio, plataforma, idioma, precio, rating, codJuego, correoUsuario "
                    + "FROM juego "
                    + "WHERE " + filtro + " = ?;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, busqueda);
            ResultSet resultado = declaracion.executeQuery();

            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultado);

            declaracion.close();
            resultado.close();

            String[] columnNames = {"Titulo", "Estudio", "Plataforma", "Idioma", "Valor", "Rating", "Codigo"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

            while (cachedRowSet.next()) {
                String dueno = cachedRowSet.getString("correoUsuario");
                if (!dueno.equals("gamezoides")) {
                    String titulo = cachedRowSet.getString("titulo");
                    String estudio = cachedRowSet.getString("estudio");
                    String plataforma = cachedRowSet.getString("plataforma");
                    String idioma = cachedRowSet.getString("idioma");
                    String valor = String.valueOf(cachedRowSet.getInt("precio"));
                    String rating = cachedRowSet.getString("rating");
                    String idJuego = String.valueOf(cachedRowSet.getInt("codJuego"));
                    String[] rowData = {titulo, estudio, plataforma, idioma, valor, rating, idJuego};
                    dtm.addRow(rowData);
                }
            }
            tabla.setModel(dtm);
            cachedRowSet.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            System.out.println(e);
            e.printStackTrace();
        }
    }

    // METODO AGREGAR FAVORITO LISTO!
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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO VERIFICACION FAVORITO LISTO!
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
                JOptionPane.showMessageDialog(null, "Ya tienes ese juego como favorito", "Error", JOptionPane.PLAIN_MESSAGE);
                return true;
            } else {
                declaracion.close();
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO OBTENER MAS INFO LISTO!
    public void obtenerMasInfo(int codJuego, JLabel label, JTextArea tArea) {

        String declaracionSQL
                = "SELECT "
                + "caratula, descripcion "
                + "FROM juego "
                + "WHERE codJuego = ?;";
        try {
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setInt(1, codJuego);
            ResultSet resultado = declaracion.executeQuery();
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
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion: " + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO LLENAR TABLA FAVORITOS LISTO!
    public void llenarTablaFavoritos(JTable tabla, String usuario) {
        try {
            String[] columnNames = {"Titulo", "Codigo", "Favorito", "Adquirido"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);
            String decSql
                    = "SELECT "
                    + "titulo "
                    + "FROM juego "
                    + "WHERE correoUsuario = ?";
            PreparedStatement prepDecSql = con.prepareStatement(decSql);
            prepDecSql.setString(1, usuario);
            ResultSet decRes = prepDecSql.executeQuery();
            while (decRes.next()) {
                String titAdq = decRes.getString("titulo");
                String compSql
                        = "SELECT "
                        + "jug.titulo, fav.codJuego "
                        + "FROM favorito fav JOIN juego jug ON(jug.codJuego = fav.codJuego) "
                        + "WHERE fav.correoUsuario = ? AND jug.titulo = '" + titAdq + "';";
                PreparedStatement prepComSql = con.prepareStatement(compSql);
                prepComSql.setString(1, usuario);
                ResultSet decComRes = prepComSql.executeQuery();
                while (decComRes.next()) {
                    String titFavAd = decComRes.getString("jug.titulo");
                    int codFavAd = decComRes.getInt("fav.codJuego");
                    String[] rowData = {titFavAd, String.valueOf(codFavAd), "Si", "Si"};
                    dtm.addRow(rowData);
                }
            }
            String onlyFavs
                    = "SELECT "
                    + "jug.titulo, fav.codJuego "
                    + "FROM favorito fav JOIN juego jug ON(jug.codJuego = fav.codJuego) "
                    + "WHERE fav.correoUsuario = ?;";
            PreparedStatement prepOnlyFavSql = con.prepareStatement(onlyFavs);
            prepOnlyFavSql.setString(1, usuario);
            ResultSet onlyFavRes = prepOnlyFavSql.executeQuery();
            while (onlyFavRes.next()) {
                String titFavAd = onlyFavRes.getString("jug.titulo");
                int codFavAd = onlyFavRes.getInt("fav.codJuego");
                String compJugSql
                        = "SELECT "
                        + "correoUsuario "
                        + "FROM juego "
                        + "WHERE titulo = '" + titFavAd + "' AND correoUsuario = '" + usuario + "';";
                PreparedStatement comSQl = con.prepareStatement(compJugSql);
                ResultSet resWat = comSQl.executeQuery();
                if (!resWat.next()) {
                    String[] rowData = {titFavAd, String.valueOf(codFavAd), "Si", "No"};
                    dtm.addRow(rowData);
                }
            }
            String onlyAdq
                    = "SELECT "
                    + "titulo "
                    + "FROM juego "
                    + "WHERE correoUsuario = ?;";
            PreparedStatement prepOnlyAdq = con.prepareStatement(onlyAdq);
            prepOnlyAdq.setString(1, usuario);
            ResultSet onlyAdqRes = prepOnlyAdq.executeQuery();
            while (onlyAdqRes.next()) {
                String titJugAdq = onlyAdqRes.getString("titulo");
                int codJug = 0;
                PreparedStatement getCod = con.prepareStatement("SELECT codJuego FROM juego WHERE titulo = '" + titJugAdq + "' AND correoUsuario = 'gamezoides';");
                ResultSet codJugRes = getCod.executeQuery();
                if (codJugRes.next()) {
                    codJug = codJugRes.getInt("codJuego");
                }
                String compFavSql
                        = "SELECT "
                        + "correoUsuario "
                        + "FROM favorito "
                        + "WHERE codJuego = '" + codJug + "' AND correoUsuario = '" + usuario + "';";
                PreparedStatement comFavSql = con.prepareStatement(compFavSql);
                ResultSet resComFavSql = comFavSql.executeQuery();
                if (!resComFavSql.next()) {

                    String[] rowData = {titJugAdq, String.valueOf(codJug), "No", "Si"};
                    dtm.addRow(rowData);
                }
            }
            tabla.setModel(dtm);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA BORRAR FAVORITO LISTO!
    public boolean quitarFavorito(int codJuego, String usuario) {
        String deleteSQL
                = "DELETE FROM favorito "
                + "WHERE codJuego = ? AND correoUsuario = ?;";
        try {
            PreparedStatement dec = con.prepareStatement(deleteSQL);
            dec.setInt(1, codJuego);
            dec.setString(2, usuario);
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se borro el favorito con exito", "Exito", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO COMPRAR JUEGO LISTO!
    public void comprarJuegoGamezoides(String usuario, int codJuego) {
        try {
            String declaracionSQL
                    = "SELECT "
                    + "titulo, estudio, descripcion, rating, idioma, plataforma, precio, caratula "
                    + "FROM juego "
                    + "WHERE codJuego = ?;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setInt(1, codJuego);
            ResultSet resultado = declaracion.executeQuery();

            if (resultado.next()) {
                String tit = resultado.getString("titulo");
                String est = resultado.getString("estudio");
                String des = resultado.getString("descripcion");
                String rat = resultado.getString("rating");
                String idi = resultado.getString("idioma");
                String plat = resultado.getString("plataforma");
                int val = resultado.getInt("precio");
                Blob img = (Blob) resultado.getBlob("caratula");

                PreparedStatement validation = con.prepareStatement("SELECT * FROM juego WHERE titulo = '" + tit + "' AND correoUsuario = '" + usuario + "';");
                ResultSet valRes = validation.executeQuery();

                if (!valRes.next()) {

                    try {
                        String insertSQL
                                = "INSERT INTO juego "
                                + "(titulo, estudio, descripcion, rating, idioma, plataforma, precio, caratula, correoUsuario) "
                                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

                        PreparedStatement insertDec = con.prepareStatement(insertSQL);
                        insertDec.setString(1, tit);
                        insertDec.setString(2, est);
                        insertDec.setString(3, des);
                        insertDec.setString(4, rat);
                        insertDec.setString(5, idi);
                        insertDec.setString(6, plat);
                        insertDec.setInt(7, val);
                        insertDec.setBlob(8, img);
                        insertDec.setString(9, usuario);
                        insertDec.executeUpdate();
                        insertDec.close();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                    try {
                        String insertTra
                                = "INSERT INTO transaccion "
                                + "(precio, fecha, vendedor, comprador, codJuego, idEstado) "
                                + "VALUES(?, ?, ?, ?, ?, ?)";

                        PreparedStatement insertTraDec = con.prepareStatement(insertTra);
                        insertTraDec.setInt(1, val);
                        try {
                            PreparedStatement getDate = con.prepareStatement("SELECT SYSDATE()");
                            ResultSet dbDate = getDate.executeQuery();
                            if (dbDate.next()) {
                                Date now = dbDate.getDate(1);
                                insertTraDec.setDate(2, now);
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
                        }
                        insertTraDec.setString(3, "gamezoides");
                        insertTraDec.setString(4, usuario);
                        insertTraDec.setInt(5, codJuego);
                        insertTraDec.setInt(6, 1);
                        insertTraDec.executeUpdate();
                        insertTraDec.close();
                        JOptionPane.showMessageDialog(null, "Compra realizada con exito", "Exito", JOptionPane.PLAIN_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Ya tienes ese juego", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA VENDER JUEGO
    public void venderJuego(String vendedor, String comprador, int codJuego, int precio) {

        try {

            String duenoCodSql
                    = "SELECT "
                    + "titulo "
                    + "FROM juego "
                    + "WHERE codJuego = ?;";
            PreparedStatement prepDuenoCodSql = con.prepareStatement(duenoCodSql);
            prepDuenoCodSql.setInt(1, codJuego);
            ResultSet duenoCodSqlRes = prepDuenoCodSql.executeQuery();
            if (duenoCodSqlRes.next()) {
                String titulo = duenoCodSqlRes.getString("titulo");
                PreparedStatement getCodeSql = con.prepareStatement("SELECT codJuego FROM juego WHERE correoUsuario ='" + vendedor + "' AND titulo = '" + titulo + "';");
                ResultSet codigoJuego = getCodeSql.executeQuery();
                if (codigoJuego.next()) {
                    String insertSql
                            = "INSERT INTO transaccion "
                            + "(precio, fecha, vendedor, comprador, codJuego, idEstado) "
                            + "VALUES(?, ?, ?, ?, ?, ?)";
                    PreparedStatement prepInsert = con.prepareStatement(insertSql);
                    prepInsert.setInt(1, precio);
                    try {
                        PreparedStatement getDate = con.prepareStatement("SELECT SYSDATE()");
                        ResultSet dbDate = getDate.executeQuery();
                        if (dbDate.next()) {
                            Date now = dbDate.getDate(1);
                            prepInsert.setDate(2, now);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + e.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                    prepInsert.setString(3, vendedor);
                    prepInsert.setString(4, comprador);
                    prepInsert.setInt(5, codigoJuego.getInt("codJuego"));
                    prepInsert.setInt(6, 2);
                    prepInsert.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Se ha enviado la venta, espera confirmacion", "Exito", JOptionPane.PLAIN_MESSAGE);
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE);
        }

    }

}
