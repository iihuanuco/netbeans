 
package dao;

import entities.EvaluaxCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

 
public class SqlEvaluaxCurso implements DaoEvaluaxCurso{

    @Override
    public void InsertarEvaluaxCurso(EvaluaxCurso evaluaxcurso) {
       Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into evalucionesxcursos(evaluacion,curso,actividad,peso,userc)"
                    + " values(?,?,?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, evaluaxcurso.getEvaluacion());
            pst.setInt(2, evaluaxcurso.getCurso());
            pst.setInt(3, evaluaxcurso.getActividad());
             pst.setDouble(4, evaluaxcurso.getPeso());
              pst.setInt(5, evaluaxcurso.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }
    
}
