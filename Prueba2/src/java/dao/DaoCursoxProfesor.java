 
package dao;
 
import entities.CursoxProfesor;
import java.util.List;

public interface DaoCursoxProfesor {
    void InsertarCursoxProfesor(CursoxProfesor cursoxprofesor);
    void ActualizarCursoxProfesor(CursoxProfesor cursoxprofesor);
    List<CursoxProfesor> MostrarCursoxProfesor(int suc);
    List<CursoxProfesor> MostrarCursos(int carr,int suc,int act);
}
