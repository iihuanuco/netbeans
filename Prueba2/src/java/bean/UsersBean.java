 
package bean;

import entities.Users;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

 
@ManagedBean
@SessionScoped
public class UsersBean {
private Users user=new Users();
    
    public UsersBean() {
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
          
}
