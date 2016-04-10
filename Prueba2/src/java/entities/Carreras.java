package entities;

import dao.SqlCarreras;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Carreras {

     //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrocarrera,registrocarrera2;
    private String codigocarrera;
    private String nombrecarrera,nombrecarrera2;
    private int semestrescarrera;
    private int estadocarrera; //estado: *null=activo; !null=debaja,suspendido,etc.
    //atributo foraneo
    private int sucursal;
    //otros
    private List<Carreras> listacarreras;
    private List<Carreras> filtrocarreras;
    private boolean flag=true;

    public Carreras() {
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

    public int getRegistrocarrera() {
        return registrocarrera;
    }

    public void setRegistrocarrera(int registrocarrera) {
        this.registrocarrera = registrocarrera;
    }

    public String getCodigocarrera() {
        return codigocarrera;
    }

    public void setCodigocarrera(String codigocarrera) {
        this.codigocarrera = codigocarrera;
    }

    public String getNombrecarrera() {
        return nombrecarrera;
    }

    public void setNombrecarrera(String nombrecarrera) {
        this.nombrecarrera = nombrecarrera;
    }

    public int getSemestrescarrera() {
        return semestrescarrera;
    }

    public void setSemestrescarrera(int semestrescarrera) {
        this.semestrescarrera = semestrescarrera;
    }

    public int getEstadocarrera() {
        return estadocarrera;
    }

    public void setEstadocarrera(int estadocarrera) {
        this.estadocarrera = estadocarrera;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public List<Carreras> getFiltrocarreras() {
        return filtrocarreras;
    }

    public void setFiltrocarreras(List<Carreras> filtrocarreras) {
        this.filtrocarreras = filtrocarreras;
    }

    public List<Carreras> getListacarreras() {
        return listacarreras;
    }

    public void setListacarreras(List<Carreras> listacarreras) {
        this.listacarreras = listacarreras;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getRegistrocarrera2() {
        return registrocarrera2;
    }

    public void setRegistrocarrera2(int registrocarrera2) {
        this.registrocarrera2 = registrocarrera2;
    }

    public String getNombrecarrera2() {
        return nombrecarrera2;
    }

    public void setNombrecarrera2(String nombrecarrera2) {
        this.nombrecarrera2 = nombrecarrera2;
    }
    
    
    
    
    
    public void mostrarcarreras(int suc){
        listacarreras=new ArrayList();
        SqlCarreras sc=new SqlCarreras();
        List<Carreras> listacar=sc.MostrarCarreras(suc);
        Iterator<Carreras> iter=listacar.iterator();
        while (iter.hasNext()) {
            Carreras c = iter.next();
            listacarreras.add(c);
        }
        
        
    }
    
    public void registrar(int reg,int suc){
        SqlCarreras sc=new SqlCarreras();
        Carreras c=new Carreras();
        c.setCodigocarrera(codigocarrera);
        c.setNombrecarrera(nombrecarrera);
        c.setSemestrescarrera(semestrescarrera);
        c.setSucursal(suc);
        c.setUserc(reg);
        sc.InsertarCarreras(c);
        System.out.println(""+suc+reg);
        
    }
    
 
     public void actualizar(Carreras carrera,int reg){
         
       SqlCarreras su= new SqlCarreras();
       Carreras u= new Carreras();
       u.setRegistrocarrera(carrera.registrocarrera);
       u.setNombrecarrera(carrera.nombrecarrera);
        u.setCodigocarrera(carrera.codigocarrera);
         u.setSemestrescarrera(carrera.semestrescarrera);
          u.setUserm(reg);
          su.ActualizarCarreras(u);

        carrera.flag=true;
   }
     
     
    
   
   public void editar(Carreras carrera){
       carrera.flag=false;
   }
  
       public void cancelar(Carreras carrera){
        carrera.flag=true;
   }
    
}
