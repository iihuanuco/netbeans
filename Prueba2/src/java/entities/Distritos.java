
package entities;

import dao.SqlDistritos;
import java.sql.Date;

public class Distritos {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrodis;
    private String nombredis;
    private String capitaldis;
    //atributo foraneo
    private int provincia;

    public Distritos() {
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

    public int getRegistrodis() {
        return registrodis;
    }

    public void setRegistrodis(int registrodis) {
        this.registrodis = registrodis;
    }

    public String getNombredis() {
        return nombredis;
    }

    public void setNombredis(String nombredis) {
        this.nombredis = nombredis;
    }

    public String getCapitaldis() {
        return capitaldis;
    }

    public void setCapitaldis(String capitaldis) {
        this.capitaldis = capitaldis;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public void registrar(int reg){
        SqlDistritos sd= new SqlDistritos();
        Distritos d= new Distritos();
        d.setNombredis(nombredis);
        d.setCapitaldis(capitaldis);
        d.setUserc(reg);
        d.setProvincia(provincia);
        sd.InsertarDistritos(d);
        
    }
     
}
