
package dao;

import entities.Provincias;
import java.util.List;

public interface DaoProvincias {

    void InsertarProvincias(Provincias provincias);
    List<Provincias> MostrarProvincias();
    
    
}
