
package entities;

import java.sql.Date;

public class Provincias {
    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registropro;
    private String nombrepro;
    //atributo foraneo
    private Departamentos departamento;

    public Provincias() {
    }

    public Provincias(int userc, int userm, Date fechac, Date fecham, int registropro, String nombrepro, Departamentos departamento) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registropro = registropro;
        this.nombrepro = nombrepro;
        this.departamento = departamento;
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

    public int getRegistropro() {
        return registropro;
    }

    public void setRegistropro(int registropro) {
        this.registropro = registropro;
    }

    public String getNombrepro() {
        return nombrepro;
    }

    public void setNombrepro(String nombrepro) {
        this.nombrepro = nombrepro;
    }

    public Departamentos getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
    }
    
    
}
