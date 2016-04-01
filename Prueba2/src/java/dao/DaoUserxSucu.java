package dao;

import entities.UserxSucu;
import java.util.List;

public interface DaoUserxSucu {

    void InsertarUserxSucu(UserxSucu userxSucu);
    void ActualizarUserxSucu(UserxSucu userxSucu);
    List<UserxSucu> MostrarUserxSucu(int suc);
    
}
