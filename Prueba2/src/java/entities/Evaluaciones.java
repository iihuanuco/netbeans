package entities;

import dao.SqlEvaluaciones;
import java.util.Date;

public class Evaluaciones {

    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registroeval;
    private String nombreeval;

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
    
    public void registrar(int reg){
        SqlEvaluaciones se=new SqlEvaluaciones();
        Evaluaciones e=new Evaluaciones();
        e.setNombreeval(nombreeval);
        e.setUserc(reg);
        
        se.InsertarEvaluaciones(e);
    }
    
    
}
