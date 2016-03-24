package dao;

import entities.Evaluaciones;
import java.util.List;

public interface DaoEvaluaciones {

    void InsertarEvaluaciones(Evaluaciones evaluaciones);
    List<Evaluaciones> MostrarEvaluaciones();
    
}
