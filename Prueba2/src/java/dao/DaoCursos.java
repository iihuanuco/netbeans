package dao;

import entities.Cursos;
import java.util.List;

public interface DaoCursos {

    void InsertarCursos(Cursos cursos);
    void ActualizarCursos(Cursos cursos);
    List<Cursos> MostrarCursos(int suc);
    
}
