package dao;

import entities.Sucursales;
import util.util;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    
}
