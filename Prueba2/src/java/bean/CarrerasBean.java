package bean;

import dao.SqlCarreras;
import entities.Carreras;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class CarrerasBean {
    private Carreras carreras=new Carreras();
    List<SelectItem> listacarreras;
    
    public CarrerasBean() {
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }

    public List<SelectItem> getListacarreras() {
        this.listacarreras=new ArrayList<SelectItem>();
        SqlCarreras sc=new SqlCarreras();
            List<Carreras>  listacar=sc.MostrarCarreras();
            listacarreras.clear();
            
            for (Carreras c : listacar) {
            SelectItem caritem=new SelectItem(c.getRegistrocarrera(),c.getNombrecarrera());
            this.listacarreras.add(caritem);
            }   
        return listacarreras;
    }
    
    
    
    public void registrar(int reg,int suc){
        carreras.registrar(reg,suc);
        carreras.setCodigocarrera("");
        carreras.setNombrecarrera("");
        carreras.setSemestrescarrera(0);
        carreras.setSucursal(0);
        
    }
    
}
