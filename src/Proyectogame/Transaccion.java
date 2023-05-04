package Proyectogame;

import java.sql.Date;

public class Transaccion {
    
    private int precio;
    private Date fecha;
    private String vendedor;
    private String comprador;
    private String estado;
    private int codJuego;
    private int idEstado;
    private static Transaccion miTransaccion;

    private Transaccion() {
    }
    
    public static synchronized Transaccion getTransaccion() {
        if (miTransaccion == null) {
            miTransaccion = new Transaccion();
        }
        return miTransaccion;
    }
    
    

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public static Transaccion getMiTransaccion() {
        return miTransaccion;
    }

    public static void setMiTransaccion(Transaccion miTransaccion) {
        Transaccion.miTransaccion = miTransaccion;
    }
    
    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getComprador() {
        return comprador;
    }

    public void setComprador(String comprador) {
        this.comprador = comprador;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCodJuego() {
        return codJuego;
    }

    public void setCodJuego(int codJuego) {
        this.codJuego = codJuego;
    }
}
