 
package dao;

import entities.Users;
import java.util.List;

 
public interface DaoUsers {
    void InsertarUsers(Users users);
    List<Users> ValidarUsers(String user, String password);
    List<Users> MostrarUsers();
    List<Users> MostrarProfesor();
    List<Users> MostrarAlumno();
    List<Users> MostrarProfesor(int reg);
    List<Users> MostrarMatriculado(int curso,int profesor,int act);
    
    List<Users> MostrarAlumnos(int suc);
    List<Users> MostrarProfesores(int suc);
    
}
