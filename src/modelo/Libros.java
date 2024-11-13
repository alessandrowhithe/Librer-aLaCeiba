
package modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Libros {
    private String UUUID_libros;
    private String nombre_libro;
    private String autor;
    private int ano_publicacion;
    private String estado;
    private int ISBN;
    private String genero;
    private int paginas;
    private String editorial;

    public String getUUUID_libros() {
        return UUUID_libros;
    }

    public void setUUUID_libros(String UUUID_libros) {
        this.UUUID_libros = UUUID_libros;
    }

    public String getNombre_libro() {
        return nombre_libro;
    }

    public void setNombre_libro(String nombre_libro) {
        this.nombre_libro = nombre_libro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAno_publicacion() {
        return ano_publicacion;
    }

    public void setAno_publicacion(int ano_publicacion) {
        this.ano_publicacion = ano_publicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    
        public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addProducto = conexion.prepareStatement("INSERT INTO tbLibros(UUUID_libros, nombre_libro, autor, ano_publicacion, estado, ISBN, genero, paginas, editorial) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addProducto.setString(1, UUID.randomUUID().toString());
            addProducto.setString(2, getNombre_libro());
            addProducto.setString(3, getAutor());
            addProducto.setInt(4, getAno_publicacion());
            addProducto.setString(5, getEstado());
            addProducto.setInt(6, getISBN());
            addProducto.setString(7, getGenero());
            addProducto.setInt(8, getPaginas());
            addProducto.setString(9, getEditorial());
      
            //Ejecutar la consulta
            addProducto.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
        
        public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
 
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID_libros", "nombre_libro", "autor", "ano_publicacion", "estado", "ISBN", "genero", "paginas", "editorial"});
 
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
 
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM tbLibros");
 
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("UUUID_libros"),
                    rs.getString("nombre_libro"),
                    rs.getString("autor"),
                    rs.getString("estado"),
                    rs.getString("genero"),
                    rs.getString("editorial"),
                    rs.getInt("ISBN"),
                    rs.getInt("paginas"),              
                    rs.getInt("ano_publicacion")});                   
  
            }
 
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
            
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
    
}
