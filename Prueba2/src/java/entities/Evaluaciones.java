package entities;

import dao.SqlEvaluaciones;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Evaluaciones {

    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registroeval;
    private String nombreeval;
    private List<Evaluaciones> listaevalua;
    private List<Evaluaciones> filtroevalua;
    private boolean flag=true;

    public Evaluaciones() {
    }

    public Evaluaciones(int userc, int userm, Date fecham, int registroeval, String nombreeval) {
        this.userc = userc;
        this.userm = userm;
        this.fecham = fecham;
        this.registroeval = registroeval;
        this.nombreeval = nombreeval;
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

    public Date getFecham() {
        return fecham;
    }

    public void setFecham(Date fecham) {
        this.fecham = fecham;
    }

    public int getRegistroeval() {
        return registroeval;
    }

    public void setRegistroeval(int registroeval) {
        this.registroeval = registroeval;
    }

    public String getNombreeval() {
        return nombreeval;
    }

    public void setNombreeval(String nombreeval) {
        this.nombreeval = nombreeval;
    }

    public List<Evaluaciones> getListaevalua() {
        return listaevalua;
    }

    public void setListaevalua(List<Evaluaciones> listaevalua) {
        this.listaevalua = listaevalua;
    }

    public List<Evaluaciones> getFiltroevalua() {
        return filtroevalua;
    }

    public void setFiltroevalua(List<Evaluaciones> filtroevalua) {
        this.filtroevalua = filtroevalua;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    
    
    public void registrar(int reg){
        SqlEvaluaciones se=new SqlEvaluaciones();
        Evaluaciones e=new Evaluaciones();
        e.setNombreeval(nombreeval);
        e.setUserc(reg);
        
        se.InsertarEvaluaciones(e);
    }
    
     public void mostrarevaua(int suc){
        listaevalua=new ArrayList();
        SqlEvaluaciones sc=new SqlEvaluaciones();
        List<Evaluaciones> listacar=sc.MostrarEvaluaciones();
        Iterator<Evaluaciones> iter=listacar.iterator();
        while (iter.hasNext()) {
            Evaluaciones c = iter.next();
            listaevalua.add(c);
        }
        
        
    }
    
   
    
 
     public void actualizar(Evaluaciones evalua,int reg){
         SqlEvaluaciones se= new SqlEvaluaciones();
         Evaluaciones e= new Evaluaciones();
         e.setNombreeval(evalua.nombreeval);
         e.setRegistroeval(evalua.registroeval);
         e.setUserm(reg);
         se.ActualizarEvaluaciones(e);
        evalua.flag=true;
   }
     
     
    
   
   public void editar(Evaluaciones evalua){
       evalua.flag=false;
   }
  
       public void cancelar(Evaluaciones evalua){
        evalua.flag=true;
   }
    
    
}
