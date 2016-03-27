package entities;

import dao.SqlMatricula;
import java.util.Date;

public class Matricula {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registromat;
    private String codigomat;
    //atributos foraneos
    private int alumno;
    private int actividad;
    private int carrera;
    private int turno;
    private int seccion;
    private String matriculado;

    public Matricula() {
    }

    public Matricula(int userc, int userm, Date fechac, Date fecham, int registromat, String codigomat, int alumno, int actividad, int carrera, int turno, int seccion) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registromat = registromat;
        this.codigomat = codigomat;
        this.alumno = alumno;
        this.actividad = actividad;
        this.carrera = carrera;
        this.turno = turno;
        this.seccion = seccion;
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

    public int getRegistromat() {
        return registromat;
    }

    public void setRegistromat(int registromat) {
        this.registromat = registromat;
    }

    public String getCodigomat() {
        return codigomat;
    }

    public void setCodigomat(String codigomat) {
        this.codigomat = codigomat;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(String matriculado) {
        this.matriculado = matriculado;
    }
    
    
    public void registrar(int reg){
        SqlMatricula sm=new SqlMatricula();
        Matricula m=new Matricula();
        m.setAlumno(alumno);
        m.setCodigomat(codigomat);
        m.setActividad(actividad);
        m.setCarrera(carrera);
        m.setTurno(turno);
        m.setSeccion(seccion);
        m.setUserc(reg);
       
        sm.InsertarMatricula(m);
    }
    
}
