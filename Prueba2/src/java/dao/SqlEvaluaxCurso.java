 
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
            String sql="insert into evalucionesxcursos(evaluacion,profesorxcurso,peso,userc)"
                    + " values(?,?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, evaluaxcurso.getEvaluacion());
            pst.setInt(2, evaluaxcurso.getProfesorxcurso());
             pst.setDouble(3, evaluaxcurso.getPeso());
              pst.setInt(4, evaluaxcurso.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }
    
}
