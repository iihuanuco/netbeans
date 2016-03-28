
package entities;

import dao.SqlEmpresas;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Empresas {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registroemp;
    private String nombreemp;
    private String rucemp;
    private List <Empresas> lista;
        private List <Empresas> listafiltrar;

    public Empresas() {
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

    public int getRegistroemp() {
        return registroemp;
    }

    public void setRegistroemp(int registroemp) {
        this.registroemp = registroemp;
    }

    public String getNombreemp() {
        return nombreemp;
    }

    public void setNombreemp(String nombreemp) {
        this.nombreemp = nombreemp;
    }

    public String getRucemp() {
        return rucemp;
    }

    public void setRucemp(String rucemp) {
        this.rucemp = rucemp;
    }

    public List<Empresas> getLista() {
        return lista;
    }

    public void setLista(List<Empresas> lista) {
        this.lista = lista;
    }

    public List<Empresas> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Empresas> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }
    
    
    
    public void registrar(int reg) {
        SqlEmpresas se=new SqlEmpresas();
        Empresas e=new Empresas();
        e.setNombreemp(nombreemp);
        e.setUserc(reg);
        e.setRucemp(rucemp);
        se.InsertarEmpresas(e);
    }
    
           public void mostrar() {
                lista=new ArrayList();  
                SqlEmpresas pu = new SqlEmpresas();
                List<Empresas> listaEmp = pu.MostrarEmpresas();
                Iterator<Empresas> iter = listaEmp.iterator();
                      while (iter.hasNext()) {
                          Empresas e = iter.next();
                          lista.add(e);
                      }

      }
    
}
