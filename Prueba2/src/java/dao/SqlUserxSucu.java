package dao;

import entities.UserxSucu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlUserxSucu implements DaoUserxSucu{

    @Override
    public void InsertarUserxSucu(UserxSucu userxSucu) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql="insert into usersxsucu(usuario,sucursal,fechac,userc)"
                    + " values(?,?,now(),?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, userxSucu.getUsuario());
            pst.setInt(2, userxSucu.getSucursal());
            pst.setInt(3, userxSucu.getUserc());
            util.util.creararchivotexto(pst.toString());
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
            
        }
        
        
    }

    @Override
    public List<UserxSucu> MostrarUserxSucu(int suc) {
        List<UserxSucu> listaemp=new ArrayList<UserxSucu>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "select uxs.registro,u.registro,u.nombre,s.registro,s.nombre "
                    + "from usersxsucu uxs  "
                    + "inner join users u on u.registro=uxs.usuario "
                    + "inner join sucursales s on s.registro=uxs.sucursal  "
                    + "where s.registro="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                UserxSucu e=new UserxSucu();
                e.setRegistrouxs(rs.getInt(1));
                e.setUsuario(rs.getInt(2));
                e.setNusuario(rs.getString(3));
                e.setSucursal(rs.getInt(4));
                e.setNsucursal(rs.getString(5));
                
                listaemp.add(e);
            }
            
        } catch (Exception e) {
        }
        
        return listaemp;
    }

    @Override
    public void ActualizarUserxSucu(UserxSucu userxSucu) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            
            String sql=" update usersxsucu set  usuario=?,sucursal=?,fecham=now(),userm=? where registro=?";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, userxSucu.getUsuario());
            pst.setInt(2, userxSucu.getSucursal());
            pst.setInt(3, userxSucu.getUserm());
             pst.setInt(4, userxSucu.getRegistrouxs());
       
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
            
        }
        
    }
    
}
