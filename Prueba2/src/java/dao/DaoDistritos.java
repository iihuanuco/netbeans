
package dao;

import entities.Distritos;
import java.util.List;

public interface DaoDistritos {

    void InsertarDistritos(Distritos distritos);
    void ActualizarDistritos(Distritos distritos);
    List<Distritos> MostrarDistritos();
    List<Distritos> MostrarDistritos(int pro);
    
}
