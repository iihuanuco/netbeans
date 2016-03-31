package dao;

import entities.Sucursales;
import util.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlSucursales implements DaoSucursales{

    @Override
    public void InsertarSucursales(Sucursales sucursales) {
        
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into sucursales(nombre,empresa,direccion,distrito,alcance,"
                    + "codigomodular,autorizacion,fechaautorizacion,revalidacion,tipodegestion,fechac,userc)"
                    + " values(?,?,?,?,?,?,?,?,?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, sucursales.getNombresuc());
            pst.setInt(2, sucursales.getEmpresa());
            pst.setString(3, sucursales.getDireccionsuc());
            pst.setInt(4, sucursales.getDistrito());
            pst.setInt(5, sucursales.getAlcancesuc());
            pst.setString(6, sucursales.getCodigomodularsuc());
            pst.setString(7, sucursales.getAutorizacionsuc());
            pst.setDate(8, util.dateutil2sql(sucursales.getFechaautorizacionsuc()));
            pst.setString(9, sucursales.getRevalidacionsuc());
            pst.setInt(10, sucursales.getTipodegestionsuc());
            pst.setInt(11, sucursales.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<Sucursales> MostrarSucursales() {
       List<Sucursales> listaSucur=new ArrayList<Sucursales>();
        try {
            Connection cn=Postgresql.conexion();
            String sql = "select s.registro,s.nombre,e.nombre,d.nombre from sucursales s "
                    + "inner join distritos d "
                    + "on d.registro=s.distrito "
                    + "inner join empresas e  "
                    + "on e.registro=s.empresa";
            
            Statement st=cn.createStatement(); 
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()) {                
                Sucursales c=new Sucursales();
                c.setRegistrosuc(rs.getInt(1));
                c.setNombresuc(rs.getString(2));
                c.setNempresa(rs.getString(3));
                c.setNdistrito(rs.getString(4));

               listaSucur.add(c);
            }      
            
        } catch (Exception e) {
        }
        
       
        return listaSucur;
    }

    @Override
    public List<Sucursales> MostrarSucursales(int user) {
           List<Sucursales> listaSucur=new ArrayList<Sucursales>();
        try {
            Connection cn=Postgresql.conexion();
            String sql="select s.registro,s.nombre " +
            "from usersxsucu us " +
            "inner join users u " +
            "on u.registro=us.usuario " +
            "inner join sucursales s " +
            "on us.sucursal=s.registro " +
            "where u.registro ="+user;
            
            Statement st=cn.createStatement(); 
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while(rs.next()) {                
                Sucursales c=new Sucursales();
                c.setRegistrosuc(rs.getInt(1));
                c.setNombresuc(rs.getString(2));
                

               listaSucur.add(c);
            }      
            
        } catch (Exception e) {
        }
        
       
        return listaSucur;
    }

    @Override
    public void ActualizarSucursales(Sucursales sucursales) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="update sucursales set nombre=?,direccion=?,alcance=?,codigomodular=?,tipodegestion=?,fecham=now(),userm=? where registro=? ";  //,autorizacion=?,fechaautorizacion=?,revalidacion=?
            
            PreparedStatement pst=null; 
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, sucursales.getNombresuc());
            pst.setString(2, sucursales.getDireccionsuc());
            
            pst.setInt(3, sucursales.getAlcancesuc());
            pst.setString(4, sucursales.getCodigomodularsuc());
            //pst.setString(5, sucursales.getAutorizacionsuc());
            //pst.setDate(6, sucursales.getFechaautorizacionsuc());
            //pst.setString(7, sucursales.getRevalidacionsuc());
            pst.setInt(5, sucursales.getTipodegestionsuc());
            pst.setInt(6, sucursales.getUserm());
            pst.setInt(7, sucursales.getRegistrosuc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }
    
}
