package dao;

import entities.Actividades;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;
import java.sql.Statement;
import util.util;

public class SqlActividades implements DaoActividades{

    @Override
    public void InsertarActividades(Actividades actividades) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into actividades(fechainicio,nombre,sucursal,alcance,fechac,userc)"
                    + " values(?,?,?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setDate(1, util.dateutil2sql(actividades.getFechainicioact()));
            pst.setString(2, actividades.getNombreact());
            pst.setInt(3, actividades.getSucursal());
            pst.setInt(4, actividades.getAlcanceact());
            pst.setInt(5, actividades.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Actividades> MostrarActividades(int suc) {
        List<Actividades> listaact=new ArrayList<Actividades>();
        try {
            Connection conn=Postgresql.conexion();
            String sql=" select a.registro,a.nombre,a.fechainicio,a.alcance from actividades a where a.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Actividades a=new Actividades();
                a.setRegistroact(rs.getInt(1));
                a.setNombreact(rs.getString(2));
                a.setFechainicioact(rs.getDate(3));
                a.setAlcanceact(rs.getInt(4));
                
                listaact.add(a);
            }
            
        } catch (Exception e) {
        }
        
        return listaact;
    }

    @Override
    public void ActualizarActividades(Actividades actividades) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update  actividades set nombre=?,fechainicio=?,alcance=?,userm=?,fecham=now() where registro=?";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
          
            pst.setString(1, actividades.getNombreact());
            pst.setDate(2, util.dateutil2sql(actividades.getFechainicioact()));
            pst.setInt(3, actividades.getAlcanceact());
            pst.setInt(4, actividades.getUserm());
            pst.setInt(5, actividades.getRegistroact());

            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

}
