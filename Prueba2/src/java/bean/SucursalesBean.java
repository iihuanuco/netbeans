
package bean;

import entities.Sucursales;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class SucursalesBean {

    private Sucursales sucursales=new Sucursales();
    
    public SucursalesBean() {
    }

    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }
    
    public void registrar(int reg){
    sucursales.registrar(reg);
        
        System.out.println("registro pasado");
    
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
