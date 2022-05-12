/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author JENG-PC
 */
public class LibroBO {
    private String mensaje = "";
    private LibroDAO ldao = new LibroDAO();
    
    public String AdicionarLibro(Modelo_libro lib) throws SQLException{
         Connection conn = Conexion.getConnection();
         try{
             mensaje = ldao.AdicionarLibro(conn, lib);
             conn.commit();
         }catch(SQLException e){
             mensaje = mensaje + " " + e.getMessage();
             conn.rollback();
         }finally{
             try{
                 if(conn!=null){
                     conn.close();
                 }
             }catch(SQLException e){
                mensaje = mensaje + " " + e.getMessage();
             }
         }     
    
     return mensaje;
    }  
    
}
