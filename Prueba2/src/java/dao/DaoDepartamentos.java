
package dao;

import entities.Departamentos;
import java.util.List;

public interface DaoDepartamentos {

    void InsertarDepartamentos(Departamentos departamentos);
    List<Departamentos> MostrarDepartamentos();
    
}
