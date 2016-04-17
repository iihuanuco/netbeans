 
package dao;

import entities.CursoxProfesor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

 
public class SqlCursoxProfesor implements DaoCursoxProfesor{

    @Override
    public void InsertarCursoxProfesor(CursoxProfesor cursoxprofesor) {
            Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into profesorxcursos(profesor,curso,actividad,userc)"   
                     + " values(?,?,?,?)" ;  
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, cursoxprofesor.getProfesor());
            pst.setInt(2, cursoxprofesor.getCurso());
            pst.setInt(3, cursoxprofesor.getActividad());
            pst.setInt(4, cursoxprofesor.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<CursoxProfesor> MostrarCursoxProfesor(int suc) {
       List<CursoxProfesor> listacur=new ArrayList<CursoxProfesor>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = " select pc.registro,c.registro,c.nombre,u.registro,u.nombre,ac.registro,ac.nombre from cursos c  " +
"                    inner join profesorxcursos pc   " +
"                    on pc.curso=c.registro   " +
"                    inner join users u  " +
"                    on u.registro=pc.profesor  " +
"                    inner join carreras ca  " +
"                    on ca.registro=c.carrera  " +
"                    inner join actividades ac " +
"                    on ac.registro=pc.actividad " +
"                     where ca.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                CursoxProfesor d=new CursoxProfesor();
                d.setRegistro(rs.getInt(1));
                d.setCurso(rs.getInt(2));
                d.setNcurso(rs.getString(3));
                d.setProfesor(rs.getInt(4));
                d.setNprofesor(rs.getString(5));
                d.setActividad(rs.getInt(6));
                d.setNactividad(rs.getString(7));
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    }

    @Override
    public List<CursoxProfesor> MostrarCursos(int carr, int suc, int act) {
 
        List<CursoxProfesor> listacur=new ArrayList<CursoxProfesor>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select pc.registro,c.nombre,u.nombre " +
"                    from profesorxcursos pc  " +
"                    inner join cursos c  " +
"                    on c.registro=pc.curso " +
"                    inner join users u  " +
"                    on u.registro=pc.profesor  " +
"                    inner join carreras ca  " +
"                    on ca.registro=c.carrera  " +
"                    inner join sucursales s  " +
"                    on s.registro=ca.sucursal  " +
"                    where ca.registro="+carr+" and s.registro="+suc+" and pc.actividad="+act;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                CursoxProfesor d=new CursoxProfesor();
                d.setRegistro(rs.getInt(1));
                d.setNcurso(rs.getString(2));
                d.setNprofesor(rs.getString(3));  
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    
    }

    @Override
    public void ActualizarCursoxProfesor(CursoxProfesor cursoxprofesor) {
           Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update profesorxcursos set curso=?,profesor=?,actividad=?,fecham=now(),userm=? where registro=? " ;  
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setInt(1, cursoxprofesor.getCurso());
            pst.setInt(2, cursoxprofesor.getProfesor());
            pst.setInt(3, cursoxprofesor.getActividad());
            pst.setInt(4, cursoxprofesor.getUserm());
              pst.setInt(5, cursoxprofesor.getRegistro());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    @Override
    public List<CursoxProfesor> MostrarCursoDisponibles(int mat, int suc, int carr,int act) {
       List<CursoxProfesor> listacur=new ArrayList<CursoxProfesor>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select pc.registro,c.nombre,u.nombre,c.creditos "
                    + "from profesorxcursos pc  "
                    + "inner join users u on u.registro=pc.profesor "
                    + "inner join cursos c on c.registro=pc.curso "
                    + "inner join carreras ca on c.carrera=ca.registro "
                    + "inner join sucursales su on su.registro=ca.sucursal  "
                    +"inner join actividades at on at.registro=pc.actividad  "
                    + "where not exists(select * from matriculaxcursos mc where mc.profesorxcurso=pc.registro and mc.matricula="+mat+") "
                    + "and su.registro="+suc+" and ca.registro="+carr+"  and at.registro="+act ;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                CursoxProfesor d=new CursoxProfesor();
                d.setRegistro(rs.getInt(1));
                d.setNcurso(rs.getString(2));
                d.setNprofesor(rs.getString(3));  
                d.setCreditos(rs.getInt(4));
                listacur.add(d);
            }
            
        } catch (Exception e) {
        }
        
        return listacur;
    }
    
}
