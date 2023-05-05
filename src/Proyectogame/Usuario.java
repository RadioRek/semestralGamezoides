package Proyectogame;

import java.sql.Date;

public class Usuario {

    private String correo;
    private String nombre;
    private String apellido;
    private String sexo;
    private String password;
    private Date fecNac;
    private static Usuario miUsuario;

    private Usuario() {
    }
    
    public static synchronized Usuario getUsuario() {
        if (miUsuario == null) {
            miUsuario = new Usuario();
        }
        return miUsuario;
    }
    
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }
}
