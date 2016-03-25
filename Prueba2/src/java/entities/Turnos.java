
package entities;

import dao.SqlTurnos;
import java.util.Date;

public class Turnos {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrotur;
    private int codigotur;
    private String nombretur;

    public Turnos() {
    }

    public Turnos(int userc, int userm, Date fechac, Date fecham, int registrotur, int codigotur, String nombretur) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrotur = registrotur;
        this.codigotur = codigotur;
        this.nombretur = nombretur;
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

    public int getRegistrotur() {
        return registrotur;
    }

    public void setRegistrotur(int registrotur) {
        this.registrotur = registrotur;
    }

    public int getCodigotur() {
        return codigotur;
    }

    public void setCodigotur(int codigotur) {
        this.codigotur = codigotur;
    }

    public String getNombretur() {
        return nombretur;
    }

    public void setNombretur(String nombretur) {
        this.nombretur = nombretur;
    }

    public void registrar(int reg){
        SqlTurnos st=new SqlTurnos();
        Turnos t=new Turnos();
        t.setCodigotur(codigotur);
        t.setNombretur(nombretur);
        t.setUserc(reg);
        
        st.InsertarTurnos(t);
    }
    
    
}
