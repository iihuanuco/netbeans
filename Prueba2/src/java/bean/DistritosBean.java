 
package bean;

import dao.SqlDistritos;
import entities.Distritos;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.faces.model.SelectItem;
 
@ManagedBean
@ViewScoped
public class DistritosBean {
    private Distritos distritos= new Distritos();
    private List <SelectItem> listaDistritos;
    
    public DistritosBean() {
      
    }

    public Distritos getDistritos() {
        return distritos;
    }

    public void setDistritos(Distritos distritos) {
        this.distritos = distritos;
    }

    public void registrar(int reg,int pro){
    distritos.registrar(reg);
    distritos.setNombredis("");
    distritos.setCapitaldis("");
    distritos.mostrar(pro);
    }

    public List<SelectItem> getListaDistritos() {
        this.listaDistritos=new ArrayList<SelectItem>();
        SqlDistritos sd=new SqlDistritos();
            List<Distritos> listaDis=sd.MostrarDistritos();
            listaDistritos.clear();
            
            for (Distritos d: listaDis) {
                SelectItem disitem=new SelectItem(d.getRegistrodis(),d.getNombredis());
                this.listaDistritos.add(disitem);
            }
            
        return listaDistritos;
    }
    
}
