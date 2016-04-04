 
package bean;

import dao.SqlDepartamentos;
import dao.SqlProvincias;
import entities.Departamentos;
import entities.Provincias;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class DepartamentosBean {

         private Departamentos departamentos= new Departamentos();
         private List <SelectItem> listaDepartamento;
             private List <SelectItem> listaProvincias;
    
   
    public DepartamentosBean() {
    }

    public Departamentos getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(Departamentos departamentos) {
        this.departamentos = departamentos;
    }

    public List<SelectItem> getListaDepartamento() {
         this.listaDepartamento=new ArrayList<SelectItem>();
            SqlDepartamentos pu = new SqlDepartamentos();
                List<Departamentos> listaDepa = pu.MostrarDepartamentos();
                listaDepartamento.clear();
                
                for (Departamentos c: listaDepa){
                    SelectItem depitem= new SelectItem(c.getRegistrodep(),c.getNombredep());
                    this.listaDepartamento.add(depitem);
                }
                
        return listaDepartamento;
    }

    public List<SelectItem> getListaProvincias() {
         this.listaProvincias=new ArrayList<SelectItem>();
            SqlProvincias pu = new SqlProvincias();
                List<Provincias> listaPro = pu.MostrarProvincias(departamentos.getRegistrodep());
                listaProvincias.clear();
                
                for (Provincias c: listaPro){
                    SelectItem proitem= new SelectItem(c.getRegistropro(),c.getNombrepro());
                    this.listaProvincias.add(proitem);
                }
        return listaProvincias;
    }
    
      

    
    public void registrar(int reg){
        departamentos.registrar(reg);
        departamentos.setNombredep("");
        departamentos.mostrar();
    }
    
    
    
    
}
