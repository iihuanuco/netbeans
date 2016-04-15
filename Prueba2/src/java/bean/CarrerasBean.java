package bean;

import entities.Carreras; 
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class CarrerasBean implements Serializable {
    private Carreras carreras=new Carreras();
    
    public CarrerasBean() {
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }
   
    public void registrar(int reg,int suc){
        carreras.registrar(reg,suc);
        carreras.setCodigocarrera("");
        carreras.setNombrecarrera("");
        carreras.setSemestrescarrera(0);
        carreras.setSucursal(0);
        carreras.mostrarcarreras(suc);
        
    }
    
    
  
    
}
