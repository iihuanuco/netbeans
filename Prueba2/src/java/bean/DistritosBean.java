 
package bean;

import entities.Distritos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 
@ManagedBean
@ViewScoped
public class DistritosBean {
    private Distritos distritos= new Distritos();
    
    public DistritosBean() {
      
    }

    public Distritos getDistritos() {
        return distritos;
    }

    public void setDistritos(Distritos distritos) {
        this.distritos = distritos;
    }

   
    
    
}
