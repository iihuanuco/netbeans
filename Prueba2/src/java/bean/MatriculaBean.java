package bean;

 
import dao.SqlUsers;
import entities.Matricula;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
 ;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@ViewScoped
public class MatriculaBean implements Serializable{
    private Matricula matricula=new Matricula();
    private List<SelectItem> listaalumnos;
     
 

    
    public MatriculaBean() {
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public List<SelectItem> getListaalumnos() {
        this.listaalumnos=new ArrayList<SelectItem>();
        SqlUsers su=new SqlUsers();
            List<Users> listaalum=su.MostrarAlumno();
            listaalumnos.clear();
            for (Users u : listaalum) {
            SelectItem alumitem=new SelectItem(u.getRegistro(), u.getNombre());
            this.listaalumnos.add(alumitem);
        }   
        return listaalumnos;
    }


    
    
    
    public void registrar(int reg,int suc,int carr){
        matricula.registrar(reg,carr);
        matricula.setAlumno(0);
        matricula.setCodigomat("");
        matricula.setActividad(0);
        matricula.setTurno(0);
        matricula.setSeccion(0);
        matricula.mostrar(suc, carr);
        
    }
    
    
}
