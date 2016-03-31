
package dao;

import entities.Provincias;
import java.util.List;

public interface DaoProvincias {

    void InsertarProvincias(Provincias provincias);
    void ActualizarProvincias(Provincias provincias);
    
    List<Provincias> MostrarProvincias();
    List<Provincias> MostrarProvincias(int depa);
    
    
}
