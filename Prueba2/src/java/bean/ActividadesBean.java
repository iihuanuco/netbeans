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

    
    public ActividadesBean() {
    }

    public Actividades getActividades() {
        return actividades;
    }

    public void setActividades(Actividades actividades) {
        this.actividades = actividades;
    }

  
    
    public void registrar(int reg,int suc){
        actividades.registrar(reg, suc);
        actividades.setNombreact("");
        actividades.setAlcanceact(0);
        actividades.setFechac(null);
    
    }
    
}
