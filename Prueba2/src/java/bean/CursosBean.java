package bean;

import dao.SqlCarreras;
import dao.SqlCursos;
import dao.SqlUsers;
import entities.Carreras;
import entities.Cursos;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class CursosBean {
    private Cursos cursos=new Cursos();
    private List<SelectItem> listaSemestres;

    
    public CursosBean() {
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
    }
    
      public List<SelectItem> getListaSemestres() {
         this.listaSemestres=new ArrayList<SelectItem>();
        SqlCarreras sc=new SqlCarreras();
            List<Carreras>  listacar=sc.MostrarSemestres(cursos.getCarrera());
            listaSemestres.clear();
            for (Carreras c : listacar) {
                for (int i = 1; i <= c.getSemestrescarrera(); i++) {
                      SelectItem caritem=new SelectItem(i,String.valueOf(i));
                  this.listaSemestres.add(caritem);
                }
          
         
            }  
        return listaSemestres;
    }



 
    
    public void registrar(int reg){
        cursos.registrar(reg);
        cursos.setCodigocurso("");
        cursos.setNombrecurso("");
        cursos.setCarrera(0);
        cursos.setSemestrecurso(0);
        cursos.setCreditoscurso(0);
        cursos.setHtcurso(0);
        cursos.setHpcurso(0);
        cursos.setAlcancecurso(0);
        cursos.setFechainiciocurso(null);
        
    }
    
}
