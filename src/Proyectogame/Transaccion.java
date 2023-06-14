package Proyectogame;

public class Transaccion {
    private float precio;
    private String usuario;
    private int codigo;
    private int idEstado;
    private String tipoTransaccion;

    private static Transaccion miTransaccion;

    private Transaccion() {
    }

    public static synchronized Transaccion getTransaccion() {
        if (miTransaccion == null) {
            miTransaccion = new Transaccion();
        }
        return miTransaccion;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String idTipo) {
        this.tipoTransaccion = idTipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}
