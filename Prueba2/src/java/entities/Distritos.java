
package entities;


import dao.SqlDistritos;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

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
    //otros
    private List <Distritos> lista;
    private List <Distritos> listafiltrar;
    private boolean flag=true;

    public Distritos() {
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

    public List<Distritos> getLista() {
        return lista;
    }

    public void setLista(List<Distritos> lista) {
        this.lista = lista;
    }

    public List<Distritos> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Distritos> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
    
    public void mostrar() {
        lista = new ArrayList();
        SqlDistritos pu = new SqlDistritos();
        List<Distritos> listaDist = pu.MostrarDistritos();
        Iterator<Distritos> iter = listaDist.iterator();
        while (iter.hasNext()) {
            Distritos e = iter.next();
            lista.add(e);
        }
        
    }
    
    public void mostrar(int pro) {
        lista = new ArrayList();
        SqlDistritos pu = new SqlDistritos();
        List<Distritos> listaDist = pu.MostrarDistritos(pro);
        Iterator<Distritos> iter = listaDist.iterator();
        while (iter.hasNext()) {
            Distritos e = iter.next();
            lista.add(e);
        }
        
    }
    
    public void actualizar(Distritos dist,int reg){
       SqlDistritos sd=new SqlDistritos();
       Distritos d=new Distritos();
       
       d.setRegistrodis(dist.registrodis);
       d.setNombredis(dist.nombredis);
       d.setCapitaldis(dist.capitaldis);
       d.setUserm(reg);
       
       sd.ActualizarDistritos(d);
            
       dist.flag=true;  
   }      
         
   public void editar(Distritos dist){
       dist.flag=false;
   }
  
   public void cancelar(Distritos dist){
       dist.flag=true;
   }    
        
        
}
