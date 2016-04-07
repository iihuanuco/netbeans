
package entities;

import dao.SqlEmpresas;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Empresas {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registroemp;
    private String nombreemp;
    private String rucemp;
    //otros
    private List <Empresas> lista;
    private List <Empresas> listafiltrar;
    private boolean flag=true;
    
    public Empresas() {
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

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
        lista = new ArrayList();
        SqlEmpresas pu = new SqlEmpresas();
        List<Empresas> listaEmp = pu.MostrarEmpresas();
        Iterator<Empresas> iter = listaEmp.iterator();
        while (iter.hasNext()) {
            Empresas e = iter.next();
            lista.add(e);
        }

    }
    
    public void actualizar(Empresas emp,int reg){
       SqlEmpresas se=new SqlEmpresas();
       Empresas e=new Empresas();
       
       e.setRegistroemp(emp.registroemp);
       e.setNombreemp(emp.nombreemp);
       e.setRucemp(emp.rucemp);
       e.setUserm(reg);
       
       se.ActualizarEmpresas(e);
            
       emp.flag=true;  
   }      
         
   public void editar(Empresas emp){
       emp.flag=false;
   }
  
   public void cancelar(Empresas emp){
       emp.flag=true;
   }
    
    
}
