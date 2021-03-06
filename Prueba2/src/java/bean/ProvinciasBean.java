 
package bean;

import dao.SqlProvincias;
import entities.Provincias;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class ProvinciasBean implements Serializable {
        
    private Provincias provincias= new Provincias();
    private List <SelectItem> listaProvincias;

    public ProvinciasBean() {
    }

    public Provincias getProvincias() {
        return provincias;
    }

    public void setProvincias(Provincias provincias) {
        this.provincias = provincias;
    }

    public List<SelectItem> getListaProvincias() {
         this.listaProvincias=new ArrayList<SelectItem>();
            SqlProvincias pu = new SqlProvincias();
                List<Provincias> listaPro = pu.MostrarProvincias();
                listaProvincias.clear();
                
                for (Provincias c: listaPro){
                    SelectItem proitem= new SelectItem(c.getRegistropro(),c.getNombrepro());
                    this.listaProvincias.add(proitem);
                }
        return listaProvincias;
    }
    
    

    public void registrar(int reg,int dep){
    provincias.registrar(reg);
    provincias.setNombrepro("");
    provincias.mostrar(dep);
    }
    
   
    
    
    
}
