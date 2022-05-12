/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author JENG-PC
 */
public class LibroDAO {
    
    private String mensaje;
    
    public String AdicionarLibro(Connection conn, Modelo_libro lib){
        PreparedStatement pst = null;
        String tabla = "libro";
        String sql = "insert into "+tabla+" (COD_LIBRO,TIT_LIBRO,NOM_LIBRO,EDIT_LIBRO)"
                +"values (?,?,?,?)";
        try{
            pst = conn.prepareStatement(sql);
            pst.setInt(1, lib.getCod_libro());
            pst.setString(2, lib.getTit_libro());
            pst.setString(3, lib.getNom_libro());
            pst.setString(4, lib.getEdit_libro());
            mensaje = "Registro exitoso";
            pst.execute();
                    pst.close();
        } catch (SQLException ex) {     
            mensaje = "error al insertar registro" + ex.getMessage();
        }
        
        return mensaje;       
    }
   
    
    
    
    
}
