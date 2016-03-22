
package entities;

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
    private Provincias provincia;

    public Distritos() {
    }

    public Distritos(int userc, int userm, Date fechac, Date fecham, int registrodis, String nombredis, String capitaldis, Provincias provincia) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrodis = registrodis;
        this.nombredis = nombredis;
        this.capitaldis = capitaldis;
        this.provincia = provincia;
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

    public Provincias getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincias provincia) {
        this.provincia = provincia;
    }
      
}
