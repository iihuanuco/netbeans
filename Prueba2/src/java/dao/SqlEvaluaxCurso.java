 
package dao;


import entities.EvaluaxCurso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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

    @Override
    public void ActualizarCurso(EvaluaxCurso evaluaxcurso) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="update evalucionesxcursos set evaluacion=?,profesorxcurso=?,peso=?,fecham=now(),userm=? where registro=?";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, evaluaxcurso.getEvaluacion());
            pst.setInt(2, evaluaxcurso.getProfesorxcurso());
            pst.setDouble(3, evaluaxcurso.getPeso());
            pst.setInt(4, evaluaxcurso.getUserm()); 
            pst.setInt(5, evaluaxcurso.getRegistro());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    @Override
    public List<EvaluaxCurso> MostrarExC(int suc) {
         List<EvaluaxCurso> listaexc=new ArrayList<EvaluaxCurso>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = " select ec.registro,ec.evaluacion,e.nombre,ec.peso,pc.registro,concat(us.nombre,' - ',cu.nombre) "
                    + "from profesorxcursos pc "
                    + "inner join evalucionesxcursos ec on ec.profesorxcurso=pc.registro "
                    + "inner join users us  on us.registro=pc.profesor "
                    + "inner join cursos cu on cu.registro=pc.curso "
                    + "inner join evaluaciones e on e.registro=ec.evaluacion "
                    + "inner join carreras ca on ca.registro=cu.carrera  "
                    + "where ca.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                EvaluaxCurso a=new EvaluaxCurso();
                a.setRegistro(rs.getInt(1));
                a.setEvaluacion(rs.getInt(2));
                a.setNevaluacion(rs.getString(3));
                a.setPeso(rs.getDouble(4));
                a.setProfesorxcurso(rs.getInt(5));
                a.setNprofesorxcurso(rs.getString(6));
                
                listaexc.add(a);
            }
            
        } catch (Exception e) {
        }
        
        return listaexc;
                
       
    }

  
    
}
