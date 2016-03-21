package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.Postgresql;

public class SqlUsers implements DaoUsers {

    @Override
    public void InsertarUsers(Users users) {
        Connection cn=null;
        try {
             cn= Postgresql.conexion();
            String sql = "insert into users (usuario,password,nombre,nivel,userc,dni,email,sexo) "+
                     "values (?,crypt(?, gen_salt('md5')),?,encrypt(?,'iihuanuco2016'::bytea,'bf'),NULLIF(?,0),?,?,?)";

            PreparedStatement pst = null;
            pst = cn.prepareStatement(sql);
            pst.setString(1, users.getUsuario());
            pst.setString(2, users.getPassword());
            pst.setString(3, users.getNombre());
            pst.setBytes(4, Integer.toString(users.getNivel()).getBytes());
            pst.setInt(5, users.getUserc());
            pst.setString(6, users.getDni());
            pst.setString(7, users.getEmail());
            pst.setInt(8,users.getSexo());
            
            pst.executeUpdate();

            //CIERRO LA CONEXION
            cn.close();
        } catch (Exception e) {
            util.util.creararchivotexto("La conexion:"+cn.toString()+ " error:"+e.toString());
        }
    }

    public void validarDatos(){
        Users u=new Users();
        try {
           Connection conn=Postgresql.conexion();
           String sql="select u.registro,u.nivel,u.nombre from users u" +
                      " where u.usuario=? and u.password=crypt(?,u.password) ";
           PreparedStatement pst=conn.prepareStatement(sql);
           pst.setString(1, u.getUsuario());
           pst.setString(2, u.getPassword());
           
           ResultSet rs=pst.executeQuery();
           
           while (rs.next()) {
               u.setRegistro(rs.getInt("registro"));
               u.setNivel(rs.getInt("nivel"));
               
           }
           
           Postgresql.cerrar(conn);
           
       } catch (SQLException e) {
           Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, e);
       }
       }
}
