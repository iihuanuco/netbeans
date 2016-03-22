package bean;

import entities.Empresas;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

 
@ManagedBean
@ViewScoped
public class EmpresasBean {

    private Empresas empresas=new Empresas();

    public EmpresasBean() {
    }

    public Empresas getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresas empresas) {
        this.empresas = empresas;
    }
    
    public void registrar(int reg){
    empresas.registrar(reg);
    empresas.setNombreemp("");
    empresas.setRucemp("");
    }
    
    
}
