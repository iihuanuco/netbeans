package dao;

import entities.Distritos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlDistritos implements DaoDistritos{

    @Override
    public void InsertarDistritos(Distritos distritos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into distritos(nombre,capital,provincia,fechac)"   //,userc,fecham,userm
                     + " values(?,?,?,now())" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, distritos.getNombredis());
            pst.setString(2, distritos.getCapitaldis());
            pst.setInt(3, distritos.getProvincia().getRegistropro());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }
    
}
