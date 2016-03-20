package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlUsers implements DaoUsers {

    @Override
    public void InsertarUsers(Users users) {
        Connection cn=null;
        try {
             cn= Postgresql.conexion();
            String sql = "insert into users (usuario,password,nombre,nivel,fechac,userc,fecham,userm,dni,email) "+
                     "values (?,crypt(?, gen_salt('md5')),?,encrypt(?,'iihuanuco2016','bf'),now(),?,?,?,?,?)";

            PreparedStatement pst = null;
            pst = cn.prepareStatement(sql);
            util.util.creararchivotexto("pst:"+pst.toString());
            pst.setString(1, users.getUsuario());
            util.util.creararchivotexto("pst:"+pst.toString());
            pst.setString(2, users.getPassword());
            util.util.creararchivotexto("pst:"+pst.toString());
            pst.setString(3, users.getNombre());
            pst.setInt(4, users.getNivel());
            pst.setInt(5, users.getUserc());
            pst.setDate(6, util.util.dateutil2sql(users.getFecham()));
            pst.setInt(7, users.getUserm());
            pst.setString(8, users.getDni());
            pst.setString(9, users.getEmail());
            
            util.util.creararchivotexto("hola:"+sql);

            pst.executeUpdate();

            //CIERRO LA CONEXION
            cn.close();
        } catch (Exception e) {
            util.util.creararchivotexto("La conexion:"+cn.toString()+ " error:"+e.toString());
        }
    }

}
