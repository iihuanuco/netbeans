package dao;

import entities.Carreras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import util.Postgresql;

public class SqlCarreras implements DaoCarreras{

    @Override
    public void InsertarCarreras(Carreras carreras) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into carreras(codigo,nombre,semestres,sucursal,fechac,userc)"
                    + " values(?,?,?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            pst.setString(1, carreras.getCodigocarrera());
            pst.setString(2, carreras.getNombrecarrera());
            pst.setInt(3, carreras.getSemestrescarrera());
            pst.setInt(4, carreras.getSucursal());
            pst.setInt(5, carreras.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Carreras> MostrarCarreras() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
