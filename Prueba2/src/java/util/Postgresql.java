 
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Postgresql {
    
     static public Connection conexion(){
        Connection conn=null;
        String driver = "org.postgresql.Driver";
        String connectString = "jdbc:postgresql://localhost:5432/prueba01";
        String user = "milton";
        String password = "root";
             
        try {
             Class.forName(driver);
             conn = DriverManager.getConnection(connectString, user , password);
         } catch (ClassNotFoundException | SQLException ex) {
             util.creararchivotexto(ex.toString());
             Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
         }
    return conn;
    }
    
    static public void cerrar(Connection conn){
        try {
             conn.close();
         } catch (SQLException ex) {
             util.creararchivotexto(ex.toString());
             Logger.getLogger(Postgresql.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }
    
    
}
