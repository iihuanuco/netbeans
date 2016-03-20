package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import util.Postgresql;

public class SqlUsers implements DaoUsers {

    @Override
    public void InsertarUsers(Users users) {
        try {
            Connection cn = Postgresql.conexion();
            String sql = "insert into users (usuario,password,nombre,nivel,fechac,userc,fecham,userm,dni,email) values "
                    + "(?,crypt(?, gen_salt('md5')),?,encrypt(?,'iihuanuco2016','bf'),?,?,?,?,?,?)";

            PreparedStatement pst = null;
            pst = cn.prepareStatement(sql);
            pst.setString(1, users.getUsuario());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getNombre());
            pst.setInt(4, users.getNivel());
            pst.setDate(5, util.util.dateutil2sql(users.getFechac()));
            pst.setInt(6, users.getUserc());
            pst.setDate(7, util.util.dateutil2sql(users.getFecham()));
            pst.setInt(8, users.getUserm());
            pst.setString(9, users.getDni());
            pst.setString(10, users.getEmail());
            

            pst.executeUpdate();

            //CIERRO LA CONEXION
            cn.close();
        } catch (Exception e) {
        }
    }

}
