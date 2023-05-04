package Proyectogame;

import java.io.FileInputStream;


public class Juego {

    private String titulo;
    private String estudio;
    private String descripcion;
    private String rating;
    private String idioma;
    private String plataforma;
    private Integer valor;
    private FileInputStream caratula;
    private String correoDueño;
    
    private static Juego miJuego;
    
    private Juego() {
    }
    
    public static synchronized Juego getJuego() {
        if (miJuego == null) {
            miJuego = new Juego();
        }
        return miJuego;
    }
    
    public static Juego getMiJuego() {
        return miJuego;
    }

    public static void setMiJuego(Juego aMiJuego) {
        miJuego = aMiJuego;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public FileInputStream getCaratula() {
        return caratula;
    }

    public void setCaratula(FileInputStream caratula) {
        this.caratula = caratula;
    }

    public String getCorreoDueño() {
        return correoDueño;
    }

    public void setCorreoDueño(String correoDueño) {
        this.correoDueño = correoDueño;
    }
}
