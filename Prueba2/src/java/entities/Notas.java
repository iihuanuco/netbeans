package entities;

import dao.SqlNotas;
import java.util.Date;

public class Notas {

    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registronot;
    private Double notanot;
    //atributos foraneos
    private int matriculaxcurso;
    private int evaluacionxcurso;

    public Notas() {
    }

    public Notas(int userc, int userm, Date fecham, int registronot, Double notanot, int matriculaxcurso, int evaluacionxcurso) {
        this.userc = userc;
        this.userm = userm;
        this.fecham = fecham;
        this.registronot = registronot;
        this.notanot = notanot;
        this.matriculaxcurso = matriculaxcurso;
        this.evaluacionxcurso = evaluacionxcurso;
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

    public int getRegistronot() {
        return registronot;
    }

    public void setRegistronot(int registronot) {
        this.registronot = registronot;
    }

    public Double getNotanot() {
        return notanot;
    }

    public void setNotanot(Double notanot) {
        this.notanot = notanot;
    }

    public int getMatriculaxcurso() {
        return matriculaxcurso;
    }

    public void setMatriculaxcurso(int matriculaxcurso) {
        this.matriculaxcurso = matriculaxcurso;
    }

    public int getEvaluacionxcurso() {
        return evaluacionxcurso;
    }

    public void setEvaluacionxcurso(int evaluacionxcurso) {
        this.evaluacionxcurso = evaluacionxcurso;
    }
    
    
    public void registrar(int reg){
        SqlNotas sn=new SqlNotas();
        Notas n=new Notas();
        n.setMatriculaxcurso(matriculaxcurso);
        n.setEvaluacionxcurso(evaluacionxcurso);
        n.setNotanot(notanot);
        n.setUserc(reg);
    
        sn.InsertarNotas(n);
    }
    
    
}
