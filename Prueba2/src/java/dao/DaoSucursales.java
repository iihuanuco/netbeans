
package dao;

import entities.Sucursales;
import java.util.List;

public interface DaoSucursales {

    void InsertarSucursales(Sucursales sucursales);
    List<Sucursales> MostrarSucursales();
    
}
