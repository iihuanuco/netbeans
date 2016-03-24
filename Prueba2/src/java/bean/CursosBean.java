package bean;

import entities.Cursos;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class CursosBean {
    private Cursos cursos=new Cursos();
    
    public CursosBean() {
    }

    public Cursos getCursos() {
        return cursos;
    }

    public void setCursos(Cursos cursos) {
        this.cursos = cursos;
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
