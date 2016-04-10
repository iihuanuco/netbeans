package dao;

import entities.Matricula;
import java.util.List;

public interface DaoMatricula {

    void InsertarMatricula(Matricula matricula);
    void ActualizarMatricula(Matricula matricula);
    List<Matricula> MostrarMatricula(int suc,int carr);
    
}
