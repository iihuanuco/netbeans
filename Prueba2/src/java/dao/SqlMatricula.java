package dao;

import entities.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import util.Postgresql;

public class SqlMatricula implements DaoMatricula{

    @Override
    public void InsertarMatricula(Matricula matricula) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into matricula(alumno,codigomatricula,actividad,carrera,turno,seccion,fechac,userc)"
                + " values(?,?,?,?,?,?,now(),?)";
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, matricula.getAlumno());
            pst.setString(2, matricula.getCodigomat());
            pst.setInt(3, matricula.getActividad());
            pst.setInt(4, matricula.getCarrera());
            pst.setInt(5, matricula.getTurno());
            pst.setInt(6, matricula.getSeccion());
            pst.setInt(7, matricula.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<Matricula> MostrarMatricula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
