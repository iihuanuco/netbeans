
package entities;


import dao.SqlUsers;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.Postgresql;
import util.util;
 

public class Users {
    
    private int nivel,userc,userm,registro,sexo;
    private String usuario,password,nombre,email,dni;
    private Date fechac,fecham;
    private boolean flag=true,flag2=true;


    public Users() {
    
    }

 

    
    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getUserc() {
        return userc;
    }

    public void setUserc(int userc) {
        this.userc = userc;
    }

    public int getUserm() {
        return userm;
    }

    public void setUserm(int userm) {
        this.userm = userm;
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFechac() {
        return fechac;
    }

    public void setFechac(Date fechac) {
        this.fechac = fechac;
    }

    public Date getFecham() {
        return fecham;
    }

    public void setFecham(Date fecham) {
        this.fecham = fecham;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isFlag2() {
        return flag2;
    }

    public void setFlag2(boolean flag2) {
        this.flag2 = flag2;
    }

 
    
    
    public void registrar(int reg){
        SqlUsers su= new SqlUsers();
        Users u= new Users();
        u.setUsuario(usuario);
        u.setPassword(password);
        u.setNombre(nombre);
        u.setNivel(nivel);
        u.setUserc(reg);
        u.setDni(dni);
        u.setEmail(email);
        u.setSexo(sexo);
        su.InsertarUsers(u);
    }   
    
     public void load(){
       
        if(nombre==null)
        {
        flag=false;
        flag2=false;
        }
        else{
          
            if(dentro_de(new int [] {1})>=0){
                flag = true;
                flag2 = false;
            }
            else if(nivel!=1){
                 flag2=true;
                flag = false;
            }
        }
        
    
    }
 
    public String signout() {
        this.nombre=null;
        return "index";
    }
    
    public int dentro_de(int[] a)
    {
    int i;
    for(i=0;i<a.length;i++)
        if(nivel==a[i])
            return i;
    return -1;
    }
    
    
  
          
          
          
    public void ObtenerAlumno(int reg){
        try {
            Connection conn=Postgresql.conexion();
            String sql=" select a.registro,a.dni,a.nombre,a.usuario,a.email,a.sexo "
                    + " from users a"
                    + " where a.registro='"+reg+"'"
                    + " and convert_from(decrypt(nivel,'iihuanuco2016'::bytea,'bf'),'SQL_ASCII')::int4=5";
            PreparedStatement pst=conn.prepareStatement(sql);
            ResultSet rs=util.getfila(pst);
            this.gdatos(rs);
        } catch (Exception e) {
        }
    
    }
    
    public void gdatos(ResultSet rs){
        try {
            registro=rs.getInt("registro");
            usuario=rs.getString("usuario");
            nombre=rs.getString("nombre");
            dni=rs.getString("dni");
            email=rs.getString("email");
            sexo=rs.getInt("sexo");
        } catch (Exception e) {
        }
    
    }
    
    public void actualizaralumno(int reg){
        SqlUsers su=new SqlUsers();
        Users u=new Users();
        u.setUsuario(usuario);
        u.setPassword(password);
        u.setNombre(nombre);
        u.setUserm(reg);
        u.setDni(dni);
        u.setEmail(email);
        u.setSexo(sexo);
        u.setRegistro(registro);
        su.ActualizarAlumno(u);    
    }
          
}
