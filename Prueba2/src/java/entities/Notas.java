package entities;

import dao.SqlNotas;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Notas {

    //variables de registro de cambios
    private int userc,userm;
    private Date fecham;
    //propios de la clase
    private int registronot,registroalumno;
    private Double notanot;
    //atributos foraneos
    private int matriculaxcurso;
    private int evaluacionxcurso;
    private String nombrealumno,codigoalumno;
        private List <Notas> lista;
        private List <Notas> filtronotas;
        boolean filtro=false;
    
    //Para Intranet alumno
    private String cursoint;
    private String profesorint;
    private String tipoevalint;
    private List<Notas> listanotas;
        
        
        
    public Notas() {
    }

    public Notas(int userc, int userm, Date fecham, int registronot, int registroalumno, Double notanot, int matriculaxcurso, int evaluacionxcurso, String nombrealumno, String codigoalumno, List<Notas> lista, List<Notas> filtronotas, String cursoint, String profesorint, String tipoevalint, List<Notas> listanotas) {
        this.userc = userc;
        this.userm = userm;
        this.fecham = fecham;
        this.registronot = registronot;
        this.registroalumno = registroalumno;
        this.notanot = notanot;
        this.matriculaxcurso = matriculaxcurso;
        this.evaluacionxcurso = evaluacionxcurso;
        this.nombrealumno = nombrealumno;
        this.codigoalumno = codigoalumno;
        this.lista = lista;
        this.filtronotas = filtronotas;
        this.cursoint = cursoint;
        this.profesorint = profesorint;
        this.tipoevalint = tipoevalint;
        this.listanotas = listanotas;
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

    public int getRegistronot() {
        return registronot;
    }

    public void setRegistronot(int registronot) {
        this.registronot = registronot;
    }

    public Double getNotanot() {
        return notanot;
    }

    public void setNotanot(Double notanot) {
        this.notanot = notanot;
    }

    public int getMatriculaxcurso() {
        return matriculaxcurso;
    }

    public void setMatriculaxcurso(int matriculaxcurso) {
        this.matriculaxcurso = matriculaxcurso;
    }

    public int getEvaluacionxcurso() {
        return evaluacionxcurso;
    }

    public void setEvaluacionxcurso(int evaluacionxcurso) {
        this.evaluacionxcurso = evaluacionxcurso;
    }

    public int getRegistroalumno() {
        return registroalumno;
    }

    public void setRegistroalumno(int registroalumno) {
        this.registroalumno = registroalumno;
    }

    public String getNombrealumno() {
        return nombrealumno;
    }

    public void setNombrealumno(String nombrealumno) {
        this.nombrealumno = nombrealumno;
    }

    public List<Notas> getLista() {
        return lista;
    }

    public void setLista(List<Notas> lista) {
        this.lista = lista;
    }

    public List<Notas> getFiltronotas() {
        return filtronotas;
    }

    public void setFiltronotas(List<Notas> filtronotas) {
        this.filtronotas = filtronotas;
    }

    public String getCodigoalumno() {
        return codigoalumno;
    }

    public void setCodigoalumno(String codigoalumno) {
        this.codigoalumno = codigoalumno;
    }

    public boolean isFiltro() {
        return filtro;
    }

    public void setFiltro(boolean filtro) {
        this.filtro = filtro;
    }

    //Para Intranet Alumno
    
    public String getCursoint() {
        return cursoint;
    }

    public void setCursoint(String cursoint) {
        this.cursoint = cursoint;
    }

    public String getProfesorint() {
        return profesorint;
    }

    public void setProfesorint(String profesorint) {
        this.profesorint = profesorint;
    }

    public String getTipoevalint() {
        return tipoevalint;
    }

    public void setTipoevalint(String tipoevalint) {
        this.tipoevalint = tipoevalint;
    }

    public List<Notas> getListanotas() {
        return listanotas;
    }

    public void setListanotas(List<Notas> listanotas) {
        this.listanotas = listanotas;
    }

    
    
    public void registrar(Notas alumnos,int reg,int evaluacion){
  
        SqlNotas sn=new SqlNotas();
        Notas n=new Notas();
        n.setMatriculaxcurso(alumnos.matriculaxcurso);
        n.setEvaluacionxcurso(evaluacion);
        n.setNotanot(alumnos.notanot);
        if(alumnos.registronot>0 ){
                
              n.setUserm(reg);
              sn.ActualizarNotas(n);
        }
        else{
            n.setUserc(reg);
            sn.InsertarNotas(n);
        }
      
    }
    
    public void mostrar(int profesor, int eva) {
        lista = new ArrayList();
        SqlNotas pu = new SqlNotas();
        List<Notas> listaCurso = pu.MostrarMatriculado(profesor, eva);
        Iterator<Notas> iter = listaCurso.iterator();
        lista.clear();
        while (iter.hasNext()) {
            Notas e = iter.next();
            lista.add(e);
        }
        filtro = true;
    }

    public void limpiar() {
        filtro = false;
    }

    public void motrarnotasint(int reg,MatriculaxCursos item){
        listanotas = new ArrayList();
        SqlNotas sn=new SqlNotas();
        List<Notas> listanotasint=sn.Mostrarnotaintranet(reg,item.getCurso());
        Iterator<Notas> iterator=listanotasint.iterator();
        listanotas.clear();
        while (iterator.hasNext()) {
            Notas n = iterator.next();
            listanotas.add(n);
        }
    }
    
    
    
    
}
