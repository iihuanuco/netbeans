package dao;

import entities.Notas;
import entities.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.Postgresql;

public class SqlNotas implements DaoNotas{

    @Override
    public void InsertarNotas(Notas notas) {
        Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="insert into notas(matriculaxcurso,evalucionxcurso,nota,userc)"
                    + " values(?,?,?,?)";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setInt(1, notas.getMatriculaxcurso());
            pst.setInt(2, notas.getEvaluacionxcurso());
            pst.setDouble(3, notas.getNotanot());
            pst.setInt(4, notas.getUserc());
             util.util.creararchivotexto(pst.toString());
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
        
    }

    @Override
    public List<Notas> MostrarNotas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void ActualizarNotas(Notas notas) {
            Connection conn=null;
        try {
            conn=Postgresql.conexion();
            String sql="update notas set nota=?,userm=? where matriculaxcurso=? and evalucionxcurso=? ";
            
            PreparedStatement pst=null;
            pst=conn.prepareStatement(sql);
            
            pst.setDouble(1, notas.getNotanot());
            pst.setInt(2, notas.getUserm());
            pst.setInt(3, notas.getMatriculaxcurso());
            pst.setInt(4, notas.getEvaluacionxcurso());
            util.util.creararchivotexto(pst.toString());
            pst.executeUpdate();
            
            conn.close();
        } catch (Exception e) {
        }
    }

    @Override
    public List<Notas> MostrarMatriculado(int profesor, int eva) {
       List<Notas> listaalum=new ArrayList<Notas>();
        try {
            Connection conn=Postgresql.conexion();
            String sql = "with inscritos_temp as(  "
                    + "select a.registro as matriculaxcurso,b.alumno,m.codigomatricula,c.nombre from matriculaxcursos as a inner join matricula as b on a.matricula=b.registro  "
                    + "inner join users as c on b.alumno=c.registro  "
                    + "inner join matricula m on m.registro=a.matricula  "
                    + "where a.profesorxcurso="+profesor+" ),  "
                    + "notas_temp as (  "
                    + "select b.registro,a.*,coalesce(b.nota,0)::float8 as nota from inscritos_temp as a  "
                    + "left join notas as b on a.matriculaxcurso=b.matriculaxcurso and b.evalucionxcurso="+eva+")  "
                    + "select * from notas_temp;";
  
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Notas u=new Notas();
                u.setRegistronot(rs.getInt(1));
                u.setMatriculaxcurso(rs.getInt(2));
                u.setRegistroalumno(rs.getInt(3));
                u.setCodigoalumno(rs.getString(4));
                u.setNombrealumno(rs.getString(5));
                u.setNotanot(rs.getDouble(6));
                listaalum.add(u);
            }
            
        } catch (Exception e) {
        }
        
        return listaalum;
    }

    @Override
    public List<Notas> Mostrarnotaintranet(int reg) {
        List<Notas> listanotasint=new ArrayList<Notas>();
        try {
            Connection conn=Postgresql.conexion();
            String sql="select c.nombre as curso,p.nombre as profesor,e.nombre as tipoeval,n.nota from notas n " +
            "inner join matriculaxcursos mc on mc.registro=n.matriculaxcurso " +
            "inner join profesorxcursos pc on pc.registro=mc.profesorxcurso " +
            "inner join cursos c on c.registro=pc.curso " +
            "inner join users p on p.registro=pc.profesor " +
            "inner join evalucionesxcursos ec on ec.registro=n.evalucionxcurso " +
            "inner join evaluaciones e on e.registro=ec.evaluacion " +
            "inner join matricula m on m.registro=mc.matricula " +
            "inner join users a on a.registro=m.alumno " +
            "where a.registro='"+reg+"';";
            
            Statement st=conn.createStatement();
            ResultSet rs=null;
            rs=st.executeQuery(sql);
            while (rs.next()) {
                Notas n=new Notas();
                n.setCursoint(rs.getString(1));
                n.setProfesorint(rs.getString(2));
                n.setTipoevalint(rs.getString(3));
                n.setNotanot(rs.getDouble(4));
                
                listanotasint.add(n);
            }
            
        } catch (Exception e) {
        }
        return listanotasint;
    }

}
