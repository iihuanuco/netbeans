package dao;

import entities.Empresas;
import java.util.List;

public interface DaoEmpresas {

    void InsertarEmpresas(Empresas empresas);
    void ActualizarEmpresas(Empresas empresas);
    List<Empresas> MostrarEmpresas();
    
}
