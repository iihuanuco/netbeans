
package entities;

import dao.SqlCursos;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
 

public class Cursos {

     //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrocurso;
    private String codigocurso;
    private String nombrecurso,ncarrerra;
    private int semestrecurso;
    private int creditoscurso;
    private int estadocurso; //estado: *null=activo; !null=debaja,suspendido,etc.
    private int htcurso,hpcurso;
    private int alcancecurso;
    private Date fechainiciocurso;
    //atributo foraneo
    private int carrera;
    private List<Cursos> listacursos;
    private List<Cursos> filtrocursos;
    private boolean flag=true;

   
    public Cursos() {
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

    public List<Cursos> getListacursos() {
        return listacursos;
    }

    public void setListacursos(List<Cursos> listacursos) {
        this.listacursos = listacursos;
    }

    public List<Cursos> getFiltrocursos() {
        return filtrocursos;
    }

    public void setFiltrocursos(List<Cursos> filtrocursos) {
        this.filtrocursos = filtrocursos;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getNcarrerra() {
        return ncarrerra;
    }

    public void setNcarrerra(String ncarrerra) {
        this.ncarrerra = ncarrerra;
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
    
        public void mostrarcursos(int suc){
        listacursos=new ArrayList();
        SqlCursos sc=new SqlCursos();
        List<Cursos> listacar=sc.MostrarCursos(suc);
        Iterator<Cursos> iter=listacar.iterator();
        while (iter.hasNext()) {
            Cursos c = iter.next();
            listacursos.add(c);
        }
        
    }
    
  public void actualizar(Cursos cursos,int reg,int suc){
      SqlCursos su= new SqlCursos();
      Cursos c= new  Cursos();
      c.setCodigocurso(cursos.codigocurso);
      c.setNombrecurso(cursos.nombrecurso);
      c.setSemestrecurso(cursos.semestrecurso);
      c.setCarrera(cursos.carrera);
      c.setCreditoscurso(cursos.creditoscurso);
      c.setHtcurso(cursos.htcurso);
      c.setHpcurso(cursos.hpcurso);
      c.setUserm(reg);
      c.setRegistrocurso(cursos.registrocurso);
      su.ActualizarCursos(c);
      mostrarcursos(suc);
        cursos.flag=true;
   }
     
     
    
   
   public void editar(Cursos cursos){
       cursos.flag=false;
   }
  
       public void cancelar(Cursos cursos){
        cursos.flag=true;
   }
            
      

    
    
}
