package Proyectogame;

import java.io.FileInputStream;

public class Juego {

    private String titulo;
    private String estudio;
    private String descripcion;
    private Integer precio;
    private FileInputStream caratula;

    private static Juego miJuego;

    private Juego() {
    }

    public static synchronized Juego getJuego() {
        if (miJuego == null) {
            miJuego = new Juego();
        }
        return miJuego;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public FileInputStream getCaratula() {
        return caratula;
    }

    public void setCaratula(FileInputStream caratula) {
        this.caratula = caratula;
    }
}
