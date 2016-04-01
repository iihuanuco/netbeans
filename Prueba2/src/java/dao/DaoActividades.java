package dao;

import entities.Actividades;
import java.util.List;

public interface DaoActividades {

    void InsertarActividades(Actividades actividades);
    void ActualizarActividades(Actividades actividades);
    List<Actividades> MostrarActividades(int suc);
    
}
