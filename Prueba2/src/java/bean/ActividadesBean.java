package bean;

import entities.Actividades;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ActividadesBean implements Serializable {
    
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
        actividades.mostraract(suc);
    
    }
    
      
    
    
    
}
