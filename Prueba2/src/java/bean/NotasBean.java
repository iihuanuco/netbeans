package bean;

import entities.Notas;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NotasBean {
    private Notas notas=new Notas();
    
    public NotasBean() {
    }

    public Notas getNotas() {
        return notas;
    }

    public void setNotas(Notas notas) {
        this.notas = notas;
    }
    
    public void registrar(int reg){
        notas.registrar(reg);
        notas.setMatriculaxcurso(0);
        notas.setEvaluacionxcurso(0);
        notas.setNotanot(Double.NaN);
    }
    
}
