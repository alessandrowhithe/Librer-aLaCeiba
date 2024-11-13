
package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import modelo.Libreria;
import vista.frmDatos;
import vista.frmLogin;


public class ctrlFrmLibros_Librería implements MouseListener{
    private frmLogin Vista;
    private Libreria Modelo;
    
    //2- Constructor
    public ctrlFrmLibros_Librería (frmLogin vista, Libreria modelo){
        this.Vista = vista;
        this.Modelo = modelo;
        
        this.Vista.btnIniciar.addMouseListener(this);
        
        
    }
    
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if (e.getSource() == Vista.btnIniciar) {
            Modelo.setCorreo(Vista.txtCorreoL.getText());
            Modelo.setContrasena(Modelo.convertirSHA256(Vista.txtContrasenaL.getText()));

            //Creo una variable llamada "comprobar" 
            //que guardará el resultado de ejecutar el metodo iniciarSesion()            
            boolean comprobar = Modelo.iniciarSesion();

            //Si la variable es "true" significa que si existe el usuario ingresado    
            if (comprobar == true) {
                JOptionPane.showMessageDialog(Vista,"Usuario existe, ¡Bienvenido!");
                
                frmDatos.initCRUD();
            } else {
                JOptionPane.showMessageDialog(Vista, "Usuario no encontrado");

            }
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
