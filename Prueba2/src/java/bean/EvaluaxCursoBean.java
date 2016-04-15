 
package bean;

import entities.EvaluaxCurso;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


 
@ManagedBean
@ViewScoped
public class EvaluaxCursoBean implements Serializable {
    private EvaluaxCurso evaluaxcurso= new EvaluaxCurso();

  
    public EvaluaxCursoBean() {
    }
    
       public EvaluaxCurso getEvaluaxcurso() {
        return evaluaxcurso;
    }

    public void setEvaluaxcurso(EvaluaxCurso evaluaxcurso) {
        this.evaluaxcurso = evaluaxcurso;
    }
 
    public void registrar(int reg,int suc){
     evaluaxcurso.registrar(reg);
     evaluaxcurso.setEvaluacion(0);
     evaluaxcurso.setPeso(0);
     evaluaxcurso.mostrarexc(suc);
    }

    
}
