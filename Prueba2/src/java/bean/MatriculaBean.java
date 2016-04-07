package bean;

import dao.SqlMatricula;
import dao.SqlUsers;
import entities.Matricula;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

@ManagedBean
@RequestScoped
public class MatriculaBean {
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


    
    
    
    public void registrar(int reg){
        matricula.registrar(reg);
        matricula.setAlumno(0);
        matricula.setCodigomat("");
        matricula.setActividad(0);
        matricula.setCarrera(0);
        matricula.setTurno(0);
        matricula.setSeccion(0);
        
    }
    
    
}
