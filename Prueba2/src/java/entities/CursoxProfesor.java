 
package entities;

import dao.SqlCursoxProfesor;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

 
public class CursoxProfesor {
   private int registro,profesor,curso,actividad,userc,userm;  
   private String ncurso,nprofesor;
   private String cursoxprofe;
   private Date fecham;
      private List <CursoxProfesor> lista;

    public CursoxProfesor() {
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

    public String getCursoxprofe() {
        return cursoxprofe;
    }

    public void setCursoxprofe(String cursoxprofe) {
        this.cursoxprofe = cursoxprofe;
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

    public void setLista(List<CursoxProfesor> lista) {
        this.lista = lista;
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
                      }
                     
      }
                                  
      
   

}
