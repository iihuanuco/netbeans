package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;
import util.util;

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
            util.creararchivotexto("La conexion:"+cn.toString()+ " error:"+e.toString());
        }
    }


    @Override
    public List<Users> ValidarUsers(String user, String password) {
         List<Users> listaUsuario =new ArrayList<Users>();
            Connection cn=null;
        try {
            cn=Postgresql.conexion();
           String sql="select u.registro,u.nombre,"
           + "convert_from(decrypt(u.nivel,'iihuanuco2016'::bytea,'bf'),'SQL_ASCII')::int4 as admin "
                   + "from users as u" +
                      " where u.usuario='"+user+"' and u.password=crypt('"+password+"',u.password) ";
            Statement st=cn.createStatement();
            util.creararchivotexto("Comando:"+sql);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()) {                
                Users c=new Users();
                c.setRegistro(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setNivel(rs.getInt("admin"));
               
               listaUsuario.add(c);
            }
                  
          cn.close();
        } catch (Exception e) {
              util.creararchivotexto("La conexion:"+cn.toString()+ " error:"+e.toString());
        }
        
        return listaUsuario;
    }

    @Override
    public List<Users> MostrarUsers() {
        List<Users> listausers=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,nombre from users";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setNombre(rs.getString(2));
                
                listausers.add(u);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return listausers;
    }

    @Override
    public List<Users> MostrarProfesor() {
        List<Users> listausers=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select registro,nombre from users  where convert_from(decrypt(nivel,'iihuanuco2016'::bytea,'bf'),'SQL_ASCII')::int4=4";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setNombre(rs.getString(2));
                
                listausers.add(u);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return listausers;
    }

    @Override
    public List<Users> MostrarAlumno() {
        List<Users> listaalum=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="Select u.registro,u.nombre from users u  " +
"where not exists (select m.alumno from matricula m where m.alumno = u.registro) and  " +
"convert_from(decrypt(nivel,'iihuanuco2016'::bytea,'bf'),'SQL_ASCII')::int4=5";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setNombre(rs.getString(2));
                
                listaalum.add(u);
            }
            conn.close();
        } catch (Exception e) {
        }
        
        return listaalum;
    }

    @Override
    public List<Users> MostrarAlumnos(int suc) {
        List<Users> listaalum=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "  select  u.registro,u.usuario,u.nombre,u.dni,u.email,u.sexo  "
                    + "            from usersxsucu us  "
                    + "            inner join users u on u.registro=us.usuario  "
                    + "            inner join matricula m on m.alumno=u.registro "
                    + "            where us.sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setDni(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setSexo(rs.getInt(6));
                
                listaalum.add(u);
            }
           conn.close();
        } catch (Exception e) {
        }
        
        return listaalum;    
    }

    @Override
    public List<Users> MostrarProfesores(int suc) {
        List<Users> listaprof=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "  select a.registro,a.usuario,a.nombre,a.dni,a.email,a.sexo from usersxsucu us "
                    + "            inner join users a on a.registro=us.usuario "
                    + "            where us.sucursal="+suc
                    + "            and convert_from(decrypt(nivel,'iihuanuco2016'::bytea,'bf'),'SQL_ASCII')::int4=4";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setUsuario(rs.getString(2));
                u.setNombre(rs.getString(3));
                u.setDni(rs.getString(4));
                u.setEmail(rs.getString(5));
                u.setSexo(rs.getInt(6));
                
                listaprof.add(u);
            }
         conn.close();
        } catch (Exception e) {
        }
        
        return listaprof;
    }

    @Override
    public void ActualizarUsers(Users users) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="update users set usuario=?,nombre=?,dni=?,email=?,"  
                    + "userm=?,sexo=?,fecham=now() "
                    + " where registro=?";
            PreparedStatement pst=conn.prepareStatement(sql);
            
            pst.setString(1, users.getUsuario());
            pst.setString(2, users.getNombre());
            pst.setString(3, users.getDni());
            pst.setString(4, users.getEmail());
            pst.setInt(5, users.getUserm());
             pst.setInt(6, users.getSexo());
            pst.setInt(7, users.getRegistro());
            
            pst.executeUpdate();
            pst.close();
            conn.close();
        } catch (Exception e) {
        }
    }


}
