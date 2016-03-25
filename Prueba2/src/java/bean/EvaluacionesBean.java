package bean;

import dao.SqlEvaluaciones;
import entities.Evaluaciones;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class EvaluacionesBean {
    private Evaluaciones evaluaciones=new Evaluaciones();
    private List<SelectItem> listaevaluaciones;
    
    public EvaluacionesBean() {
    }

    public Evaluaciones getEvaluaciones() {
        return evaluaciones;
    }

    public void setEvaluaciones(Evaluaciones evaluaciones) {
        this.evaluaciones = evaluaciones;
    }

    public List<SelectItem> getListaevaluaciones() {
          this.listaevaluaciones=new ArrayList<SelectItem>();
        SqlEvaluaciones sc=new SqlEvaluaciones();
            List<Evaluaciones>  listaev=sc.MostrarEvaluaciones();
            listaevaluaciones.clear();
            for (Evaluaciones c : listaev) {
               SelectItem caritem=new SelectItem(c.getRegistroeval(),c.getNombreeval());
               this.listaevaluaciones.add(caritem);
    
            }  
        return listaevaluaciones;
    }

     
    
    public void registrar(int reg){
        evaluaciones.registrar(reg);
        evaluaciones.setNombreeval("");
    }
    
}
