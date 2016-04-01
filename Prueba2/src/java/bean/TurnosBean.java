package bean;

import dao.SqlTurnos;
import entities.Turnos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class TurnosBean {
    private Turnos turnos=new Turnos();
    private List<SelectItem> listaturnos;
    
    public TurnosBean() {
    }

    public Turnos getTurnos() {
        return turnos;
    }

    public void setTurnos(Turnos turnos) {
        this.turnos = turnos;
    }

    public List<SelectItem> getListaturnos() {
        this.listaturnos=new ArrayList<SelectItem>();
        SqlTurnos st=new SqlTurnos();
            List<Turnos> listatur=st.MostrarTurnos();
            listaturnos.clear();
            
            for (Turnos t : listatur) {
            
                SelectItem turitem=new SelectItem(t.getRegistrotur(),t.getNombretur());
                this.listaturnos.add(turitem);
            }
            
        return listaturnos;
    }
    
    public void registrar(int reg){
    turnos.registrar(reg);
    turnos.setCodigotur(0);
    turnos.setNombretur("");
    turnos.mostrartur();
    }
    
}
