package bean;

import entities.Carreras;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
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
    
    
    public void registrar(int reg){
        carreras.registrar(reg);
        carreras.setCodigocarrera("");
        carreras.setNombrecarrera("");
        carreras.setSemestrescarrera(0);
        carreras.setSucursal(0);
        
    }
    
}
