 
package bean;

import dao.SqlEvaluaciones;
import dao.SqlUsers;
import entities.CursoxProfesor;
import entities.Evaluaciones;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class CursoxProfesorBean implements Serializable {

       private CursoxProfesor cursoxprofesor=new CursoxProfesor();
       private List<SelectItem> listaprofesor;
           private List<SelectItem> listaeva;
     
    
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
    
        public List<SelectItem> getListaeva() {
         this.listaeva=new ArrayList<SelectItem>();
        SqlEvaluaciones su=new SqlEvaluaciones();
            List<Evaluaciones> listaev=su.MostrarEvaluaciones(cursoxprofesor.getRegistro());
            listaeva.clear();
            for (Evaluaciones u : listaev) {
                SelectItem evitem=new SelectItem(u.getRegistroeval(),u.getNombreeval());
                this.listaeva.add(evitem);
        }
        return listaeva;
    }
    
     
  
     public void  registrar(int reg,int suc){
         cursoxprofesor.registrar(reg);
         cursoxprofesor.setProfesor(0);
         cursoxprofesor.setCurso(0);
         cursoxprofesor.setActividad(0);
         cursoxprofesor.mostrarpxc(suc);
    }
    
         public void obtener(int reg){
               cursoxprofesor.setRegistro(reg);
            }
         
    
    
}
