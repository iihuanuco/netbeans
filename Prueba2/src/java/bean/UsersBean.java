 
package bean;

import dao.SqlEvaluaciones;
import dao.SqlUsers;
import entities.Evaluaciones;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@ViewScoped
public class UsersBean {
    private Users user=new Users();
    private List<SelectItem> listausuarios;
    private List<SelectItem> listaeva;
    @ManagedProperty("#{login}")
    private Login login;  

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public UsersBean() {
    }

    public boolean activar(){
        return (login.getUser().dentro_de(new int[] {1})>0);
    }
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

  
   
    public List<SelectItem> getListausuarios() {
        this.listausuarios=new ArrayList<SelectItem>();
        SqlUsers su=new SqlUsers();
            List<Users> listausers=su.MostrarUsers();
            listausuarios.clear();
            
            for (Users u : listausers) {
            
                SelectItem usersitem=new SelectItem(u.getRegistro(),u.getNombre());
                this.listausuarios.add(usersitem);
        }
            
        return listausuarios;
    }

    public List<SelectItem> getListaeva() {
         this.listaeva=new ArrayList<SelectItem>();
        SqlEvaluaciones su=new SqlEvaluaciones();
            List<Evaluaciones> listaev=su.MostrarEvaluaciones(user.getRegistro());
            listaeva.clear();
            for (Evaluaciones u : listaev) {
                SelectItem evitem=new SelectItem(u.getRegistroeval(),u.getNombreeval());
                this.listaeva.add(evitem);
        }
        return listaeva;
    }

   

  
    
    
    public void registrar(int reg){
        user.registrar(reg);
        user.setUsuario("");
        user.setDni("");
        user.setPassword("");
        user.setNombre("");
        user.setEmail("");
        user.setNivel(0);
    }
    
 
    
}
