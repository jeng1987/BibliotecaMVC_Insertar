/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.LibroBO;
import Modelo.Modelo_libro;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.HIDE_ON_CLOSE;

/**
 *
 * @author JENG-PC
 * 
 */
public class Controlador_Libro implements ActionListener, KeyListener{

   public FrmInsertarLibro insertar_libro;
   
   public Principal principal;
   private Modelo_libro modelo_libro;
   LibroBO lbo = new LibroBO();
   String mensaje = "";

    public Controlador_Libro(Principal principal, Modelo_libro modelo_libro) {
        this.insertar_libro = new FrmInsertarLibro();     
        this.principal = principal;
        this.modelo_libro = modelo_libro;        
        this.principal.mnuInsertarLibro.addActionListener(this);
        this.principal.mnuConsultarLibro.addActionListener(this);
        this.insertar_libro.btnInsertar.addActionListener(this);           
        this.insertar_libro.btnLimpiar.addActionListener(this);
        this.insertar_libro.btnSalir.addActionListener(this);      
        this.insertar_libro.txtCodigoLibro.addKeyListener(this);
    }
    public void InicializarVistas(){
      principal.setSize(1024, 800);
      principal.setLocationRelativeTo(null);
      principal.setTitle("Bienvenido");  
     
      
      insertar_libro.setTitle("Formulario Insertar Libro");
      insertar_libro.setLocation(200, 100);
      
     
    } 
    public void limpiar(){
        insertar_libro.txtCodigoLibro.setText("");
        insertar_libro.txtNombreLibro.setText("");
        insertar_libro.txtEditorialLibro.setText("");
        insertar_libro.txtTituloLibro.setText("");    
    }   
    
    //inicio de la ejecucion de los eventos
    @Override
    public void actionPerformed(ActionEvent e) {
           if(e.getSource().equals(principal.mnuInsertarLibro)){
        try{                  
              this.principal.Panel_principal.add(insertar_libro);
                insertar_libro.setVisible(true);               
            }catch(IllegalArgumentException a){
              this.principal.Panel_principal.add(insertar_libro);
               insertar_libro.setVisible(true);
            }
        }else{
            if(e.getSource().equals(insertar_libro.btnInsertar)){                 
              try{
                modelo_libro.setCod_libro(Integer.parseInt(insertar_libro.txtCodigoLibro.getText()));
                modelo_libro.setNom_libro(insertar_libro.txtNombreLibro.getText());
                modelo_libro.setTit_libro(insertar_libro.txtTituloLibro.getText());
                modelo_libro.setEdit_libro(insertar_libro.txtEditorialLibro.getText());                

                mensaje = lbo.AdicionarLibro(modelo_libro);               
                JOptionPane.showMessageDialog(null,mensaje);
                limpiar();
                }catch(NumberFormatException a){
                     JOptionPane.showMessageDialog(null,"Tipo de dato Incorrecto O Codigo sin valor");
                } catch(StringIndexOutOfBoundsException b){
                    JOptionPane.showMessageDialog(null,"No puede ir vacio");
                }catch (SQLException ex) {
                   JOptionPane.showMessageDialog(null,"Problemas de conexión con la Base de datos");
                }     
                
            }else{
                if(e.getSource().equals(insertar_libro.btnLimpiar)){
                    limpiar();
                    }else{
                            if(e.getSource().equals(insertar_libro.btnSalir)){
                                this.insertar_libro.setDefaultCloseOperation(HIDE_ON_CLOSE);
                                this.insertar_libro.doDefaultCloseAction();
                            }
                        }
        
                }      
            }                    
            
    
    
    }//cierre del ActionPerformed
        
    
     
        
    
     @Override
    public void keyTyped(KeyEvent a) {
        if(a.getSource().equals(insertar_libro.txtCodigoLibro)){
             modelo_libro.validarNumero(a);
        }      
    }

    @Override
    public void keyPressed(KeyEvent a) {
    }

    @Override
    public void keyReleased(KeyEvent a) {
    }

   

   

   
}    
    

  
   
    
    
    
    
    

