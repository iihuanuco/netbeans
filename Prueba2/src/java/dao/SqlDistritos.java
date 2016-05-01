package dao;

import entities.Distritos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlDistritos implements DaoDistritos{

    @Override
    public void InsertarDistritos(Distritos distritos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into distritos(nombre,capital,provincia,fechac,userc)"   //,userc,fecham,userm
                     + " values(?,?,?,now(),?)" ; //,?,?,?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, distritos.getNombredis());
            pst.setString(2, distritos.getCapitaldis());
            pst.setInt(3, distritos.getProvincia());
            pst.setInt(4, distritos.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

   

    @Override
    public List<Distritos> MostrarDistritos(int pro) {
         List<Distritos> listadis=new ArrayList<Distritos>();
        try {
            Connection conn = Postgresql.conexion();
            String sql = "select d.registro,d.nombre,d.capital from provincias p "
                    + "inner join distritos d "
                    + "on d.provincia=p.registro "
                    + "where p.registro="+pro;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Distritos d=new Distritos();
                d.setRegistrodis(rs.getInt(1));
                d.setNombredis(rs.getString(2));
                d.setCapitaldis(rs.getString(3));
                
                listadis.add(d);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return listadis;
    }

    @Override
    public void ActualizarDistritos(Distritos distritos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update distritos set nombre=?,capital=?,userm=?,fecham=now() where registro=? "; 
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            pst.setString(1, distritos.getNombredis());
            pst.setString(2, distritos.getCapitaldis());
            pst.setInt(3, distritos.getUserm());
            pst.setInt(4, distritos.getRegistrodis());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Distritos> MostrarDistritos() {
         List<Distritos> listadis=new ArrayList<Distritos>();
        try {
            Connection conn = Postgresql.conexion();
            String sql = "select d.registro,d.nombre from distritos d ";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Distritos d=new Distritos();
                d.setRegistrodis(rs.getInt(1));
                d.setNombredis(rs.getString(2));
                
                listadis.add(d);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return listadis;
    }
    
    
}
