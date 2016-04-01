package entities;

import dao.SqlSecciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Secciones {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrosec;
    private int codigosec;
    private String nombresec;
    private List<Secciones> listasec;
    private List<Secciones> filtrosec;
    private boolean flag=true;
    

    public Secciones() {
    }

    public Secciones(int userc, int userm, Date fechac, Date fecham, int registrosec, int codigosec, String nombresec) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrosec = registrosec;
        this.codigosec = codigosec;
        this.nombresec = nombresec;
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

    public int getRegistrosec() {
        return registrosec;
    }

    public void setRegistrosec(int registrosec) {
        this.registrosec = registrosec;
    }

    public int getCodigosec() {
        return codigosec;
    }

    public void setCodigosec(int codigosec) {
        this.codigosec = codigosec;
    }

    public String getNombresec() {
        return nombresec;
    }

    public void setNombresec(String nombresec) {
        this.nombresec = nombresec;
    }

    public List<Secciones> getListasec() {
        return listasec;
    }

    public void setListasec(List<Secciones> listasec) {
        this.listasec = listasec;
    }

    public List<Secciones> getFiltrosec() {
        return filtrosec;
    }

    public void setFiltrosec(List<Secciones> filtrosec) {
        this.filtrosec = filtrosec;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
    
    public void registrar(int reg){
        SqlSecciones ss= new SqlSecciones();
        Secciones s= new Secciones();
        s.setCodigosec(codigosec);
        s.setNombresec(nombresec);
        s.setUserc(reg);
        ss.InsertarSecciones(s);
    }
    
    
     public void mostrarsec(){
        listasec=new ArrayList();
        SqlSecciones sc=new SqlSecciones();
        List<Secciones> listacar=sc.MostrarSecciones();
        Iterator<Secciones> iter=listacar.iterator();
        while (iter.hasNext()) {
            Secciones c = iter.next();
            listasec.add(c);
        }
        
        
    }
    
    
 
     public void actualizar(Secciones seccion,int reg){
         
       SqlSecciones sec= new SqlSecciones();
       Secciones s= new Secciones();
       s.setCodigosec(seccion.codigosec);
       s.setNombresec(seccion.nombresec);
       s.setUserm(reg);
       s.setRegistrosec(seccion.registrosec);
       sec.ActualizarSecciones(s);
 
        seccion.flag=true;
   }
     
     
    
   
   public void editar(Secciones seccion){
       seccion.flag=false;
   }
  
       public void cancelar(Secciones seccion){
        seccion.flag=true;
   }
    
    
    
}
