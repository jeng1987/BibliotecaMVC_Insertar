/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;
import Vista.*;
import Controlador.Controlador_Libro;
import Modelo.Modelo_libro;

/**
 *
 * @author JENG-PC
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Principal nuevoPrincipal = new Principal();
       //FrmInsertarLibro nuevoFrmInsertarLibro = new FrmInsertarLibro();
       //FrmConsultarLibro nuevoFrmConsultarLibro = new FrmConsultarLibro();
       Modelo_libro nuevoModeloLibro = new Modelo_libro();
       Controlador_Libro nuevoControladorLibro = new Controlador_Libro(nuevoPrincipal,nuevoModeloLibro);
       nuevoControladorLibro.InicializarVistas();
       nuevoPrincipal.setVisible(true);
    }
    
}
