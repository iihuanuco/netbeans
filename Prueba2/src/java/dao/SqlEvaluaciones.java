package dao;

import entities.Evaluaciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlEvaluaciones implements DaoEvaluaciones{

    @Override
    public void InsertarEvaluaciones(Evaluaciones evaluaciones) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into evaluaciones(nombre,userc)"
                    + " values(?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setString(1, evaluaciones.getNombreeval());
            pst.setInt(2, evaluaciones.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<Evaluaciones> MostrarEvaluaciones() {
        List<Evaluaciones> listaeval=new ArrayList<Evaluaciones>();
        try {
            Connection conn=Postgresql.conexion();
            String aql="select registro,nombre from evaluaciones";
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(aql);
            while (rs.next()) {
                Evaluaciones e=new Evaluaciones();
                e.setRegistroeval(rs.getInt(1));
                e.setNombreeval(rs.getString(2));
                
                listaeval.add(e);
            }
        } catch (Exception e) {
        }
        
        return listaeval;
    }

    
    
}
