package bean;

import entities.Matricula;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MatriculaBean {
    private Matricula matricula=new Matricula();
    
    public MatriculaBean() {
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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
