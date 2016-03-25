package dao;

import entities.Matricula;
import java.util.List;

public interface DaoMatricula {

    void InsertarMatricula(Matricula matricula);
    List<Matricula> MostrarMatricula();
    
}
