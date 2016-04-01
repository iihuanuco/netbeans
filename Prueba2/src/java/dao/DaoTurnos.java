package dao;

import entities.Turnos;
import java.util.List;

public interface DaoTurnos {

    void InsertarTurnos(Turnos turnos);
    void ActualizarTurnos(Turnos turnos);
    List<Turnos> MostrarTurnos();
    
}
