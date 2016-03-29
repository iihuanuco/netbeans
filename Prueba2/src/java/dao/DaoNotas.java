package dao;

import entities.Notas;
import java.util.List;

public interface DaoNotas {

    void InsertarNotas(Notas notas);
    void ActualizarNotas(Notas notas);
    List<Notas> MostrarNotas();
    List<Notas> MostrarMatriculado(int profesor,int eva);
    
}
