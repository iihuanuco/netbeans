
package dao;

import entities.Departamentos;
import java.util.List;

public interface DaoDepartamentos {

    void InsertarDepartamentos(Departamentos departamentos);
    void ActualizarDepartamentos(Departamentos departamentos);
    List<Departamentos> MostrarDepartamentos();
    
}
