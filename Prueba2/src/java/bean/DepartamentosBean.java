 
package bean;

import dao.SqlDepartamentos;
import entities.Departamentos;
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
         private Departamentos d;
   
    public DepartamentosBean() {
        d=new Departamentos();
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

    public Departamentos getD() {
        return d;
    }

    public void setD(Departamentos d) {
        this.d = d;
    }
    
    public void registrar(int reg){
        departamentos.registrar(reg);
        departamentos.setNombredep("");
    }
    
    
    
    
}
