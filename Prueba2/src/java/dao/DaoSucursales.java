
package dao;

import entities.Sucursales;
import java.util.List;

public interface DaoSucursales {

    void InsertarSucursales(Sucursales sucursales);
    void ActualizarSucursales(Sucursales sucursales);
    List<Sucursales> MostrarSucursales();
    List<Sucursales> ListarSucursales();
    List<Sucursales> MostrarSucursales(int user);
    
}
