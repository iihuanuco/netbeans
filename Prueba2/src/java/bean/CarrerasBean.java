package bean;


import dao.SqlCarreras;
import entities.Carreras; 
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class CarrerasBean {
    private Carreras carreras=new Carreras();
    private List<SelectItem> listacarreras;
    
    public CarrerasBean() {
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }

    public List<SelectItem> getListacarreras(int suc) {
        this.listacarreras=new ArrayList<SelectItem>();
        SqlCarreras sc=new SqlCarreras();
                List<Carreras> listacar=sc.MostrarCarreras(suc);
                listacarreras.clear();
                for (Carreras c : listacar) {
                    SelectItem caritem=new SelectItem(c.getCodigocarrera(), c.getNombrecarrera());
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
