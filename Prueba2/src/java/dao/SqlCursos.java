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
    public List<Cursos> MostrarCursos() {
          List<Cursos> listacur=new ArrayList<Cursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,nombre from cursos";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Cursos d=new Cursos();
                d.setRegistrocurso(rs.getInt(1));
                d.setNombrecurso(rs.getString(2));
                
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    }

    @Override
    public List<Cursos> MostrarCursos(int carr, int suc) {
        List<Cursos> listacur=new ArrayList<Cursos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select c.codigo,c.nombre  "
                    + "from cursos c "
                    + "inner join carreras ca "
                    + "on ca.registro=c.carrera "
                    + "inner join sucursales s "
                    + "on s.registro=ca.sucursal "
                    + "where ca.registro="+carr+" and s.registro="+suc;
            util.creararchivotexto("hola: "+String.valueOf(carr)+String.valueOf(suc));
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Cursos d=new Cursos();
                d.setCodigocurso(rs.getString(1));
                d.setNombrecurso(rs.getString(2));
                
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    }

    
    
}
