/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


import java.awt.event.KeyEvent;


/**
 *
 * @author JENG-PC
 */
public class Modelo_libro{
    
    private int cod_libro;
    private String Tit_libro;
    private String Nom_libro;
    private String Edit_libro;

    public Modelo_libro(int cod_libro, String Tit_libro, String Nom_libro, String Edit_libro) {
        this.cod_libro = cod_libro;
        this.Tit_libro = Tit_libro;
        this.Nom_libro = Nom_libro;
        this.Edit_libro = Edit_libro;
    } 
    
     public Modelo_libro() {      
     }  
    

    public int getCod_libro() {
        return cod_libro;
    }

    public String getTit_libro() {
        return Tit_libro;
    }

    public String getNom_libro() {
        return Nom_libro;
    }

    public String getEdit_libro() {
        return Edit_libro;
    }

    public void setCod_libro(int cod_libro) {
        this.cod_libro = cod_libro;
    }

    public void setTit_libro(String Tit_libro) {
        this.Tit_libro = Tit_libro;
    }

    public void setNom_libro(String Nom_libro) {
        this.Nom_libro = Nom_libro;
    }

    public void setEdit_libro(String Edit_libro) {
        this.Edit_libro = Edit_libro;
    }   
    
    public void validarNumero(KeyEvent a){      
         char c = a.getKeyChar();
         if(c<'0' || c>'9'){
           a.consume();
         }        
    }
    public void validarCaracteres(KeyEvent a){
       char c = a.getKeyChar();
         if((c<'a' || c>'z') && (c<'A' || c>'Z')){
           a.consume();
         } 
    
    }  

   
   
    
}
