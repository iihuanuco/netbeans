package dao;

import entities.Carreras;
import java.util.List;

public interface DaoCarreras {

    void InsertarCarreras(Carreras carreras);
    List<Carreras> MostrarCarreras(int suc);
    List<Carreras> MostrarSemestres(int reg);
    
    void ActualizarCarreras(Carreras carreras);
    
}
