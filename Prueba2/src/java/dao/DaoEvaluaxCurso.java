 
package dao;

import entities.EvaluaxCurso;
import java.util.List;

public interface DaoEvaluaxCurso {
    void InsertarEvaluaxCurso(EvaluaxCurso evaluaxcurso);
    void ActualizarCurso(EvaluaxCurso evaluaxcurso);
    List<EvaluaxCurso> MostrarExC(int suc);
 
}
