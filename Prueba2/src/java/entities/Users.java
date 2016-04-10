
package entities;


import dao.SqlUsers;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

 

public class Users {
    
    private int nivel,userc,userm,registro,sexo;
    private String usuario,password,nombre,email,dni;
    private Date fechac,fecham;
    private boolean flag=true,flag2=true,flag3=true;
           private List<Users> listaalumnos;
    private List<Users> listaprofesor;
    //filtro para tablas
    private List<Users> alumnofiltro;
    private List<Users> profesorfiltro;
 



    public Users() {
    
    }

 
    public boolean filterByName(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim();
    if (filterText == null || filterText.equals("")) {
        return true;
    }

    if (value == null) {
        return false;
    }

    String Name = value.toString().toUpperCase();
    filterText = filterText.toUpperCase();

    if (Name.contains(filterText)) {
        return true;
    } else {
        return false;
    }
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

    public boolean isFlag3() {
        return flag3;
    }

    public void setFlag3(boolean flag3) {
        this.flag3 = flag3;
    }
    
    
    
     public List<Users> getListaalumnos() {
        return listaalumnos;
    }

    public void setListaalumnos(List<Users> listaalumnos) {
        this.listaalumnos = listaalumnos;
    }

    public List<Users> getListaprofesor() {
        return listaprofesor;
    }

    public void setListaprofesor(List<Users> listaprofesor) {
        this.listaprofesor = listaprofesor;
    }

    public List<Users> getAlumnofiltro() {
        return alumnofiltro;
    }

    public void setAlumnofiltro(List<Users> alumnofiltro) {
        this.alumnofiltro = alumnofiltro;
    }

   

    public List<Users> getProfesorfiltro() {
        return profesorfiltro;
    }

    public void setProfesorfiltro(List<Users> profesorfiltro) {
        this.profesorfiltro = profesorfiltro;
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
    
    
   public void mostraralumnos(int suc) {
                listaalumnos=new ArrayList();  
                SqlUsers pu = new SqlUsers();
                List<Users> listaalum = pu.MostrarAlumnos(suc);
                Iterator<Users> iter = listaalum.iterator();
                listaalumnos.clear();
                      while (iter.hasNext()) {
                          Users e = iter.next();
                          listaalumnos.add(e);
                      }

      }
   
     public void mostrardocente(int suc) {
                listaprofesor=new ArrayList();  
                SqlUsers pu = new SqlUsers();
                List<Users> listaprofe = pu.MostrarProfesores(suc);
                Iterator<Users> iter = listaprofe.iterator();
                listaprofesor.clear();
                      while (iter.hasNext()) {
                          Users e = iter.next();
                          listaprofesor.add(e);
                      }

      }
   
     public void actualizar(Users alumno,int reg){
       SqlUsers su= new SqlUsers();
       Users u= new Users();
       u.setRegistro(alumno.registro);
       u.setUsuario(alumno.usuario);
       u.setNombre(alumno.nombre);
       u.setDni(alumno.dni);
       u.setEmail(alumno.email);
       u.setSexo(alumno.sexo);
       u.setUserm(reg);
       su.ActualizarUsers(u);
        
        alumno.flag3=true;
   }
     
     
    
   
   public void editar(Users alumno){
       alumno.flag3=false;
   }
  
       public void cancelar(Users alumno){
        alumno.flag3=true;
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
        return "index?faces-redirect=true";
    }
    
    public int dentro_de(int[] a)
    {
    int i;
    for(i=0;i<a.length;i++)
        if(nivel==a[i])
            return i;
    return -1;
    }
    
    
          
}
