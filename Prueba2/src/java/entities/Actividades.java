package entities;

import dao.SqlActividades;
import java.sql.Date;

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
    
}
