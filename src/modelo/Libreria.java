
package modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Libreria {
    private String UUID_librería;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private int edad;

    public String getUUID_librería() {
        return UUID_librería;
    }

    public void setUUID_librería(String UUID_librería) {
        this.UUID_librería = UUID_librería;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
    
    

  
}
