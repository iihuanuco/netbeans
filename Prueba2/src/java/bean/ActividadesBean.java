package bean;

import entities.Actividades;
import entities.Cursos;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
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
