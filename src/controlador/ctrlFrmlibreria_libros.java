
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Libreria;
import vista.frmLibros;
import vista.frmLogin;


public class ctrlFrmlibreria_libros implements MouseListener{

       private frmLibros Vista;
       private Libreria Modelo;

       
                //2-Constructor 
    public ctrlFrmlibreria_libros(frmLibros vista, Libreria modelo){
        this.Modelo = modelo;
        this.Vista = vista;
        
        Vista.btnInformación.addMouseListener(this);
  
    }

    @Override
    public void mouseClicked(MouseEvent e) {
           if(e.getSource() == Vista.btnInformación){
               System.out.println("se dio clic");
            Modelo.setNombre(Vista.txtNombreR.getText());
            Modelo.setCorreo(Vista.txtCorreoR.getText());
            Modelo.setEdad(Integer.parseInt( Vista.txtEdadR.getText()));
            Modelo.setApellido(Vista.txtApellidoR.getText());


            Modelo.setContrasena(Modelo.convertirSHA256(Vista.txtContrasenaR.getText()));
   
            
            Modelo.GuardarUsuario();
               frmLogin.initLogin();
    
        }
        

       
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
 
    

