 
package entities;

import dao.SqlEvaluaxCurso;
import java.util.Date;

 
public class EvaluaxCurso {
    private int registro,evaluacion,profesorxcurso,userc,userm;
    private Date fecham;
    private double peso;

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

   
    
    
    
    public void registrar(int reg){
        SqlEvaluaxCurso sec= new SqlEvaluaxCurso();
        EvaluaxCurso ec= new EvaluaxCurso();
        ec.setEvaluacion(evaluacion);
        ec.setProfesorxcurso(profesorxcurso);
        ec.setPeso(peso);
        ec.setUserc(reg);
        sec.InsertarEvaluaxCurso(ec);
    }

   
    
    
}
