package dao;

import entities.Evaluaciones;
import java.util.List;

public interface DaoEvaluaciones {

      void InsertarEvaluaciones(Evaluaciones evaluaciones);
      void ActualizarEvaluaciones(Evaluaciones evaluaciones);
      List<Evaluaciones> MostrarEvaluaciones();
      List<Evaluaciones> MostrarEvaluaciones(int pro);
    
    
}
