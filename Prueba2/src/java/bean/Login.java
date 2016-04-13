 
package bean;

import dao.SqlMatriculaxCursos;
import dao.SqlUsers;
import entities.MatriculaxCursos;
import entities.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
 

@ManagedBean
@SessionScoped

public class Login implements Serializable{

    private Users user = new Users();
    public List<MatriculaxCursos> mc;

    public Login() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<MatriculaxCursos> getMc() {
        List<MatriculaxCursos> mc=new ArrayList<MatriculaxCursos>();
        SqlMatriculaxCursos sc=new SqlMatriculaxCursos();
        List<MatriculaxCursos> listacar=sc.MostrarCursosAlumno(user.getRegistro());
        Iterator<MatriculaxCursos> iter=listacar.iterator();
        while (iter.hasNext()) {
            MatriculaxCursos c = iter.next();
            mc.add(c);
        }    
        return mc;
    }

    
   
    
    
    public String validardatos(String us, String pass) {
        
        SqlUsers pu = new SqlUsers();
        List<Users> listaUsuario = pu.ValidarUsers(us, pass);
        Iterator<Users> iter = listaUsuario.iterator();
        while (iter.hasNext()) {
                                          
            Users e = iter.next();
                user.setNombre(e.getNombre());
                user.setUsuario(us);
                user.setRegistro(e.getRegistro());
                user.setNivel(e.getNivel());
                
                FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Conectado"));
                return "principal?faces-redirect=true";
   
        }
         while (iter.hasNext()==false) {
          FacesContext.getCurrentInstance().addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Datos Incorrectos"));
                return "index";
         
         }
        return null;
    }

  
    
    }