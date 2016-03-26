 
package bean;

import entities.EvaluaxCurso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class EvaluaxCursoBean {
    private EvaluaxCurso evaluaxcurso= new EvaluaxCurso();

  
    public EvaluaxCursoBean() {
    }
    
       public EvaluaxCurso getEvaluaxcurso() {
        return evaluaxcurso;
    }

    public void setEvaluaxcurso(EvaluaxCurso evaluaxcurso) {
        this.evaluaxcurso = evaluaxcurso;
    }
 
    public void registrar(int reg){
     evaluaxcurso.registrar(reg);
     evaluaxcurso.setEvaluacion(0);
     evaluaxcurso.setPeso(0);
    }

    
}
