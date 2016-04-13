package dao;

import entities.MatriculaxCursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlMatriculaxCursos implements DaoMatriculaxCursos{

    @Override
    //InsertarMatricula es el modo normal de matricula a un curso que no se ha llevado anteriormente
    public void InsertarMatriculaxCursos(MatriculaxCursos matriculaxCursos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into matriculaxcursos(matricula,profesorxcurso,userc)" //no insertamos padre por que es el caso dematricula a un curso q no se ha llevado antes
                    + " values(?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, matriculaxCursos.getMatricula());
            pst.setInt(2, matriculaxCursos.getCurso());
            pst.setInt(3, matriculaxCursos.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<MatriculaxCursos> MostrarMatriculaxCursos(int reg) {
        List<MatriculaxCursos> listamxc=new ArrayList<MatriculaxCursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select mc.registro,pc.registro,c.nombre,p.nombre,c.creditos "
                    + "from users u "
                    + "inner join matricula m on m.alumno=u.registro "
                    + "inner join matriculaxcursos mc on mc.matricula=m.registro "
                    + "inner join profesorxcursos pc on pc.registro=mc.profesorxcurso "
                    + "inner join cursos c on c.registro=pc.curso "
                    + "inner join users p on p.registro=pc.profesor "
                    + "where m.registro=" + reg;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                MatriculaxCursos mxc=new MatriculaxCursos();
                mxc.setMatricula(rs.getInt(1));
                 mxc.setCurso(rs.getInt(2));
                 mxc.setCursos(rs.getString(3));
                 mxc.setProfesor(rs.getString(4));
                  mxc.setCreditos(rs.getInt(5));
         listamxc.add(mxc);
                
            }
            
        } catch (Exception e) {
        }
        return listamxc;
    }

    @Override
    public List<MatriculaxCursos> MostrarCursosAlumno(int reg) {
        List<MatriculaxCursos> listamxc=new ArrayList<MatriculaxCursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select mc.registro,pc.registro,c.nombre,p.nombre,c.creditos " +
            "                    from users u " +
            "                    inner join matricula m on m.alumno=u.registro " +
            "                    inner join matriculaxcursos mc on mc.matricula=m.registro " +
            "                    inner join profesorxcursos pc on pc.registro=mc.profesorxcurso " +
            "                    inner join cursos c on c.registro=pc.curso " +
            "                    inner join users p on p.registro=pc.profesor  " +
            "                    where u.registro="+reg;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                MatriculaxCursos mxc=new MatriculaxCursos();
                mxc.setMatricula(rs.getInt(1));
                 mxc.setCurso(rs.getInt(2));
                 mxc.setCursos(rs.getString(3));
                 mxc.setProfesor(rs.getString(4));
                  mxc.setCreditos(rs.getInt(5));
         listamxc.add(mxc);
                
            }
            
        } catch (Exception e) {
        }
        return listamxc;
    }
    
}
