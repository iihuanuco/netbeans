package dao;

import entities.Empresas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlEmpresas implements DaoEmpresas{

    @Override
    public void InsertarEmpresas(Empresas empresas) {
        
        Connection conn=null;
        
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into empresas(nombre,fechac,userc,ruc)"
                    + " values(?,now(),?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, empresas.getNombreemp());
            pst.setInt(2, empresas.getUserc());
            pst.setString(3, empresas.getRucemp());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    
}
