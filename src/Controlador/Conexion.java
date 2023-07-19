package Controlador;

import Proyectogame.Juego;
import Proyectogame.Transaccion;
import Proyectogame.Usuario;
import Vistas.PopUpVenta;
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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA INICIAR SESION LISTO!
    public boolean iniciarSesion(String correoUsuario, String contrasenaUsuario) {
        try {

            String declaracionSQL = "SELECT * "
                    + "FROM usuario "
                    + "WHERE correoUsuario = ? AND passwordUsuario = ?;";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, correoUsuario);
            declaracion.setString(2, contrasenaUsuario);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                declaracion.close();
                resultado.close();
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o usuario incorrecto", "No se ha podido ingresar",
                        JOptionPane.PLAIN_MESSAGE);
                declaracion.close();
                resultado.close();
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO PARA AGREGAR USUARIO LISTO!
    public boolean agregarUsuario(Usuario us) {
        try {
            String insertSQL = "INSERT INTO usuario "
                    + "(correoUsuario, nombreUsuario, apellidoUsuario, passwordUsuario, fechaNacUsuario, sexoUsuario) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

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
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO PARA AGREGAR JUEGO LISTO!
    public boolean agregarJuego(Juego ju) {
        try {
            String insertSQL = "INSERT INTO juego "
                    + "(tituloJuego, estudioJuego, descJuego, precioJuego, imgJuego) "
                    + "VALUES (?, ?, ?, ?, ?)";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setString(1, ju.getTitulo());
            dec.setString(2, ju.getEstudio());
            dec.setString(3, ju.getDescripcion());
            dec.setFloat(4, ju.getPrecio());
            dec.setBlob(5, ju.getCaratula());
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego el juego", "Exito", JOptionPane.PLAIN_MESSAGE);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
            return false;
        }
    }

    // METODO PARA LLENAR TABLA SIN FILTRO LISTO!
    public void llenarTabla(JTable tabla) {
        try {
            String declaracionSQL = "SELECT "
                    + "tituloJuego, estudioJuego, precioJuego, codJuego "
                    + "FROM juego;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            ResultSet resultado = declaracion.executeQuery();

            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultado);

            declaracion.close();
            resultado.close();

            String[] columnNames = {"Titulo", "Estudio", "Precio", "Codigo"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

            while (cachedRowSet.next()) {
                String titulo = cachedRowSet.getString("tituloJuego");
                String estudio = cachedRowSet.getString("estudioJuego");
                String valor = String.valueOf(cachedRowSet.getInt("precioJuego"));
                String codJuego = String.valueOf(cachedRowSet.getInt("codJuego"));

                String[] rowData = {titulo, estudio, valor, codJuego};
                dtm.addRow(rowData);
            }
            tabla.setModel(dtm);
            cachedRowSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO LLENAR TABLA CON FILTRO LISTO!
    public void llenarTablaFiltro(JTable tabla, String busqueda, String filtro) {
        try {
            String declaracionSQL = "SELECT "
                    + "tituloJuego, estudioJuego, precioJuego, codJuego "
                    + "FROM juego "
                    + "WHERE " + filtro + " = ?;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, busqueda);
            ResultSet resultado = declaracion.executeQuery();

            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultado);

            declaracion.close();
            resultado.close();

            String[] columnNames = {"Titulo", "Estudio", "Precio", "Codigo"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

            while (cachedRowSet.next()) {
                String titulo = cachedRowSet.getString("tituloJuego");
                String estudio = cachedRowSet.getString("estudioJuego");
                String valor = String.valueOf(cachedRowSet.getInt("precioJuego"));
                String codJuego = String.valueOf(cachedRowSet.getInt("codJuego"));

                String[] rowData = {titulo, estudio, valor, codJuego};
                dtm.addRow(rowData);
            }
            tabla.setModel(dtm);
            cachedRowSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO OBTENER MAS INFO LISTO!
    public void obtenerMasInfo(int codJuego, JLabel label, JTextArea tArea) {
        try {
            String declaracionSQL = "SELECT "
                    + "imgJuego, descJuego "
                    + "FROM juego "
                    + "WHERE codJuego = ?;";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setInt(1, codJuego);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                byte[] bytes = resultado.getBytes("imgJuego");
                ImageIcon img = new ImageIcon(bytes);
                Image imagenEscalada = img.getImage().getScaledInstance(350, 500, Image.SCALE_SMOOTH);
                label.setIcon(new ImageIcon(imagenEscalada));
                tArea.setText(resultado.getString("descJuego"));
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo obtener la informacion", "Error",
                        JOptionPane.PLAIN_MESSAGE);
            }
            declaracion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO COMPRAR JUEGO LISTO!
    public void comprarJuegoGamezoides(String usuario, int codJuego) {
        try {
            String declaracionSQL = "INSERT INTO juegoAdquirido "
                    + "(favorito, correoUsuario, codJuego) "
                    + "VALUES (?, ?, ?);";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, "No Favorito");
            declaracion.setString(2, usuario);
            declaracion.setInt(3, codJuego);
            declaracion.executeUpdate();
            declaracion.close();
            JOptionPane.showMessageDialog(null, "Se compro el juego exitosamente", "Exito", JOptionPane.PLAIN_MESSAGE);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }

        String tituloJuego;
        String codigoJuego;
        int precioJuego;
        
    

 
    }

    // METODO LLENAR TABLA FAVORITOS LISTO!
    public void llenarTablaMisJuegos(JTable tabla, String usuario) {
        try {
            String declaracionSQL = "SELECT jug.tituloJuego, adq.favorito, adq.codJuegoUsuario "
                    + "FROM juegoAdquirido adq JOIN juego jug ON(adq.codJuego = jug.codJuego) "
                    + "WHERE adq.correoUsuario = ?;";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, usuario);
            ResultSet resultado = declaracion.executeQuery();

            CachedRowSet cachedRowSet = RowSetProvider.newFactory().createCachedRowSet();
            cachedRowSet.populate(resultado);

            declaracion.close();
            resultado.close();

            String[] columnNames = {"Titulo", "Favorito", "Codigo"};
            DefaultTableModel dtm = new DefaultTableModel(columnNames, 0);

            while (cachedRowSet.next()) {
                String titulo = cachedRowSet.getString("tituloJuego");
                String favorito = cachedRowSet.getString("favorito");
                String codJuego = String.valueOf(cachedRowSet.getInt("codJuegoUsuario"));

                String[] rowData = {titulo, favorito, codJuego};
                dtm.addRow(rowData);
            }
            tabla.setModel(dtm);
            cachedRowSet.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO AGREGAR FAVORITO LISTO!
    public void agregarFavorito(int idJuego) {
        try {
            String insertSQL = "UPDATE juegoAdquirido "
                    + "SET favorito = 'Favorito' "
                    + "WHERE codJuegoUsuario = ?";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setInt(1, idJuego);
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se agrego el juego como favorito", "Exito", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA BORRAR FAVORITO LISTO!
    public void quitarFavorito(int idJuego) {
        try {
            String insertSQL = "UPDATE juegoAdquirido "
                    + "SET favorito = 'No favorito' "
                    + "WHERE codJuegoUsuario = ?";
            PreparedStatement dec = con.prepareStatement(insertSQL);
            dec.setInt(1, idJuego);
            dec.executeUpdate();
            dec.close();
            JOptionPane.showMessageDialog(null, "Se quito el juego como favorito", "Exito", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    // METODO PARA VENDER JUEGO
    public void ingresarVenta(Transaccion trans) {
        try {
            String declaracionSQL = "INSERT INTO transaccion "
                    + "(precioTransaccion, fechaTransaccion, usuarioTransaccion, codJuegoUsuario, estadoTransaccion, tipoTransaccion) "
                    + "VALUES (?, ?, ?, ?, ?, ?);";

            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setFloat(1, trans.getPrecio());
            try {
                String declaracionDate = "SELECT SYSDATE FROM dual;";
                PreparedStatement prepDeclaracionDate = con.prepareStatement(declaracionDate);
                ResultSet resultado = prepDeclaracionDate.executeQuery();
                if (resultado.next()) {
                    Date fechaTrans = resultado.getDate("SYSDATE");
                    declaracion.setDate(2, fechaTrans);
                }
                prepDeclaracionDate.close();
                resultado.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                        JOptionPane.PLAIN_MESSAGE);
            }
            declaracion.setString(3, trans.getUsuario());
            declaracion.setInt(4, trans.getCodigo());
            declaracion.setInt(5, trans.getIdEstado());
            declaracion.setString(6, trans.getTipoTransaccion());
            declaracion.executeUpdate();
            declaracion.close();
            JOptionPane.showMessageDialog(null, "Se envio la solicitud exitosamente", "Exito", JOptionPane.PLAIN_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }

    public void revisarTransaccion(String usuario) {
        try {
            String declaracionSQL = "SELECT * "
                    + "FROM transaccion "
                    + "WHERE correoUsuario = ?";
            PreparedStatement declaracion = con.prepareStatement(declaracionSQL);
            declaracion.setString(1, usuario);
            ResultSet resultado = declaracion.executeQuery();
            if (resultado.next()) {
                while (resultado.next()) {
                    String precio = String.valueOf(resultado.getInt("precioCompra"));
                    String vendedor = resultado.getString("correoUsuario");
                    String nombreJuego = "";
                    int idJuego = resultado.getInt("codJuegoUsuario");
                    try {
                        String decCodigoJuego = "SELECT codJuego FROM juegoAdquirido WHERE codJuegoUsuario = ?";
                        PreparedStatement prepdecCodigoJuego = con.prepareStatement(decCodigoJuego);
                        prepdecCodigoJuego.setInt(1, idJuego);
                        ResultSet resCodJuego = prepdecCodigoJuego.executeQuery();
                        if (resCodJuego.next()) {
                            int codJuegoOr = resCodJuego.getInt("codJuego");
                            String decNombreJuego = "SELECT tituloJuego FROM juego WHERE codJuego = ?";
                            PreparedStatement prepDecNombreJuego = con.prepareStatement(decNombreJuego);
                            prepDecNombreJuego.setInt(1, codJuegoOr);
                            ResultSet resNomJuego = prepDecNombreJuego.executeQuery();
                            if (resNomJuego.next()) {
                                nombreJuego = resNomJuego.getString("tituloJuego");
                            }
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                                JOptionPane.PLAIN_MESSAGE);
                    }
                    PopUpVenta pop = new PopUpVenta();
                    pop.labelJuegoName.setText(nombreJuego);
                    pop.labelPrecioCambiar.setText(precio);
                    pop.labelVendName.setText(vendedor);
                    pop.setVisible(true);
                    pop.pack();
                }
                declaracion.close();
                resultado.close();
            } else {
                declaracion.close();
                resultado.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en conexion" + ex.getMessage(), "Error",
                    JOptionPane.PLAIN_MESSAGE);
        }
    }
}
