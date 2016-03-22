
package entities;

import dao.SqlProvincias;
import java.sql.Date;

public class Provincias {
    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registropro;
    private String nombrepro;
    //atributo foraneo
    private int departamento;

    public Provincias() {
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

    public int getDepartamento() {
        return departamento;
    }

    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

     public void registrar(int reg){
         SqlProvincias sp= new SqlProvincias();
         Provincias p= new Provincias();
         p.setNombrepro(nombrepro);
         p.setDepartamento(departamento);
         p.setUserc(reg);
         sp.InsertarProvincias(p);
     }
    
    
}
