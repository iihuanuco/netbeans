 
package bean;

import dao.SqlEvaluaciones;
import dao.SqlUsers;
import entities.CursoxProfesor;
import entities.Evaluaciones;
import entities.Users;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import util.Postgresql;

 
@ManagedBean
@ViewScoped
public class CursoxProfesorBean implements Serializable {

       private CursoxProfesor cursoxprofesor=new CursoxProfesor();
       private List<SelectItem> listaprofesor;
           private List<SelectItem> listaeva;
     
    
    public CursoxProfesorBean() {
    }

    public CursoxProfesor getCursoxprofesor() {
        return cursoxprofesor;
    }

    public void setCursoxprofesor(CursoxProfesor cursoxprofesor) {
        this.cursoxprofesor = cursoxprofesor;
    }

    public List<SelectItem> getListaprofesor() {
       this.listaprofesor=new ArrayList<SelectItem>();
        SqlUsers sc=new SqlUsers();
            List<Users>  listacar=sc.MostrarProfesor();
            listaprofesor.clear();
            for (Users c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistro(),c.getNombre());
               this.listaprofesor.add(caritem);
    
            }  
        return listaprofesor;
    }
    
        public List<SelectItem> getListaeva() {
         this.listaeva=new ArrayList<SelectItem>();
        SqlEvaluaciones su=new SqlEvaluaciones();
            List<Evaluaciones> listaev=su.MostrarEvaluaciones(cursoxprofesor.getRegistro());
            listaeva.clear();
            for (Evaluaciones u : listaev) {
                SelectItem evitem=new SelectItem(u.getRegistroeval(),u.getNombreeval());
                this.listaeva.add(evitem);
        }
        return listaeva;
    }
    
     
  
     public void  registrar(int reg,int suc,int act){
         cursoxprofesor.registrar(reg,act);
         cursoxprofesor.setProfesor(0);
         cursoxprofesor.setCurso(0);
         cursoxprofesor.setActividad(0);
         cursoxprofesor.mostrarpxc(suc);
    }
    
         public void obtener(int reg){
               cursoxprofesor.setRegistro(reg);
            }
         
    
          public void desplegarReport(String reportes) throws JRException, IOException,Exception {

        JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/report/" + reportes + ".jrxml"));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("profesor", cursoxprofesor.getPprofesor());
        byte[] reporte = null;
        reporte = JasperRunManager.runReportToPdf(report, parametros, Postgresql.conexion());
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentLength(reporte.length);
          try {
               response.getOutputStream().write(reporte, 0, reporte.length);
              response.getOutputStream().flush();
              response.getOutputStream().close();
          } catch (Exception e) {
          }
          FacesContext.getCurrentInstance().responseComplete();
          FacesContext.getCurrentInstance().renderResponse();
        

    }
         
    
}
