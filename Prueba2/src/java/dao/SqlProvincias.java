package dao;

import entities.Provincias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlProvincias implements DaoProvincias{

    @Override
    public void InsertarProvincias(Provincias provincias) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into provincias(nombre,departamento,fechac)"   //,userc,fecham,userm
                     + " values(?,?,now())" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, provincias.getNombrepro());
            pst.setInt(2, provincias.getDepartamento().getRegistrodep());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }
    
}
