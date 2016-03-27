
package entities;


import dao.SqlUsers;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
 

public class Users {
    
    
    private int nivel,userc,userm,registro,sexo;
    private String usuario,password,nombre,email,dni;
    private Date fechac,fecham;
    private boolean flag=true,flag2=true;
     private List <Users> lista;

    public Users() {
    
    }

    public Users(int nivel, int userc, int userm, int registro, int sexo, String usuario, String password, String nombre, String email, String dni, Date fechac, Date fecham) {
        this.nivel = nivel;
        this.userc = userc;
        this.userm = userm;
        this.registro = registro;
        this.sexo = sexo;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.dni = dni;
        this.fechac = fechac;
        this.fecham = fecham;
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

    public List<Users> getLista() {
        return lista;
    }

    public void setLista(List<Users> lista) {
        this.lista = lista;
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
    
    
          public void mostrar(int curso,int profesor,int act) {
                lista=new ArrayList();  
                SqlUsers pu = new SqlUsers();
                List<Users> listaCurso = pu.MostrarMatriculado(curso,profesor, act);
                Iterator<Users> iter = listaCurso.iterator();
                      while (iter.hasNext()) {
                          Users e = iter.next();
                          lista.add(e);
                      }

      }
    
    
    
}
