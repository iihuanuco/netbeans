package entities;

 
import dao.SqlMatricula;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Matricula {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registromat;
    private String codigomat;
    //atributos foraneos
    private int alumno;
    private int actividad;
    private int carrera,carrera2;
    private int turno;
    private int seccion;
    private String matriculado;
    private List <Matricula> lista;
    private List <Matricula> listafiltrar;
    private boolean flag=true;

    public Matricula() {
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

    public Date getFechac() {
        return fechac;
    }

    public void setFechac(Date fechac) {
        this.fechac = fechac;
    }

    public Date getFecham() {
        return fecham;
    }

    public void setFecham(Date fecham) {
        this.fecham = fecham;
    }

    public int getRegistromat() {
        return registromat;
    }

    public void setRegistromat(int registromat) {
        this.registromat = registromat;
    }

    public String getCodigomat() {
        return codigomat;
    }

    public void setCodigomat(String codigomat) {
        this.codigomat = codigomat;
    }

    public int getAlumno() {
        return alumno;
    }

    public void setAlumno(int alumno) {
        this.alumno = alumno;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(String matriculado) {
        this.matriculado = matriculado;
    }

    public List<Matricula> getLista() {
        return lista;
    }

    public void setLista(List<Matricula> lista) {
        this.lista = lista;
    }

    public List<Matricula> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Matricula> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCarrera2() {
        return carrera2;
    }

    public void setCarrera2(int carrera2) {
        this.carrera2 = carrera2;
    }
    
    
    
    
    public void registrar(int reg,int carr,int act){
        SqlMatricula sm=new SqlMatricula();
        Matricula m=new Matricula();
        m.setAlumno(alumno);
        m.setCodigomat(codigomat);
        m.setActividad(act);
        m.setCarrera(carr);
        m.setTurno(turno);
        m.setSeccion(seccion);
        m.setUserc(reg);
        System.out.println(""+carr);
        sm.InsertarMatricula(m);
    }
    
       public void mostrar(int suc, int carr) {
        lista = new ArrayList();
        SqlMatricula pu = new SqlMatricula();
        List<Matricula> listaEmp = pu.MostrarMatricula(suc, carr);
        Iterator<Matricula> iter = listaEmp.iterator();
        while (iter.hasNext()) {
            Matricula e = iter.next();
            lista.add(e);
        }
          
    }
       
       
        public void actualizar(Matricula matricula,int reg,int suc,int carr){
           SqlMatricula sm= new SqlMatricula();
            Matricula m= new Matricula();
            m.setCodigomat(matricula.codigomat);
            m.setAlumno(matricula.alumno);
            m.setUserm(reg);
            m.setRegistromat(matricula.registromat);
            sm.ActualizarMatricula(m);
            matricula.flag=true;
            mostrar(suc, carr);
          
   }
     
     
    
   
   public void editar(Matricula matricula){
       matricula.flag=false;
   }
  
       public void cancelar(Matricula matricula){
        matricula.flag=true;
   }
    
    
}
