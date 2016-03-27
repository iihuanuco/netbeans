
package entities;

import dao.SqlCursos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Cursos {

     //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrocurso;
    private String codigocurso;
    private String nombrecurso;
    private int semestrecurso;
    private int creditoscurso;
    private int estadocurso; //estado: *null=activo; !null=debaja,suspendido,etc.
    private int htcurso,hpcurso;
    private int alcancecurso;
    private Date fechainiciocurso;
    //atributo foraneo
    private int carrera;
       private List <Cursos> lista;

    public Cursos() {
    }

    public Cursos(int userc, int userm, Date fechac, Date fecham, int registrocurso, String codigocurso, String nombrecurso, int semestrecurso, int creditoscurso, int estadocurso, int htcurso, int hpcurso, int alcancecurso, Date fechainiciocurso, int carrera) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrocurso = registrocurso;
        this.codigocurso = codigocurso;
        this.nombrecurso = nombrecurso;
        this.semestrecurso = semestrecurso;
        this.creditoscurso = creditoscurso;
        this.estadocurso = estadocurso;
        this.htcurso = htcurso;
        this.hpcurso = hpcurso;
        this.alcancecurso = alcancecurso;
        this.fechainiciocurso = fechainiciocurso;
        this.carrera = carrera;
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

    public int getRegistrocurso() {
        return registrocurso;
    }

    public void setRegistrocurso(int registrocurso) {
        this.registrocurso = registrocurso;
    }

    public String getCodigocurso() {
        return codigocurso;
    }

    public void setCodigocurso(String codigocurso) {
        this.codigocurso = codigocurso;
    }

    public String getNombrecurso() {
        return nombrecurso;
    }

    public void setNombrecurso(String nombrecurso) {
        this.nombrecurso = nombrecurso;
    }

    public int getSemestrecurso() {
        return semestrecurso;
    }

    public void setSemestrecurso(int semestrecurso) {
        this.semestrecurso = semestrecurso;
    }

    public int getCreditoscurso() {
        return creditoscurso;
    }

    public void setCreditoscurso(int creditoscurso) {
        this.creditoscurso = creditoscurso;
    }

    public int getEstadocurso() {
        return estadocurso;
    }

    public void setEstadocurso(int estadocurso) {
        this.estadocurso = estadocurso;
    }

    public int getHtcurso() {
        return htcurso;
    }

    public void setHtcurso(int htcurso) {
        this.htcurso = htcurso;
    }

    public int getHpcurso() {
        return hpcurso;
    }

    public void setHpcurso(int hpcurso) {
        this.hpcurso = hpcurso;
    }

    public int getAlcancecurso() {
        return alcancecurso;
    }

    public void setAlcancecurso(int alcancecurso) {
        this.alcancecurso = alcancecurso;
    }

    public Date getFechainiciocurso() {
        return fechainiciocurso;
    }

    public void setFechainiciocurso(Date fechainiciocurso) {
        this.fechainiciocurso = fechainiciocurso;
    }

    public int getCarrera() {
        return carrera;
    }

    public void setCarrera(int carrera) {
        this.carrera = carrera;
    }

    public List<Cursos> getLista() {
        return lista;
    }

    public void setLista(List<Cursos> lista) {
        this.lista = lista;
    }
    
    
    
    
    public void registrar(int reg){
        SqlCursos sqlc=new SqlCursos();
        Cursos c=new Cursos();
        c.setCodigocurso(codigocurso);
        c.setNombrecurso(nombrecurso);
        c.setCarrera(carrera);
        c.setSemestrecurso(semestrecurso);
        c.setCreditoscurso(creditoscurso);
        c.setHtcurso(htcurso);
        c.setHpcurso(hpcurso);
        c.setAlcancecurso(alcancecurso);
        c.setFechainiciocurso(fechainiciocurso);
        c.setUserc(reg);
        
        sqlc.InsertarCursos(c);
    
    }
    
            public void mostrar(int carr,int suc) {
                lista=new ArrayList();  
                SqlCursos pu = new SqlCursos();
                List<Cursos> listaCurso = pu.MostrarCursos(carr, suc);
                Iterator<Cursos> iter = listaCurso.iterator();
                      while (iter.hasNext()) {
                          Cursos e = iter.next();
                          lista.add(e);
                      }

      }
            
          
            
      

    
    
}
