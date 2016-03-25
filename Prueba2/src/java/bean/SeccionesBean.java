package bean;

import dao.SqlSecciones;
import entities.Secciones;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class SeccionesBean {
    private Secciones secciones=new Secciones();
    private List<SelectItem> listasecciones;
    
    public SeccionesBean() {
    }

    public Secciones getSecciones() {
        return secciones;
    }

    public void setSecciones(Secciones secciones) {
        this.secciones = secciones;
    }

    public List<SelectItem> getListasecciones() {
        this.listasecciones=new ArrayList<SelectItem>();
        SqlSecciones ss=new SqlSecciones();
            List<Secciones> listasec=ss.MostrarSecciones();
            listasecciones.clear();
            
            for (Secciones s : listasec) {
                SelectItem secitem=new SelectItem(s.getRegistrosec(),s.getNombresec());
                this.listasecciones.add(secitem);
            }
            
        return listasecciones;
    }
    
}
