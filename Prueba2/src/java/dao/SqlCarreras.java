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
    public List<Carreras> MostrarCarreras(int suc) {
        List<Carreras> listacar=new ArrayList<Carreras>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select c.registro,c.nombre,c.codigo,c.semestres " +
            " from carreras c " +
            " inner join sucursales su " +
            " on su.registro=c.sucursal " +
            " where su.registro = "+suc;
            
            Statement st=conn.createStatement();
            ResultSet rs=null;
      
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Carreras c=new Carreras();
                c.setRegistrocarrera(rs.getInt(1));
                c.setNombrecarrera(rs.getString(2));
                c.setCodigocarrera(rs.getString(3));
                c.setSemestrescarrera(rs.getInt(4));
             
                listacar.add(c);
                       
            }
          conn.close();  
        } catch (Exception e) {
        }
        return listacar;
    }

    @Override
    public List<Carreras> MostrarSemestres(int reg) {
        List<Carreras> listacar=new ArrayList<Carreras>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select semestres from carreras  where registro = "+reg;
            
            Statement st=conn.createStatement();
            ResultSet rs=null;
            util.util.creararchivotexto(String.valueOf(reg));
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Carreras c=new Carreras();
                c.setSemestrescarrera(rs.getInt(1));
                listacar.add(c);
                       
            }
          conn.close();  
        } catch (Exception e) {
        }
        return listacar;
    }

    @Override
    public void ActualizarCarreras(Carreras carreras) {
        try {
            Connection conn=Postgresql.conexion();
            String sql="update carreras "
                    + "set codigo=?,nombre=?,semestres=?,"
                    + "fecham=now(),userm=? "
                    + "where registro=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            
            pst.setString(1, carreras.getCodigocarrera());
            pst.setString(2, carreras.getNombrecarrera());
            pst.setInt(3, carreras.getSemestrescarrera());
            pst.setInt(4, carreras.getUserm());
            pst.setInt(5, carreras.getRegistrocarrera());
            
            pst.executeUpdate();
            pst.close();
            conn.close();
            
        } catch (Exception e) {
        }
        
    }

    
}
