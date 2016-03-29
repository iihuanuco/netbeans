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
    private List<SelectItem> listaCursos;
      private List<SelectItem> listaProfesor;
    
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

    public List<SelectItem> getListaCursos() {
          this.listaCursos=new ArrayList<SelectItem>();
        SqlCursos sc=new SqlCursos();
            List<Cursos>  listacar=sc.MostrarCursos();
            listaCursos.clear();
            for (Cursos c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistrocurso(),c.getNombrecurso());
               this.listaCursos.add(caritem);
    
            }  
        return listaCursos;
    }

    public List<SelectItem> getListaProfesor() {
         this.listaProfesor=new ArrayList<SelectItem>();
        SqlUsers sc=new SqlUsers();
            List<Users>  listap=sc.MostrarProfesor(cursos.getRegistrocurso());
            listaProfesor.clear();
            for (Users c : listap) {
               SelectItem pitem=new SelectItem(c.getRegistro(),c.getNombre());
               this.listaProfesor.add(pitem);
    
            }  
        return listaProfesor;
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
