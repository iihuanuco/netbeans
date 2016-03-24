package bean;

import dao.SqlCarreras;
import entities.Carreras;
import entities.Sucursales;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class CarrerasBean {
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
        
    }
    
}
