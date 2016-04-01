package entities;

import dao.SqlActividades;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Actividades {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registroact;
    private Date fechainicioact;
    private String nombreact;
    private int alcanceact;
    //atributo foraneo
    private int sucursal;
    private List<Actividades> listaact;
    private List<Actividades> filtroact;
    private boolean flag=true;

    public Actividades() {
    }

    public Actividades(int userc, int userm, Date fechac, Date fecham, int registroact, Date fechainicioact, String nombreact, int alcanceact, int sucursal) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registroact = registroact;
        this.fechainicioact = fechainicioact;
        this.nombreact = nombreact;
        this.alcanceact = alcanceact;
        this.sucursal = sucursal;
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

    public int getRegistroact() {
        return registroact;
    }

    public void setRegistroact(int registroact) {
        this.registroact = registroact;
    }

    public Date getFechainicioact() {
        return fechainicioact;
    }

    public void setFechainicioact(Date fechainicioact) {
        this.fechainicioact = fechainicioact;
    }

    public String getNombreact() {
        return nombreact;
    }

    public void setNombreact(String nombreact) {
        this.nombreact = nombreact;
    }

    public int getAlcanceact() {
        return alcanceact;
    }

    public void setAlcanceact(int alcanceact) {
        this.alcanceact = alcanceact;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public List<Actividades> getListaact() {
        return listaact;
    }

    public void setListaact(List<Actividades> listaact) {
        this.listaact = listaact;
    }

    public List<Actividades> getFiltroact() {
        return filtroact;
    }

    public void setFiltroact(List<Actividades> filtroact) {
        this.filtroact = filtroact;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
    
    public void registrar(int reg,int suc){
        SqlActividades sa=new SqlActividades();
        Actividades a=new Actividades();
        
        a.setFechainicioact(fechainicioact);
        a.setNombreact(nombreact);
        a.setSucursal(suc);
        a.setAlcanceact(alcanceact);
        a.setUserc(reg);
        
        sa.InsertarActividades(a);
    }
    
    
      public void mostraract(int suc){
        listaact=new ArrayList();
        SqlActividades sc=new SqlActividades();
        List<Actividades> listacar=sc.MostrarActividades(suc);
        Iterator<Actividades> iter=listacar.iterator();
        while (iter.hasNext()) {
            Actividades c = iter.next();
            listaact.add(c);
        }
        
        
    }
    
    
 
     public void actualizar(Actividades act,int reg){
         
       SqlActividades su= new SqlActividades();
       Actividades u= new Actividades();
       u.setNombreact(act.nombreact);
       u.setFechainicioact(act.fechainicioact);
       u.setUserm(reg);
       u.setAlcanceact(act.alcanceact);
       u.setRegistroact(act.registroact);
       su.ActualizarActividades(u);
        act.flag=true;
   }
     
     
    
   
   public void editar(Actividades act){
       act.flag=false;
   }
  
       public void cancelar(Actividades act){
        act.flag=true;
   }
    
    
}
