package dao;

import entities.Provincias;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlProvincias implements DaoProvincias{

    @Override
    public void InsertarProvincias(Provincias provincias) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into provincias(nombre,departamento,fechac,userc)"   //,userc,fecham,userm
                     + " values(?,?,now(),?)" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, provincias.getNombrepro());
            pst.setInt(2, provincias.getDepartamento());
            pst.setInt(3, provincias.getUserc() );
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Provincias> MostrarProvincias() {
        List<Provincias> listaPro=new ArrayList<Provincias>();
        try {
            Connection cn=Postgresql.conexion();
            String sql="select registro,nombre from provincias";
            
            Statement st=cn.createStatement(); 
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()) {                
                Provincias c=new Provincias();
                c.setRegistropro(rs.getInt(1));
                c.setNombrepro(rs.getString(2));

               listaPro.add(c);
            }      
            cn.close();
        } catch (Exception e) {
        }
        
       
        return listaPro;
    }

    @Override
    public List<Provincias> MostrarProvincias(int depa) {
        List<Provincias> listaPro=new ArrayList<Provincias>();
        try {
            Connection cn=Postgresql.conexion();
            String sql = "select p.registro,p.nombre from departamentos d "
                    + "inner join provincias p "
                    + "on p.departamento=d.registro "
                    + "where d.registro="+depa;
            
            Statement st=cn.createStatement(); 
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()) {                
                Provincias c=new Provincias();
                c.setRegistropro(rs.getInt(1));
                c.setNombrepro(rs.getString(2));

               listaPro.add(c);
            }      
            cn.close();
        } catch (Exception e) {
        }
        
       
        return listaPro;
    }

    @Override
    public void ActualizarProvincias(Provincias provincias) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update provincias set nombre=?,userm=?,fecham=now() where registro=? "; 
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, provincias.getNombrepro());
            pst.setInt(2, provincias.getUserm());
            pst.setInt(3, provincias.getRegistropro());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }
    
    
}
