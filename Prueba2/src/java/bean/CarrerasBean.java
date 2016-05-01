package bean;

import entities.Carreras; 
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import util.Postgresql;

@ManagedBean
@ViewScoped
public class CarrerasBean implements Serializable {
    private Carreras carreras=new Carreras();
    
    public CarrerasBean() {
    }

    public Carreras getCarreras() {
        return carreras;
    }

    public void setCarreras(Carreras carreras) {
        this.carreras = carreras;
    }
   
    public void registrar(int reg,int suc){
        carreras.registrar(reg,suc);
        carreras.setCodigocarrera("");
        carreras.setNombrecarrera("");
        carreras.setSemestrescarrera(0);
        carreras.setSucursal(0);
        carreras.mostrarcarreras(suc);
        
    }
    
    
      public void desplegarReport(String reportes) throws JRException, IOException,Exception {

        JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/report/" + reportes + ".jrxml"));
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("carrera", carreras.getPcarrera());
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
