
package bean;

import dao.SqlActividades;
import dao.SqlCarreras;
import dao.SqlSucursales;
import entities.Actividades;
import entities.Carreras;
import entities.Sucursales;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class SucursalesBean {

    private Sucursales sucursales=new Sucursales();
      private List <SelectItem> listaSucursales;
       List<SelectItem> listacarreras;
           private List<SelectItem> listaactividades;
    
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
    
      public List<SelectItem> getListacarreras() {
        this.listacarreras=new ArrayList<SelectItem>();
        SqlCarreras sc=new SqlCarreras();
            List<Carreras>  listacar=sc.MostrarCarreras(sucursales.getRegistrosuc());
            listacarreras.clear();
            for (Carreras c : listacar) {
            SelectItem caritem=new SelectItem(c.getRegistrocarrera(),c.getNombrecarrera());
            this.listacarreras.add(caritem);
            }   
        return listacarreras;
    }
    
         public List<SelectItem> getListaactividades() {
          this.listaactividades=new ArrayList<SelectItem>();
        SqlActividades sc=new SqlActividades();
            List<Actividades>  listaac=sc.MostrarActividades(sucursales.getRegistrosuc());
            listaactividades.clear();
            for (Actividades c : listaac) {
               SelectItem caritem=new SelectItem(c.getRegistroact(),c.getNombreact());
               this.listaactividades.add(caritem);
    
            }   
        return listaactividades;
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
