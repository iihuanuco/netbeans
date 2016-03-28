package entities;

import dao.SqlDepartamentos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Departamentos {
    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propias de la clase
    private int registrodep;
    private String nombredep;
        private List <Departamentos> lista;
        private List <Departamentos> listafiltrar;
    

    public Departamentos() {
    }

    public Departamentos(int userc, int userm, Date fechac, Date fecham, int registrodep, String nombredep) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrodep = registrodep;
        this.nombredep = nombredep;
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

    public int getRegistrodep() {
        return registrodep;
    }

    public void setRegistrodep(int registrodep) {
        this.registrodep = registrodep;
    }

    public String getNombredep() {
        return nombredep;
    }

    public void setNombredep(String nombredep) {
        this.nombredep = nombredep;
    }

    public List<Departamentos> getLista() {
        return lista;
    }

    public void setLista(List<Departamentos> lista) {
        this.lista = lista;
    }

    public List<Departamentos> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Departamentos> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }
    
    
    
    
        public void registrar(int reg){
           SqlDepartamentos sd= new SqlDepartamentos();
            Departamentos d= new Departamentos();
            d.setNombredep(nombredep);
            d.setUserc(reg);
            sd.InsertarDepartamentos(d); 
    }  
        
           public void mostrar() {
                lista=new ArrayList();  
                SqlDepartamentos pu = new SqlDepartamentos();
                List<Departamentos> listaDepa = pu.MostrarDepartamentos();
                Iterator<Departamentos> iter = listaDepa.iterator();
                      while (iter.hasNext()) {
                          Departamentos e = iter.next();
                          lista.add(e);
                      }

      }

    
}
