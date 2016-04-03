package entities;

import dao.SqlUsers;
import dao.SqlUserxSucu;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class UserxSucu {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrouxs;
    //atributo foraneo
    private int usuario;
    private int sucursal;
    private String nusuario,nsucursal;
    private List<UserxSucu> listauxs;
    private List<UserxSucu> filtrouxs;
    private boolean flag=true;
 
    
    public UserxSucu() {
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

    public int getRegistrouxs() {
        return registrouxs;
    }

    public void setRegistrouxs(int registrouxs) {
        this.registrouxs = registrouxs;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getNusuario() {
        return nusuario;
    }

    public void setNusuario(String nusuario) {
        this.nusuario = nusuario;
    }

    public String getNsucursal() {
        return nsucursal;
    }

    public void setNsucursal(String nsucursal) {
        this.nsucursal = nsucursal;
    }

    public List<UserxSucu> getListauxs() {
        return listauxs;
    }

    public void setListauxs(List<UserxSucu> listauxs) {
        this.listauxs = listauxs;
    }

    public List<UserxSucu> getFiltrouxs() {
        return filtrouxs;
    }

    public void setFiltrouxs(List<UserxSucu> filtrouxs) {
        this.filtrouxs = filtrouxs;
    }

    
    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

   
    
    
    public void registrar(int reg,int suc) {   
        boolean sw=false;
        SqlUserxSucu sus=new SqlUserxSucu();
        UserxSucu us=new UserxSucu();
        us.setUsuario(usuario);
        us.setSucursal(suc);
        us.setUserc(reg);
        
        SqlUserxSucu sc=new SqlUserxSucu();
        List<UserxSucu> listacar=sc.MostrarUserxSucu(suc);
        Iterator<UserxSucu> iter=listacar.iterator();
        while (iter.hasNext()) {
            UserxSucu c = iter.next();
            if(c.getUsuario()==usuario ){
            sw=true;
            }      
        }
       
        if(sw==false)
        {
           sus.InsertarUserxSucu(us);
        }
        else if(sw==true){  
            
               FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario ya esta registrado"));

        }
        
    }
    
      public void mostraruxs(int suc){
        listauxs=new ArrayList();
        SqlUserxSucu sc=new SqlUserxSucu();
        List<UserxSucu> listacar=sc.MostrarUserxSucu(suc);
        Iterator<UserxSucu> iter=listacar.iterator();
        while (iter.hasNext()) {
            UserxSucu c = iter.next();
            listauxs.add(c);
        }
        
        
    }
    
    
 
     public void actualizar(UserxSucu uxs,int reg,int suc){
        SqlUserxSucu sc=new SqlUserxSucu();
        UserxSucu s= new UserxSucu();
        s.setRegistrouxs(uxs.registrouxs);
        s.setUsuario(uxs.usuario);
        s.setSucursal(uxs.sucursal);
        s.setUserm(reg);
        sc.ActualizarUserxSucu(s);
        uxs.flag=true;
         mostraruxs(suc);
   }
     
     
    
   
   public void editar(UserxSucu uxs){
       uxs.flag=false;
   }
  
       public void cancelar(UserxSucu uxs){
        uxs.flag=true;
   }
    
  
    
}
