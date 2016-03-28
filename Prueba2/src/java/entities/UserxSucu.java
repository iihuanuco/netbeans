package entities;

import dao.SqlUsers;
import dao.SqlUserxSucu;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


public class UserxSucu {

    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrouxs;
    //atributo foraneo
    private int usuario;
    private int sucursal;
    //alumnos profesor por sucursal
    private List<Users> listaalumnos;
    private List<Users> listaprofesor;
    
    public UserxSucu() {
    }

    public UserxSucu(int userc, int userm, Date fechac, Date fecham, int registrouxs, int usuario, int sucursal, List<Users> listaalumnos, List<Users> listaprofesor) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrouxs = registrouxs;
        this.usuario = usuario;
        this.sucursal = sucursal;
        this.listaalumnos = listaalumnos;
        this.listaprofesor = listaprofesor;
    }

    
    public int getUserc() {
        return userc;
    }

    public void setUserc(int userc) {
        this.userc = userc;
    }

    public int getUserm() {
        return userm;
    }

    public void setUserm(int userm) {
        this.userm = userm;
    }

    public Date getFechac() {
        return fechac;
    }

    public void setFechac(Date fechac) {
        this.fechac = fechac;
    }

    public Date getFecham() {
        return fecham;
    }

    public void setFecham(Date fecham) {
        this.fecham = fecham;
    }

    public int getRegistrouxs() {
        return registrouxs;
    }

    public void setRegistrouxs(int registrouxs) {
        this.registrouxs = registrouxs;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public List<Users> getListaalumnos() {
        return listaalumnos;
    }

    public void setListaalumnos(List<Users> listaalumnos) {
        this.listaalumnos = listaalumnos;
    }

    public List<Users> getListaprofesor() {
        return listaprofesor;
    }

    public void setListaprofesor(List<Users> listaprofesor) {
        this.listaprofesor = listaprofesor;
    }
    
    
    
    public void registrar(int reg) {
        SqlUserxSucu sus=new SqlUserxSucu();
        UserxSucu us=new UserxSucu();
        us.setUsuario(usuario);
        us.setSucursal(sucursal);
        us.setUserc(reg);
        sus.InsertarUserxSucu(us);
    }
    
    
    public void mostraralumnos(int suc){
              listaalumnos=new ArrayList();
              SqlUsers su=new SqlUsers();
              List<Users> listaalum=su.Mmostaralumnos(suc);
              Iterator<Users> iter= listaalum.iterator();
              while (iter.hasNext()) {
                Users u = iter.next();
                listaalumnos.add(u);
                }
    }
    
    public void mostrardocentes(int suc){
              listaprofesor=new ArrayList();
              SqlUsers su=new SqlUsers();
              List<Users> listaalum=su.Mmostarprofesor(suc);
              Iterator<Users> iter= listaalum.iterator();
              while (iter.hasNext()) {
                Users u = iter.next();
                listaprofesor.add(u);
                }
    }
    
}
