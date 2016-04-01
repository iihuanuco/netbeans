package dao;

import entities.Cursos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;
import util.util;

public class SqlCursos implements DaoCursos{

    @Override
    public void InsertarCursos(Cursos cursos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into cursos(codigo,nombre,carrera,semestre,creditos,ht,hp,alcance,fechainicio,fechac,userc)"
                    + " values(?,?,?,?,?,?,?,?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, cursos.getCodigocurso());
            pst.setString(2, cursos.getNombrecurso());
            pst.setInt(3, cursos.getCarrera());
            pst.setInt(4, cursos.getSemestrecurso());
            pst.setInt(5, cursos.getCreditoscurso());
            pst.setInt(6, cursos.getHtcurso());
            pst.setInt(7, cursos.getHpcurso());
            pst.setInt(8, cursos.getAlcancecurso());
            pst.setDate(9, util.dateutil2sql(cursos.getFechainiciocurso()));
            pst.setInt(10, cursos.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<Cursos> MostrarCursos(int suc) {
          List<Cursos> listacur=new ArrayList<Cursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select c.registro,c.codigo,c.nombre,c.carrera,ca.nombre,c.semestre,c.ht,c.hp,c.creditos " +
"                    from cursos c " +
"                    inner join carreras ca " +
"                    on ca.registro=c.carrera " +
"                    where ca.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Cursos d=new Cursos();
                d.setRegistrocurso(rs.getInt(1));
                d.setCodigocurso(rs.getString(2));
                d.setNombrecurso(rs.getString(3));
                d.setCarrera(rs.getInt(4));
                d.setNcarrerra(rs.getString(5));
                d.setSemestrecurso(rs.getInt(6));
                d.setHtcurso(rs.getInt(7));
                d.setHpcurso(rs.getInt(8));
                d.setCreditoscurso(rs.getInt(9));
                
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    }

    @Override
    public void ActualizarCursos(Cursos cursos) {
 Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="update cursos set codigo=?,nombre=?,carrera=?,semestre=?,creditos=?,ht=?,hp=?,userm=?,fecham=now() where registro=? ";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, cursos.getCodigocurso());
            pst.setString(2, cursos.getNombrecurso());
            pst.setInt(3, cursos.getCarrera());
            pst.setInt(4, cursos.getSemestrecurso());
            pst.setInt(5, cursos.getCreditoscurso());
            pst.setInt(6, cursos.getHtcurso());
            pst.setInt(7, cursos.getHpcurso());
            pst.setInt(8, cursos.getUserm());
            pst.setInt(9, cursos.getRegistrocurso());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
            }


    
    
}
