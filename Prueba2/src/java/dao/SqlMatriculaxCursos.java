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
            String sql="insert into matriculaxcursos(matricula,curso,userc)" //no insertamos padre por que es el caso dematricula a un curso q no se ha llevado antes
                    + " values(?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, matriculaxCursos.getMatricula());
            pst.setInt(2, matriculaxCursos.getCurso());
            pst.setInt(4, matriculaxCursos.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<MatriculaxCursos> MostrarMatriculaxCursos() {
        List<MatriculaxCursos> listamxc=new ArrayList<MatriculaxCursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                MatriculaxCursos mxc=new MatriculaxCursos();
                
            }
            
        } catch (Exception e) {
        }
        return listamxc;
    }
    
}
