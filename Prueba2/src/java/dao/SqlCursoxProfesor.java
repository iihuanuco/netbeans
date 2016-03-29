 
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
            String sql = " select pc.registro,concat(c.nombre,' - ',u.nombre) from cursos c  " +
"                    inner join profesorxcursos pc  " +
"                    on pc.curso=c.registro  " +
"                    inner join users u " +
"                    on u.registro=pc.profesor " +
"                    inner join carreras ca " +
"                    on ca.registro=c.carrera " +
"                     where ca.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                CursoxProfesor d=new CursoxProfesor();
                d.setRegistro(rs.getInt(1));
                d.setCursoxprofe(rs.getString(2));
                
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
    
}
