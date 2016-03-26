package dao;

import entities.Notas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import util.Postgresql;

public class SqlNotas implements DaoNotas{

    @Override
    public void InsertarNotas(Notas notas) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into notas(matriculaxcurso,evalucionxcurso,nota,userc)"
                    + " values(?,?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, notas.getMatriculaxcurso());
            pst.setInt(2, notas.getEvaluacionxcurso());
            pst.setDouble(3, notas.getNotanot());
            pst.setInt(4, notas.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Notas> MostrarNotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
