 
package bean;

import dao.SqlUsers;
import entities.Users;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

 
@ManagedBean
@SessionScoped
public class UsersBean {
    private Users user=new Users();
    private List<SelectItem> listausuarios;
    
    public UsersBean() {
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
     
}
