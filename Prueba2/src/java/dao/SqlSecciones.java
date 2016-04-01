package dao;

import entities.Secciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlSecciones implements DaoSecciones{

    @Override
    public void InsertarSecciones(Secciones secciones) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into secciones(codigo,nombre,fechac,userc)"
                    + " values(?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, secciones.getCodigosec());
            pst.setString(2, secciones.getNombresec());
            pst.setInt(3, secciones.getUserc());
            
            pst.executeQuery();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Secciones> MostrarSecciones() {
        List<Secciones> listasec=new ArrayList<Secciones>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,codigo,nombre from secciones";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Secciones s=new Secciones();
                s.setRegistrosec(rs.getInt(1));
                s.setCodigosec(rs.getInt(2));
                s.setNombresec(rs.getString(3));
                
                listasec.add(s);
            }
        } catch (Exception e) {
        }
        
        return listasec;
    }

    @Override
    public void ActualizarSecciones(Secciones secciones) {
         Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql=" update secciones set codigo=?,nombre=?,fecham=now(),userm=? where registro=? ";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, secciones.getCodigosec());
            pst.setString(2, secciones.getNombresec());
            pst.setInt(3, secciones.getUserm());
            pst.setInt(4, secciones.getRegistrosec());
            
            pst.executeQuery();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    
}
