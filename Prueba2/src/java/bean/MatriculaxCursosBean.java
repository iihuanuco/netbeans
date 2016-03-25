package bean;

import entities.MatriculaxCursos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class MatriculaxCursosBean {
    private MatriculaxCursos matriculaxcursos=new MatriculaxCursos();
    
    public MatriculaxCursosBean() {
    }

    public MatriculaxCursos getMatriculaxcursos() {
        return matriculaxcursos;
    }

    public void setMatriculaxcursos(MatriculaxCursos matriculaxcursos) {
        this.matriculaxcursos = matriculaxcursos;
    }
    
    public void registrar(int reg){
        matriculaxcursos.registrar(reg);
        matriculaxcursos.setMatricula(0);
        matriculaxcursos.setCurso(0);
    }
    
}
