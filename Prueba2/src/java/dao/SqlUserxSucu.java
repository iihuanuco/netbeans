package dao;

import entities.UserxSucu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.Postgresql;

public class SqlUserxSucu implements DaoUserxSucu{

    @Override
    public void InsertarUserxSucu(UserxSucu userxSucu) {
        
        Connection conn=null;
        /*
        //obtebgo lista de usuarios(registro)
        ArrayList<Integer> listauser = new ArrayList<>();
        try {
            conn = Postgresql.conexion();
            String user = "select usuario from usersxsucu";
            Statement stu = conn.createStatement();
            ResultSet rsu = null;
            rsu = stu.executeQuery(user);
            while (rsu.next()) {
                UserxSucu u = new UserxSucu();
                u.setUsuario(rsu.getInt(1));
                listauser.add(u);
            }
            conn.close();
        } catch (Exception ee) {
            System.out.println(""+ee);
        }
        //obtengo lista de sucursales(registro) 
        ArrayList<Integer> listasucursal = new ArrayList<>();
        try {
            conn = Postgresql.conexion();
            String sucursal = "select sucursal from usersxsucu";
            Statement sts = conn.createStatement();
            ResultSet rss = null;
            rss = sts.executeQuery(sucursal);
            while (rss.next()) {
                UserxSucu s = new UserxSucu();
                s.setSucursal(rss.getInt(1));
                listasucursal.add(s);
            }

            conn.close();
        } catch (Exception eee) {
            System.out.println(""+eee);
        }
        
    */
        /*
        for(int useract : listauser; int sucursalact : listasucursal){
           
            if(useract.equals(userxSucu.getUsuario()); sucursalact.equals(userxSucu.getSucursal())){
        */
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
        /*
            }
           
        }
     
            
        for (Iterator iterator = listauser.iterator(); iterator.hasNext();) {
            int usuarioact = (int) iterator.next();
            if(usuarioact==userxSucu.getUsuario()){
                for (Iterator iterator1 = listasucursal.iterator(); iterator1.hasNext();) {
                    int sucursalact = (int) iterator1.next();
                    if (sucursalact==userxSucu.getSucursal()) {
                        System.out.println("El usuario ya se registro en esta sucursal");
                    }
                }
            }
        }
        
                    
      */  
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
