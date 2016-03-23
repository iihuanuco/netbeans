
package dao;

import entities.Distritos;
import java.util.List;

public interface DaoDistritos {

    void InsertarDistritos(Distritos distritos);
    List<Distritos> MostrarDistritos();
    
}
