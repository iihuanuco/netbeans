package dao;

import entities.Secciones;
import java.util.List;

public interface DaoSecciones {
    
    void InsertarSecciones(Secciones secciones);
    void ActualizarSecciones(Secciones secciones);
    List<Secciones> MostrarSecciones();
    
}
