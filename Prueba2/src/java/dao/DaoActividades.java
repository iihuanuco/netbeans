package dao;

import entities.Actividades;
import java.util.List;

public interface DaoActividades {

    void InsertarActividades(Actividades actividades);
    List<Actividades> MostrarActividades();
    
}
