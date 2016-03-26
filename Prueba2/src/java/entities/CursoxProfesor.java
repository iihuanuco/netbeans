 
package entities;

import dao.SqlCursoxProfesor;
import java.util.Date;

 
public class CursoxProfesor {
   private int registro,profesor,curso,actividad,userc,userm;  
   private String cursoxprofe;
   private Date fecham;

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
    
    
   
    public void  registrar(int reg){
         SqlCursoxProfesor scp= new SqlCursoxProfesor();
         CursoxProfesor cp=new CursoxProfesor();
         cp.setProfesor(profesor);
         cp.setCurso(curso);
         cp.setActividad(actividad);
         cp.setUserc(reg);
         scp.InsertarCursoxProfesor(cp);
    }
   

}
