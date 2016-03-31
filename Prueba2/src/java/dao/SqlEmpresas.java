package dao;

import entities.Empresas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlEmpresas implements DaoEmpresas{

    @Override
    public void InsertarEmpresas(Empresas empresas) {
        
        Connection conn=null;
        
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into empresas(nombre,fechac,userc,ruc)"
                    + " values(?,now(),?,?)" ;
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, empresas.getNombreemp());
            pst.setInt(2, empresas.getUserc());
            pst.setString(3, empresas.getRucemp());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Empresas> MostrarEmpresas() {
        List<Empresas> listaemp=new ArrayList<Empresas>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,ruc,nombre from empresas";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Empresas e=new Empresas();
                e.setRegistroemp(rs.getInt(1));
                e.setRucemp(rs.getString(2));
                e.setNombreemp(rs.getString(3));
                
                listaemp.add(e);
            }
            
        } catch (Exception e) {
        }
        
        return listaemp;
    }    

    @Override
    public void ActualizarEmpresas(Empresas empresas) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update empresas set nombre=?,userm=?,fecham=now(),ruc=? where registro=? "; 
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, empresas.getNombreemp());
            pst.setInt(2, empresas.getUserm());
            pst.setString(3, empresas.getRucemp());
            pst.setInt(4, empresas.getRegistroemp());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }
    
    
}
