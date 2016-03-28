package bean;

import dao.SqlEmpresas;
import entities.Empresas;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.util.List;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class EmpresasBean {

    private Empresas empresas=new Empresas();
    private List<SelectItem> listaEmpresas;
    
    public EmpresasBean() {
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }

    public List<SelectItem> getListaEmpresas() {
        this.listaEmpresas=new ArrayList<SelectItem>();
        SqlEmpresas se=new SqlEmpresas();
            List<Empresas> listaEmp=se.MostrarEmpresas();
            listaEmpresas.clear();
            
            for (Empresas e : listaEmp) {
                SelectItem empitem=new SelectItem(e.getRegistroemp(), e.getNombreemp());
                this.listaEmpresas.add(empitem);
            }
            
        return listaEmpresas;
    }
       
    
    public void registrar(int reg){
    empresas.registrar(reg);
    empresas.setNombreemp("");
    empresas.setRucemp("");
     empresas.mostrar();
    }
    
    
}
