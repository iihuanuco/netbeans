package dao;

import entities.MatriculaxCursos;
import java.util.List;

public interface DaoMatriculaxCursos {

    void InsertarMatriculaxCursos(MatriculaxCursos matriculaxCursos);
    List<MatriculaxCursos> MostrarMatriculaxCursos(int reg);
     List<MatriculaxCursos> MostrarCursosAlumno(int reg);
    
}
