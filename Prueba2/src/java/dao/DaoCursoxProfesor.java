 
package dao;
 
import entities.CursoxProfesor;
import java.util.List;

public interface DaoCursoxProfesor {
    void InsertarCursoxProfesor(CursoxProfesor cursoxprofesor);
    List<CursoxProfesor> MostrarCursoxProfesor();
}
