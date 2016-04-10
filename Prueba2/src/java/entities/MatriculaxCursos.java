package entities;

import dao.SqlMatriculaxCursos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class MatriculaxCursos {
    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registromxc;
    //atributos formareos
    private int padre; //curso anterior en caso de recuperacion
    private int matricula;
    private int curso,creditos,alumno;
    private String cursos,profesor;
    private List<MatriculaxCursos> listamxc;
    private List<MatriculaxCursos> listafiltro;
 

    public MatriculaxCursos() {
    }

           public boolean filterByName(Object value, Object filter, Locale locale) {
    String filterText = (filter == null) ? null : filter.toString().trim();
    if (filterText == null || filterText.equals("")) {
        return true;
    }

    if (value == null) {
        return false;
    }

    String Name = value.toString().toUpperCase();
    filterText = filterText.toUpperCase();

    if (Name.contains(filterText)) {
        return true;
    } else {
        return false;
    }
}

    public int getUserc() {
        return userc;
    }

    public void setUserc(int userc) {
        this.userc = userc;
    }

    public int getUserm() {
        return userm;
    }

    public void setUserm(int userm) {
        this.userm = userm;
    }

    public Date getFecham() {
        return fecham;
    }

    public void setFecham(Date fecham) {
        this.fecham = fecham;
    }

    public int getRegistromxc() {
        return registromxc;
    }

    public void setRegistromxc(int registromxc) {
        this.registromxc = registromxc;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCursos() {
        return cursos;
    }

    public void setCursos(String cursos) {
        this.cursos = cursos;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public List<MatriculaxCursos> getListamxc() {
        return listamxc;
    }

    public void setListamxc(List<MatriculaxCursos> listamxc) {
        this.listamxc = listamxc;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public List<MatriculaxCursos> getListafiltro() {
        return listafiltro;
    }

    public void setListafiltro(List<MatriculaxCursos> listafiltro) {
        this.listafiltro = listafiltro;
    }

 
    
    
    public void registrar(int reg){
        SqlMatriculaxCursos smc=new SqlMatriculaxCursos();
        MatriculaxCursos mc=new MatriculaxCursos();
        mc.setMatricula(matricula);
        mc.setCurso(curso);
        mc.setUserc(reg);
        smc.InsertarMatriculaxCursos(mc);
    }
    
    public void mostrar(int reg){
          listamxc=new ArrayList();
        SqlMatriculaxCursos sc=new SqlMatriculaxCursos();
        List<MatriculaxCursos> listacar=sc.MostrarMatriculaxCursos(reg);
        Iterator<MatriculaxCursos> iter=listacar.iterator();
        while (iter.hasNext()) {
            MatriculaxCursos c = iter.next();
            listamxc.add(c);
        }
       
    }
}
    
  
