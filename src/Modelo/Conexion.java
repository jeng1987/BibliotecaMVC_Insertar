/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author JENG-PC
 */
public class Conexion {
   private static Connection conn = null;
//   se define las variables como static ya que la caracteristica principal de este es que debe pertenecer a la clase
//   y ademas de esto se inicializa una unica vez desde el inicio de la clase, por otra parte se puede acceder a esta 
//   solo con el nombre sin necesidad de crear un objeto
   private static String login = "objetos2"; //Nombre de usuario de la base de datos
   private static String clave = "objetos2";
   private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    
   //Metodo de Apertura de la conexion
   public static Connection getConnection() throws SQLException{
       try {
           Class.forName("oracle.jdbc.driver.OracleDriver");//Llamado al driver de la conexion
           conn = DriverManager.getConnection(url, login, clave);
           conn.setAutoCommit(false);
           if(conn != null){
               System.out.print("Conexion OK");
           }else{
               System.err.print("No se ha ralizado la conexion");           
           }          
       } catch (ClassNotFoundException|SQLException e) {
           JOptionPane.showMessageDialog(null, "Conexion Erronea");
       }      
       return conn;
   }
   
   //Metodo de cierre de la conexion
   public void CloseConection(){
       try {
           conn.close();
       } catch (SQLException e) {
           System.out.println("Error en el cierre de la conexion" + e.getMessage());
       }
   
   }
    
}
