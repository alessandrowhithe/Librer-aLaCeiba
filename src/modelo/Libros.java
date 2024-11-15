
package modelo;

import java.sql.*;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.frmDatos;



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
        
     public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
 
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        //borramos 
        try {
            PreparedStatement deleteEstudiante = conexion.prepareStatement("delete from tbLibros where UUID_Libros = ?");
            deleteEstudiante.setString(1, miId);
            deleteEstudiante.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
    }
     
       public void cargarDatosTabla(frmDatos frmDatos) {
        // Obtén la fila seleccionada 
        int filaSeleccionada =frmDatos.jtLibros.getSelectedRow();
 
        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = frmDatos.jtLibros.getValueAt(filaSeleccionada, 0).toString();
            String Nombre = frmDatos.jtLibros.getValueAt(filaSeleccionada, 1).toString();
            String Autor = frmDatos.jtLibros.getValueAt(filaSeleccionada, 2).toString();
            String Año = frmDatos.jtLibros.getValueAt(filaSeleccionada, 3).toString();
            String Estado = frmDatos.jtLibros.getValueAt(filaSeleccionada, 4).toString();
            String ISBN = frmDatos.jtLibros.getValueAt(filaSeleccionada, 5).toString();
            String Genero = frmDatos.jtLibros.getValueAt(filaSeleccionada, 6).toString();
            String paginas = frmDatos.jtLibros.getValueAt(filaSeleccionada, 7).toString();
             String Editorial = frmDatos.jtLibros.getValueAt(filaSeleccionada, 8).toString();
                       


            // Establece los valores en los campos de texto
            frmDatos.txtNombre.setText(Nombre);
            frmDatos.txtAutor.setText(Autor);
            frmDatos.txtAno.setText(Año);
            frmDatos.txtEstado.setText(Estado);
            frmDatos.txtISBN.setText(ISBN);
            frmDatos.txtGenero.setText(Genero);
            frmDatos.txtPaginas.setText(paginas);
            frmDatos.txtEditorial.setText(Editorial);

        }
    }
        
        
         public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update tbLibros set nombre_libro = ?, autor = ?, ano_publicacion = ?, estado = ?, ISBN = ?, genero = ?, paginas = ?, editorial = ?, where UUUID_libros = ?");
                updateUser.setString(1, getNombre_libro());
                updateUser.setString(2, getAutor());
                updateUser.setInt(3, getAno_publicacion());
                updateUser.setString(4, getEstado());
                updateUser.setInt(5, getISBN());
                updateUser.setString(6, getGenero());
                updateUser.setInt(7, getPaginas());
                updateUser.setString(8, getEditorial());
                updateUser.setString(10, miUUId);
                updateUser.executeUpdate();
 
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
    }  
        
        
    
}
