package dao;

import entities.UserxSucu;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
    public List<UserxSucu> MostrarUserxSucu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
