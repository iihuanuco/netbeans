
package bean;

import dao.SqlActividades;
import dao.SqlCarreras;
import dao.SqlCursos;
import dao.SqlCursoxProfesor;
import dao.SqlMatricula;
import dao.SqlSucursales;
import entities.Actividades;
import entities.Carreras;
import entities.Cursos;
import entities.CursoxProfesor;
import entities.Matricula;
import entities.Sucursales;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;


@ManagedBean
@SessionScoped
public class SucursalesBean implements Serializable {

    private Sucursales sucursales=new Sucursales();
      private List <SelectItem> listaSucursales;
       private List<SelectItem> listacarreras;
           private List<SelectItem> listaactividades;
                     private List<SelectItem> listaCursos;
                          private List<SelectItem> listamatriculados;
                           private List<SelectItem> cursodisponible;
                          private int codcarrera,mat;
                            private List<SelectItem> listacxp;
 
    
    public SucursalesBean() {
    }

  
    

    public int getCodcarrera() {
        return codcarrera;
    }

    public void setCodcarrera(int codcarrera) {
        this.codcarrera = codcarrera;
    }

    
    public Sucursales getSucursales() {
        return sucursales;
    }

    public void setSucursales(Sucursales sucursales) {
        this.sucursales = sucursales;
    }

    public List<SelectItem> getListaSucursales() {
          this.listaSucursales=new ArrayList<SelectItem>();
            SqlSucursales pu = new SqlSucursales();
                List<Sucursales> listaSucur = pu.MostrarSucursales();
                listaSucursales.clear();
                
                for (Sucursales c: listaSucur){
                    SelectItem depitem= new SelectItem(c.getRegistrosuc(),c.getNombresuc());
                    this.listaSucursales.add(depitem);
                }
        return listaSucursales;
    }
    
      public List<SelectItem> getListacarreras() {
        this.listacarreras=new ArrayList<SelectItem>();
        SqlCarreras sc=new SqlCarreras();
            List<Carreras>  listacar=sc.MostrarCarreras(sucursales.getRegistrosuc());
            listacarreras.clear();
            for (Carreras c : listacar) {
            SelectItem caritem=new SelectItem(c.getRegistrocarrera(),c.getNombrecarrera());
            this.listacarreras.add(caritem);
            }   
        return listacarreras;
    }
    
         public List<SelectItem> getListaactividades() {
          this.listaactividades=new ArrayList<SelectItem>();
        SqlActividades sc=new SqlActividades();
            List<Actividades>  listaac=sc.MostrarActividades(sucursales.getRegistrosuc());
            listaactividades.clear();
            for (Actividades c : listaac) {
               SelectItem caritem=new SelectItem(c.getRegistroact(),c.getNombreact());
               this.listaactividades.add(caritem);
    
            }   
        return listaactividades;
    }
         
      
          
              public List<SelectItem> getListaCursos() {
          this.listaCursos=new ArrayList<SelectItem>();
        SqlCursos sc=new SqlCursos();
            List<Cursos>  listacar=sc.MostrarCursos(sucursales.getRegistrosuc());
            listaCursos.clear();
            for (Cursos c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistrocurso(),c.getNombrecurso());
               this.listaCursos.add(caritem);
    
            }  
        return listaCursos;
    }
              
  public List<SelectItem> getListacxp() {
         this.listacxp=new ArrayList<SelectItem>();
        SqlCursoxProfesor sc=new SqlCursoxProfesor();
            List<CursoxProfesor>  listacar=sc.MostrarCursoxProfesor(sucursales.getRegistrosuc());
            listacxp.clear();
            for (CursoxProfesor c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistro(),c.getNcurso()+" - "+c.getNprofesor());
               this.listacxp.add(caritem);
    
            }  
        return listacxp;
    }
    
    public List<SelectItem> getListamatriculados() {
        
          this.listamatriculados=new ArrayList<SelectItem>();
          
        SqlMatricula sc=new SqlMatricula();
        
            List<Matricula>  listacar=sc.MostrarMatricula(sucursales.getRegistrosuc(),codcarrera);
            listamatriculados.clear();
            for (Matricula c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistromat(),c.getMatriculado());
               this.listamatriculados.add(caritem);
    
            }  
        return listamatriculados;
        
    }

    public List<SelectItem> getCursodisponible() {
         this.cursodisponible=new ArrayList<SelectItem>();
          
        SqlCursoxProfesor sc=new SqlCursoxProfesor();
            List<CursoxProfesor>  listacar=sc.MostrarCursoDisponibles(mat,sucursales.getRegistrosuc(),codcarrera);
            cursodisponible.clear();
            for (CursoxProfesor c : listacar) {
               SelectItem caritem=new SelectItem(c.getRegistro(),c.getNcurso()+" - "+c.getNprofesor());
               this.cursodisponible.add(caritem);
    
            }  
        return cursodisponible;
    }
    
    
              
    
    
    public void obtener(int carrera){
        this.codcarrera=carrera;
    }
    
       public void obtener2(int mat,int carrera){
        this.codcarrera=carrera;
        this.mat=mat;
    }
    
 
    
    
    public void registrar(int reg){
        sucursales.registrar(reg);
        sucursales.setNombresuc("");
        sucursales.setEmpresa(0);
        sucursales.setDireccionsuc("");
        sucursales.setDistrito(0);
        sucursales.setAlcancesuc(0);
        sucursales.setCodigomodularsuc("");
        sucursales.setAutorizacionsuc("");
        sucursales.setFechaautorizacionsuc(null);
        sucursales.setRevalidacionsuc("");
        sucursales.setTipodegestionsuc(0);    
        sucursales.mostrar3();
    }
    
    
    
    
    
}
