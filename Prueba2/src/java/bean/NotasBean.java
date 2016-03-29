package bean;

import entities.Notas;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean
@ViewScoped
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
    
    public void registrar(Notas alumnos,int reg,int evaluacion,int profe){
       notas.registrar(alumnos,reg,evaluacion);
       notas.mostrar(profe, evaluacion);
    }
 
}
