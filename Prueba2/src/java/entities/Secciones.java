package entities;

import dao.SqlSecciones;
import java.util.Date;

public class Secciones {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrosec;
    private int codigosec;
    private String nombresec;

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
    
    
    
    public void registrar(int reg){
        SqlSecciones ss= new SqlSecciones();
        Secciones s= new Secciones();
        s.setCodigosec(codigosec);
        s.setNombresec(nombresec);
        s.setUserc(reg);
        ss.InsertarSecciones(s);
    }
    
    
}
