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
            String sql="select registro,nombre from turnos";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Turnos t=new Turnos();
                t.setRegistrotur(rs.getInt(1));
                t.setNombretur(rs.getString(2));
                
                listatur.add(t);
            }
        } catch (Exception e) {
        }
        return listatur;
    }

}
