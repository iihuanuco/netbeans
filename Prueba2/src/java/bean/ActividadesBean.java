package bean;

import dao.SqlActividades;
import entities.Actividades;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class ActividadesBean {
    private Actividades actividades=new Actividades();
    private List<SelectItem> listaactividades;
    
    public ActividadesBean() {
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

     public List<SelectItem> getListaactividades() {
          this.listaactividades=new ArrayList<SelectItem>();
        SqlActividades sc=new SqlActividades();
            List<Actividades>  listaac=sc.MostrarActividades();
            listaactividades.clear();
            for (Actividades c : listaac) {
               SelectItem caritem=new SelectItem(c.getRegistroact(),c.getNombreact());
               this.listaactividades.add(caritem);
    
            }   
        return listaactividades;
    }
    
    public void registrar(int reg,int suc){
        actividades.registrar(reg, suc);
        actividades.setNombreact("");
        actividades.setAlcanceact(0);
        actividades.setFechac(null);
    
    }
    
}
