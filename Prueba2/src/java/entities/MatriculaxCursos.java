package entities;

import dao.SqlMatriculaxCursos;
import java.util.Date;

public class MatriculaxCursos {
    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registromxc;
    //atributos formareos
    private int padre; //curso anterior en caso de recuperacion
    private int matricula;
    private int curso;

    public MatriculaxCursos() {
    }

    public MatriculaxCursos(int userc, int userm, Date fecham, int registromxc, int padre, int matricula, int curso) {
        this.userc = userc;
        this.userm = userm;
        this.fecham = fecham;
        this.registromxc = registromxc;
        this.padre = padre;
        this.matricula = matricula;
        this.curso = curso;
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

    public int getRegistromxc() {
        return registromxc;
    }

    public void setRegistromxc(int registromxc) {
        this.registromxc = registromxc;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
    
    public void registrar(int reg){
        SqlMatriculaxCursos smc=new SqlMatriculaxCursos();
        MatriculaxCursos mc=new MatriculaxCursos();
        
        mc.setMatricula(matricula);
        mc.setCurso(curso);
        mc.setUserc(reg);
        
        smc.InsertarMatriculaxCursos(mc);
    
    }
    
}
