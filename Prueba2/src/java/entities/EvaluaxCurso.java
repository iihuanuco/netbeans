 
package entities;

import dao.SqlEvaluaxCurso;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

 
public class EvaluaxCurso {
    private int registro,evaluacion,profesorxcurso,userc,userm;
    private String nevaluacion,nprofesorxcurso;
    private Date fecham;
    private double peso; 
    private List<EvaluaxCurso> listaexc;
    private List<EvaluaxCurso> filtroexc;
    private boolean flag=true;

    public EvaluaxCurso() {
    }

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(int evaluacion) {
        this.evaluacion = evaluacion;
    }

    public int getProfesorxcurso() {
        return profesorxcurso;
    }

    public void setProfesorxcurso(int profesorxcurso) {
        this.profesorxcurso = profesorxcurso;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getNevaluacion() {
        return nevaluacion;
    }

    public void setNevaluacion(String nevaluacion) {
        this.nevaluacion = nevaluacion;
    }

    public String getNprofesorxcurso() {
        return nprofesorxcurso;
    }

    public void setNprofesorxcurso(String nprofesorxcurso) {
        this.nprofesorxcurso = nprofesorxcurso;
    }

    public List<EvaluaxCurso> getListaexc() {
        return listaexc;
    }

    public void setListaexc(List<EvaluaxCurso> listaexc) {
        this.listaexc = listaexc;
    }

    public List<EvaluaxCurso> getFiltroexc() {
        return filtroexc;
    }

    public void setFiltroexc(List<EvaluaxCurso> filtroexc) {
        this.filtroexc = filtroexc;
    }


    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

     
    
    
    
    
    public void registrar(int reg){
        SqlEvaluaxCurso sec= new SqlEvaluaxCurso();
        EvaluaxCurso ec= new EvaluaxCurso();
        ec.setEvaluacion(evaluacion);
        ec.setProfesorxcurso(profesorxcurso);
        ec.setPeso(peso);
        ec.setUserc(reg);
        sec.InsertarEvaluaxCurso(ec);
    }

    public void mostrarexc(int suc){
        listaexc=new ArrayList();
        SqlEvaluaxCurso sc=new SqlEvaluaxCurso();
        List<EvaluaxCurso> listaex=sc.MostrarExC(suc);
        Iterator<EvaluaxCurso> iter=listaex.iterator();
        while (iter.hasNext()) {
            EvaluaxCurso c = iter.next();
            listaexc.add(c);
        }
        
        
    }
    
    
 
     public void actualizar(EvaluaxCurso exc,int reg,int suc){
         SqlEvaluaxCurso sec=new SqlEvaluaxCurso();
         EvaluaxCurso ec= new EvaluaxCurso();
         ec.setEvaluacion(exc.evaluacion);
         ec.setProfesorxcurso(exc.profesorxcurso);
         ec.setPeso(exc.peso);
         ec.setUserm(reg);
         ec.setRegistro(exc.registro);
         sec.ActualizarCurso(ec);
         mostrarexc(suc);
        exc.flag=true;
   }
     
     
    
   
   public void editar(EvaluaxCurso exc){
       exc.flag=false;
   }
  
       public void cancelar(EvaluaxCurso exc){
        exc.flag=true;
   }
    
   
    
    
}
