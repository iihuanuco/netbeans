package dao;

import entities.Notas;
import java.util.List;

public interface DaoNotas {

    void InsertarNotas(Notas notas);
    List<Notas> MostrarNotas();
    
}
