package dao;

import entities.Empresas;
import java.util.List;

public interface DaoEmpresas {

    void InsertarEmpresas(Empresas empresas);
    List<Empresas> MostrarEmpresas();
    
}
