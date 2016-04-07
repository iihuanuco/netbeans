package dao;

import entities.Matricula;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlMatricula implements DaoMatricula{

    @Override
    public void InsertarMatricula(Matricula matricula) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into matricula(alumno,codigomatricula,actividad,carrera,turno,seccion,fechac,userc)"
                + " values(?,?,?,?,?,?,now(),?)";
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, matricula.getAlumno());
            pst.setString(2, matricula.getCodigomat());
            pst.setInt(3, matricula.getActividad());
            pst.setInt(4, matricula.getCarrera());
            pst.setInt(5, matricula.getTurno());
            pst.setInt(6, matricula.getSeccion());
            pst.setInt(7, matricula.getUserc());
            
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
        
    }

    @Override
    public List<Matricula> MostrarMatricula(int suc) {
           List<Matricula> listaeval=new ArrayList<Matricula>();
        try {
            Connection conn=Postgresql.conexion();
            String aql = "select m.registro,concat(u.nombre,' - ',c.nombre)  " +
"                    from matricula m " +
"                    inner join users u on u.registro=m.alumno  " +
"                    inner join carreras c on c.registro=m.carrera  " +
"                    inner join sucursales su on su.registro=c.sucursal " +
"                    where sucursal="+suc;
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(aql);
            while (rs.next()) {
                Matricula e=new Matricula();
                e.setRegistromat(rs.getInt(1));
                e.setMatriculado(rs.getString(2));
                listaeval.add(e);
            }
        } catch (Exception e) {
        }
        
        return listaeval;
    }
    
}
