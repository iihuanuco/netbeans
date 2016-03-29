package bean;

import entities.UserxSucu;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class UserxSucuBean {

    private UserxSucu userxsucu=new UserxSucu();
  
    public UserxSucuBean() {
    }

    public UserxSucu getUserxsucu() {
        return userxsucu;
    }

    public void setUserxsucu(UserxSucu userxsucu) {
        this.userxsucu = userxsucu;
    }

    
    public void registrar(int reg){
        userxsucu.registrar(reg);
        userxsucu.setUsuario(0);
        userxsucu.setSucursal(0);
    } 
   
    
}
