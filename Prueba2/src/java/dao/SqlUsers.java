package dao;

import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
            util.util.creararchivotexto("Comando:"+sql);
            ResultSet rs=st.executeQuery(sql);
            while(rs.next()) {                
                Users c=new Users();
                c.setRegistro(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setNivel(rs.getInt("admin"));
               
               listaUsuario.add(c);
            }
                  
            
        } catch (Exception e) {
              util.util.creararchivotexto("La conexion:"+cn.toString()+ " error:"+e.toString());
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
            
        } catch (Exception e) {
        }
        
        return listaalum;
    }

    @Override
    public List<Users> MostrarProfesor(int reg) {
         List<Users> listaalum=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "  select u.registro,u.nombre from users u  "
                    + "  inner join profesorxcursos pc "
                    + "  on u.registro=pc.profesor "
                    + "  where pc.curso="+reg;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setNombre(rs.getString(2));
                
                listaalum.add(u);
            }
            
        } catch (Exception e) {
        }
        
        return listaalum;
    }

    @Override
    public List<Users> MostrarMatriculado(int curso, int profesor, int act) {
         List<Users> listaalum=new ArrayList<Users>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = " select mc.registro,u.nombre "
                    + "from users u "
                    + "inner join matricula m "
                    + "on m.alumno=u.registro "
                    + "inner join matriculaxcursos mc "
                    + "on mc.matricula=m.registro "
                    + "inner join profesorxcursos pc "
                    + "on mc.profesorxcurso=pc.registro "
                    + "inner join users us "
                    + "on us.registro=pc.profesor "
                    + "inner join actividades ac "
                    + "on ac.registro=m.actividad "
                    + "where pc.curso="+curso+" and pc.profesor="+profesor+" and ac.registro="+act;
             Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Users u=new Users();
                u.setRegistro(rs.getInt(1));
                u.setNombre(rs.getString(2));
                
                listaalum.add(u);
            }
            
        } catch (Exception e) {
        }
        
        return listaalum;
    }
}
