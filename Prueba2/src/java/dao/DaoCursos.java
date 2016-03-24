package dao;

import entities.Cursos;
import java.util.List;

public interface DaoCursos {

    void InsertarCursos(Cursos cursos);
    List<Cursos> MostrarCursos();
    
}
