package dao;

import entities.Carreras;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlCarreras implements DaoCarreras{

    @Override
    public void InsertarCarreras(Carreras carreras) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into carreras(codigo,nombre,semestres,sucursal,fechac,userc)"
                    + " values(?,?,?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            pst.setString(1, carreras.getCodigocarrera());
            pst.setString(2, carreras.getNombrecarrera());
            pst.setInt(3, carreras.getSemestrescarrera());
            pst.setInt(4, carreras.getSucursal());
            pst.setInt(5, carreras.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Carreras> MostrarCarreras() {
        List<Carreras> listacar=new ArrayList<Carreras>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,nombre from carreras";
            
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Carreras c=new Carreras();
                c.setRegistrocarrera(rs.getInt(1));
                c.setNombrecarrera(rs.getString(2));
                
                listacar.add(c);
            }
            
        } catch (Exception e) {
        }
        return listacar;
    }

    
}
