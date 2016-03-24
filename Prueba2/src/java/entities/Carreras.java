package entities;

import dao.SqlCarreras;
import java.util.Date;

public class Carreras {

     //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrocarrera;
    private String codigocarrera;
    private String nombrecarrera;
    private int semestrescarrera;
    private int estadocarrera; //estado: *null=activo; !null=debaja,suspendido,etc.
    //atributo foraneo
    private int sucursal;

    public Carreras() {
    }

    public Carreras(int userc, int userm, Date fechac, Date fecham, int registrocarrera, String codigocarrera, String nombrecarrera, int semestrescarrera, int estadocarrera, int sucursal) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrocarrera = registrocarrera;
        this.codigocarrera = codigocarrera;
        this.nombrecarrera = nombrecarrera;
        this.semestrescarrera = semestrescarrera;
        this.estadocarrera = estadocarrera;
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
    
}
