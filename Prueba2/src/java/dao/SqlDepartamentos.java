package dao;

import entities.Departamentos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlDepartamentos implements DaoDepartamentos{

    @Override
    public void InsertarDepartamentos(Departamentos departamentos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into departamentos(nombre,fechac,userc)"   //,userc,fecham,userm
                     + " values(?,now(),?)" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, departamentos.getNombredep());
            pst.setInt(2, departamentos.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Departamentos> MostrarDepartamentos() {
        List<Departamentos> listaDepa=new ArrayList<Departamentos>();
        try {
            Connection cn=Postgresql.conexion();
            String sql="select registro,nombre from departamentos";
            
            Statement st=cn.createStatement(); 
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()) {                
                Departamentos c=new Departamentos();
                c.setRegistrodep(rs.getInt(1));
                c.setNombredep(rs.getString(2));

               listaDepa.add(c);
            }      
            
        } catch (Exception e) {
        }
        
       
        return listaDepa;
    }

    @Override
    public void ActualizarDepartamentos(Departamentos departamentos) {
       Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update departamentos set nombre=?,userm=?,fecham=now() where registro=? "; 
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, departamentos.getNombredep());
            pst.setInt(2, departamentos.getUserm());
             pst.setInt(3, departamentos.getRegistrodep());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }
    
}
