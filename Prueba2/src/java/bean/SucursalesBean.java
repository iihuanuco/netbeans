
package bean;

import dao.SqlSucursales;
import entities.Sucursales;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class SucursalesBean {

    private Sucursales sucursales=new Sucursales();
      private List <SelectItem> listaSucursales;
    
    public SucursalesBean() {
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public List<SelectItem> getListaSucursales() {
          this.listaSucursales=new ArrayList<SelectItem>();
            SqlSucursales pu = new SqlSucursales();
                List<Sucursales> listaSucur = pu.MostrarSucursales();
                listaSucursales.clear();
                
                for (Sucursales c: listaSucur){
                    SelectItem depitem= new SelectItem(c.getRegistrosuc(),c.getNombresuc());
                    this.listaSucursales.add(depitem);
                }
        return listaSucursales;
    }
    
    
    
    
    public void registrar(int reg){
        sucursales.registrar(reg);
        sucursales.setNombresuc("");
        sucursales.setEmpresa(0);
        sucursales.setDireccionsuc("");
        sucursales.setDistrito(0);
        sucursales.setAlcancesuc(0);
        sucursales.setCodigomodularsuc("");
        sucursales.setAutorizacionsuc("");
        sucursales.setFechaautorizacionsuc(null);
        sucursales.setRevalidacionsuc("");
        sucursales.setTipodegestionsuc(0);     
    }
    
    
}
