package bean;

import entities.Users;
import entities.UserxSucu;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserxSucuBean {

    private UserxSucu userxsucu=new UserxSucu();
    private List<Users> filtrotblalumnos=new ArrayList<Users>();
  
    public UserxSucuBean() {
    }

    public UserxSucu getUserxsucu() {
        return userxsucu;
    }

    public void setUserxsucu(UserxSucu userxsucu) {
        this.userxsucu = userxsucu;
    }

    public List<Users> getFiltrotblalumnos() {
        return filtrotblalumnos;
    }

    public void setFiltrotblalumnos(List<Users> filtrotblalumnos) {
        this.filtrotblalumnos = filtrotblalumnos;
    }
    
    
    
    public void registrar(int reg){
        userxsucu.registrar(reg);
        userxsucu.setUsuario(0);
        userxsucu.setSucursal(0);
    } 
   
    
}
