
package entities;

import dao.SqlTurnos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Turnos {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrotur;
    private int codigotur;
    private String nombretur;
        private List<Turnos> listaturnos;
    private List<Turnos> filtroturnos;
    private boolean flag=true;

    public Turnos() {
    }

    public Turnos(int userc, int userm, Date fechac, Date fecham, int registrotur, int codigotur, String nombretur) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrotur = registrotur;
        this.codigotur = codigotur;
        this.nombretur = nombretur;
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

    public int getRegistrotur() {
        return registrotur;
    }

    public void setRegistrotur(int registrotur) {
        this.registrotur = registrotur;
    }

    public int getCodigotur() {
        return codigotur;
    }

    public void setCodigotur(int codigotur) {
        this.codigotur = codigotur;
    }

    public String getNombretur() {
        return nombretur;
    }

    public void setNombretur(String nombretur) {
        this.nombretur = nombretur;
    }

    public List<Turnos> getListaturnos() {
        return listaturnos;
    }

    public void setListaturnos(List<Turnos> listaturnos) {
        this.listaturnos = listaturnos;
    }

    public List<Turnos> getFiltroturnos() {
        return filtroturnos;
    }

    public void setFiltroturnos(List<Turnos> filtroturnos) {
        this.filtroturnos = filtroturnos;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
    

    public void registrar(int reg){
        SqlTurnos st=new SqlTurnos();
        Turnos t=new Turnos();
        t.setCodigotur(codigotur);
        t.setNombretur(nombretur);
        t.setUserc(reg);
        
        st.InsertarTurnos(t);
    }
    
    
       public void mostrartur(){
        listaturnos=new ArrayList();
        SqlTurnos sc=new SqlTurnos();
        List<Turnos> listatur=sc.MostrarTurnos();
        Iterator<Turnos> iter=listatur.iterator();
        while (iter.hasNext()) {
            Turnos c = iter.next();
            listaturnos.add(c);
        }
        
        
    }
    
    
 
     public void actualizar(Turnos turno,int reg){
         
       SqlTurnos st= new SqlTurnos();
       Turnos t= new Turnos();
       t.setCodigotur(turno.codigotur);
       t.setNombretur(turno.nombretur);
       t.setUserm(reg);
       t.setRegistrotur(turno.registrotur);
       st.ActualizarTurnos(t);
 
        turno.flag=true;
   }
     
     
    
   
   public void editar(Turnos turno){
       turno.flag=false;
   }
  
       public void cancelar(Turnos turno){
        turno.flag=true;
   }
    
    
    
}
