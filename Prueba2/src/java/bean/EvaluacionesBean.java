package bean;

import dao.SqlEvaluaciones;
import entities.Evaluaciones;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
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
        SqlEvaluaciones se=new SqlEvaluaciones();
            List<Evaluaciones> listaeval=se.MostrarEvaluaciones();
            listaeval.clear();
            for (Evaluaciones e : listaeval) {
                SelectItem evalitem=new SelectItem(e.getRegistroeval(),e.getNombreeval());
                this.listaevaluaciones.add(evalitem);
            }
        
        return listaevaluaciones;
    }
    
    public void registrar(int reg){
        evaluaciones.registrar(reg);
        evaluaciones.setNombreeval("");
    }
    
}
