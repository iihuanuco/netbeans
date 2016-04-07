
package entities;

import dao.SqlProvincias;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Provincias {
    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registropro;
    private String nombrepro;
    //atributo foraneo
    private int departamento;
    //otros
    private List <Provincias> lista;
    private List <Provincias> listafiltrar;
    private boolean flag=true;
    
    
    public Provincias() {
    }
    
        public boolean filterByName(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim();
    if (filterText == null || filterText.equals("")) {
        return true;
    }

    if (value == null) {
        return false;
    }

    String Name = value.toString().toUpperCase();
    filterText = filterText.toUpperCase();

    if (Name.contains(filterText)) {
        return true;
    } else {
        return false;
    }
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

    public List<Provincias> getLista() {
        return lista;
    }

    public void setLista(List<Provincias> lista) {
        this.lista = lista;
    }

    public List<Provincias> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Provincias> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
    

     public void registrar(int reg){
         SqlProvincias sp= new SqlProvincias();
         Provincias p= new Provincias();
         p.setNombrepro(nombrepro);
         p.setDepartamento(departamento);
         p.setUserc(reg);
         sp.InsertarProvincias(p);
     }
    
    public void mostrar(int reg) {
        lista=new ArrayList();  
        SqlProvincias pu = new SqlProvincias();
        List<Provincias> listaCurso = pu.MostrarProvincias(reg);
        Iterator<Provincias> iter = listaCurso.iterator();
            while (iter.hasNext()) {
                Provincias e = iter.next();
                lista.add(e);
            }
      }
    
         
    public void actualizar(Provincias prov,int reg){
       SqlProvincias sp=new SqlProvincias();
       Provincias p=new Provincias();
       p.setRegistropro(prov.registropro);
       p.setNombrepro(prov.nombrepro);
       p.setUserm(reg);
      
       sp.ActualizarProvincias(p);
            
       prov.flag=true;  
   }      
         
   public void editar(Provincias prov){
       prov.flag=false;
   }
  
   public void cancelar(Provincias prov){
       prov.flag=true;
   }
         
}
