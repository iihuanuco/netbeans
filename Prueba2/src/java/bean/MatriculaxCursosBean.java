package bean;


import entities.MatriculaxCursos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
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
    
    public void registrar(int reg,int mat){
        matriculaxcursos.registrar(reg);
        matriculaxcursos.setCurso(0);
        matriculaxcursos.mostrar(mat);
    }
    
}
