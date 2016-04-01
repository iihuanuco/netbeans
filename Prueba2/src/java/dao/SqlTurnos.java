package dao;

import entities.Turnos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlTurnos implements DaoTurnos{

    @Override
    public void InsertarTurnos(Turnos turnos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into turnos(codigo,nombre,fechac,userc)"
                    + " values(?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, turnos.getCodigotur());
            pst.setString(2, turnos.getNombretur());
            pst.setInt(3, turnos.getUserc());
            
            pst.executeQuery();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Turnos> MostrarTurnos() {
        List<Turnos> listatur=new ArrayList<Turnos>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,codigo,nombre from turnos";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Turnos t=new Turnos();
                t.setRegistrotur(rs.getInt(1));
                 t.setCodigotur(rs.getInt(2));
                t.setNombretur(rs.getString(3));
               
                
                listatur.add(t);
            }
        } catch (Exception e) {
        }
        return listatur;
    }

    @Override
    public void ActualizarTurnos(Turnos turnos) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql=" update turnos set codigo=?,nombre=?,fecham=now(),userm=? where registro=?";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, turnos.getCodigotur());
            pst.setString(2, turnos.getNombretur());
            pst.setInt(3, turnos.getUserm());
            pst.setInt(4, turnos.getRegistrotur());
            
            pst.executeQuery();
            
            conn.close();
        } catch (Exception e) {
        }
    }

}
