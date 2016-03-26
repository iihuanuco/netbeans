 
package dao;

import entities.Users;
import java.util.List;

 
public interface DaoUsers {
    void InsertarUsers(Users users);
    List<Users> ValidarUsers(String user, String password);
    List<Users> MostrarUsers();
    List<Users> MostrarProfesor();
}
