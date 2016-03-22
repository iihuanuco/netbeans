package dao;

import entities.Departamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlDepartamentos implements DaoDepartamentos{

    @Override
    public void InsertarDepartamentos(Departamentos departamentos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into departamentos(nombre,fechac)"   //,userc,fecham,userm
                     + " values(?,now())" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, departamentos.getNombredep());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }
 
    
    
    
}
