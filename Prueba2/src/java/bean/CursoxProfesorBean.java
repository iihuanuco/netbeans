 
package bean;

import dao.SqlCursoxProfesor;
import dao.SqlUsers;
import entities.CursoxProfesor;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class CursoxProfesorBean {

       private CursoxProfesor cursoxprofesor=new CursoxProfesor();
       private List<SelectItem> listaprofesor;
     
    
    public CursoxProfesorBean() {
    }

    public CursoxProfesor getCursoxprofesor() {
        return cursoxprofesor;
    }

    public void setCursoxprofesor(CursoxProfesor cursoxprofesor) {
        this.cursoxprofesor = cursoxprofesor;
    }

    public List<SelectItem> getListaprofesor() {
       this.listaprofesor=new ArrayList<SelectItem>();
        SqlUsers sc=new SqlUsers();
            List<Users>  listacar=sc.MostrarProfesor();
            listaprofesor.clear();
            for (Users c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistro(),c.getNombre());
               this.listaprofesor.add(caritem);
    
            }  
        return listaprofesor;
    }
    
     
  
     public void  registrar(int reg){
         cursoxprofesor.registrar(reg);
         cursoxprofesor.setProfesor(0);
         cursoxprofesor.setCurso(0);
         cursoxprofesor.setActividad(0);
    }
    
    
    
}
