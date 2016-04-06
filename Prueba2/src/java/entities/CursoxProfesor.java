 
package entities;

import dao.SqlCursoxProfesor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

 
public class CursoxProfesor {
   private int registro,profesor,curso,actividad,userc,userm;  
   private String ncurso,nprofesor,nactividad,view="margin: 20% auto; text-align: center;";
   private Date fecham;
      private List <CursoxProfesor> lista;
       private List <CursoxProfesor> listapxc;
       private List<Carreras> filtropxc;
      private boolean flag=true,sw=false;

    public CursoxProfesor() {
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

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getProfesor() {
        return profesor;
    }

    public void setProfesor(int profesor) {
        this.profesor = profesor;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public int getActividad() {
        return actividad;
    }

    public void setActividad(int actividad) {
        this.actividad = actividad;
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

  

    public String getNcurso() {
        return ncurso;
    }

    public void setNcurso(String ncurso) {
        this.ncurso = ncurso;
    }

    public String getNprofesor() {
        return nprofesor;
    }

    public void setNprofesor(String nprofesor) {
        this.nprofesor = nprofesor;
    }

    public List<CursoxProfesor> getLista() {
        return lista;
    }

    public String getNactividad() {
        return nactividad;
    }

    public void setNactividad(String nactividad) {
        this.nactividad = nactividad;
    }

    
    public void setLista(List<CursoxProfesor> lista) {
        this.lista = lista;
    }

    public List<CursoxProfesor> getListapxc() {
        return listapxc;
    }

    public void setListapxc(List<CursoxProfesor> listapxc) {
        this.listapxc = listapxc;
    }

    public List<Carreras> getFiltropxc() {
        return filtropxc;
    }

    public void setFiltropxc(List<Carreras> filtropxc) {
        this.filtropxc = filtropxc;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public boolean isSw() {
        return sw;
    }

    public void setSw(boolean sw) {
        this.sw = sw;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
    
    
    
    
    
   
    public void  registrar(int reg){
         SqlCursoxProfesor scp= new SqlCursoxProfesor();
         CursoxProfesor cp=new CursoxProfesor();
         cp.setProfesor(profesor);
         cp.setCurso(curso);
         cp.setActividad(actividad);
         cp.setUserc(reg);
         scp.InsertarCursoxProfesor(cp);
    }
    
            
               public void mostrar(int carr,int suc,int act) {
                lista=new ArrayList();  
                SqlCursoxProfesor pu = new SqlCursoxProfesor();
                List<CursoxProfesor> listaCurso = pu.MostrarCursos(carr,suc,act);
                Iterator<CursoxProfesor> iter = listaCurso.iterator();
                      while (iter.hasNext()) {
                          CursoxProfesor e = iter.next();
                          lista.add(e);
                          sw=true;
                          view="margin: 20px auto; text-align: center;";
                      }
                     
      }
                       public void mostrarpxc(int suc) {
                listapxc=new ArrayList();  
                SqlCursoxProfesor pu = new SqlCursoxProfesor();
                List<CursoxProfesor> listaCxP = pu.MostrarCursoxProfesor(suc);
                Iterator<CursoxProfesor> iter = listaCxP.iterator();
                      while (iter.hasNext()) {
                          CursoxProfesor e = iter.next();
                          listapxc.add(e);
                      }
                     
      }
               
               
    public void actualizar(CursoxProfesor cxp,int reg,int suc){
        SqlCursoxProfesor scp =new SqlCursoxProfesor();
        CursoxProfesor cp= new CursoxProfesor();
        cp.setRegistro(cxp.registro);
        cp.setCurso(cxp.curso);
        cp.setProfesor(cxp.profesor);
        cp.setActividad(cxp.actividad);
        cp.setUserm(reg);
        scp.ActualizarCursoxProfesor(cp);
        cxp.flag=true;
        mostrarpxc(suc);
   }
     
     
    
   
   public void editar(CursoxProfesor cxp){
       cxp.flag=false;
   }
  
       public void cancelar(CursoxProfesor cxp){
        cxp.flag=true;
   }
                                  
      
   

}
