
package entities;

import dao.SqlSucursales;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Sucursales {
 
    //variables de registro de cambios
    private int userc,userm;
    private Date fechac,fecham;
    //propios de la clase
    private int registrosuc;
    private String nombresuc;
    private String direccionsuc;
    private int alcancesuc;
    private String codigomodularsuc;
    private String autorizacionsuc;
    private Date fechaautorizacionsuc;
    private String revalidacionsuc;
    private int tipodegestionsuc;
    //atributos foraneos
    private int empresa;
    private int distrito;
    private String nempresa;
    private String ndistrito;
    private List<Sucursales> lista;
     private List<Sucursales> listafiltrar;
    private List<Sucursales> lista2;
    //session
    private String nombre;
    //otros
    private boolean flag=true;
     
    public Sucursales() {
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

    public int getRegistrosuc() {
        return registrosuc;
    }

    public void setRegistrosuc(int registrosuc) {
        this.registrosuc = registrosuc;
    }

    public String getNombresuc() {
        return nombresuc;
    }

    public void setNombresuc(String nombresuc) {
        this.nombresuc = nombresuc;
    }

    public String getDireccionsuc() {
        return direccionsuc;
    }

    public void setDireccionsuc(String direccionsuc) {
        this.direccionsuc = direccionsuc;
    }

    public int getAlcancesuc() {
        return alcancesuc;
    }

    public void setAlcancesuc(int alcancesuc) {
        this.alcancesuc = alcancesuc;
    }

    public String getCodigomodularsuc() {
        return codigomodularsuc;
    }

    public void setCodigomodularsuc(String codigomodularsuc) {
        this.codigomodularsuc = codigomodularsuc;
    }

    public String getAutorizacionsuc() {
        return autorizacionsuc;
    }

    public void setAutorizacionsuc(String autorizacionsuc) {
        this.autorizacionsuc = autorizacionsuc;
    }

    public Date getFechaautorizacionsuc() {
        return fechaautorizacionsuc;
    }

    public void setFechaautorizacionsuc(Date fechaautorizacionsuc) {
        this.fechaautorizacionsuc = fechaautorizacionsuc;
    }

    public String getRevalidacionsuc() {
        return revalidacionsuc;
    }

    public void setRevalidacionsuc(String revalidacionsuc) {
        this.revalidacionsuc = revalidacionsuc;
    }

    public int getTipodegestionsuc() {
        return tipodegestionsuc;
    }

    public void setTipodegestionsuc(int tipodegestionsuc) {
        this.tipodegestionsuc = tipodegestionsuc;
    }

    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }

    public int getDistrito() {
        return distrito;
    }

    public void setDistrito(int distrito) {
        this.distrito = distrito;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    public List<Sucursales> getLista() {
        return lista;
    }

    public void setLista(List<Sucursales> lista) {
        this.lista = lista;
    }

    public List<Sucursales> getLista2() {
        return lista2;
    }

    public void setLista2(List<Sucursales> lista2) {
        this.lista2 = lista2;
    }

    public String getNempresa() {
        return nempresa;
    }

    public void setNempresa(String nempresa) {
        this.nempresa = nempresa;
    }

    public String getNdistrito() {
        return ndistrito;
    }

    public void setNdistrito(String ndistrito) {
        this.ndistrito = ndistrito;
    }

    public List<Sucursales> getListafiltrar() {
        return listafiltrar;
    }

    public void setListafiltrar(List<Sucursales> listafiltrar) {
        this.listafiltrar = listafiltrar;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    
    
    public void registrar(int reg){
        SqlSucursales ss=new SqlSucursales();
        Sucursales s=new Sucursales();
        s.setNombresuc(nombresuc);
        s.setEmpresa(empresa);
        s.setDireccionsuc(direccionsuc);
        s.setDistrito(distrito);
        s.setAlcancesuc(alcancesuc);
        s.setCodigomodularsuc(codigomodularsuc);
        s.setAutorizacionsuc(autorizacionsuc);
        s.setFechaautorizacionsuc(fechaautorizacionsuc);
        s.setRevalidacionsuc(revalidacionsuc);
        s.setTipodegestionsuc(tipodegestionsuc);
        s.setUserc(reg);
        
        ss.InsertarSucursales(s);
        
    }
    public void mostrar(){
          
         lista = new ArrayList();
         
        SqlSucursales pu = new SqlSucursales();
        List<Sucursales> listaSucur = pu.MostrarSucursales();
        Iterator<Sucursales> iter = listaSucur.iterator();
        lista.clear();
        while (iter.hasNext()) {
            Sucursales e = iter.next();
            lista.add(e);
        }

    }
    public void mostrar2(int user){
    
         lista2 = new ArrayList();
        SqlSucursales pu = new SqlSucursales();
        List<Sucursales> listaSucur = pu.MostrarSucursales(user);
        Iterator<Sucursales> iter = listaSucur.iterator();
        lista2.clear();
        while (iter.hasNext()) {
            Sucursales e = iter.next();
            lista2.add(e);
        }

    }
    
    public void obtener(int cod,String nom){
        this.registrosuc=cod;
        this.nombre=nom;
    }
    
    public void actualizar(Sucursales suc,int reg){
       SqlSucursales su=new SqlSucursales();
       Sucursales s=new Sucursales();
       
       s.setRegistrosuc(suc.registrosuc);
       s.setNombresuc(suc.nombresuc);
       s.setDireccionsuc(suc.direccionsuc);
       s.setAlcancesuc(suc.alcancesuc);
       s.setCodigomodularsuc(suc.codigomodularsuc);
       s.setTipodegestionsuc(suc.tipodegestionsuc);
       s.setUserm(reg);
       
       su.ActualizarSucursales(s);
            
       suc.flag=true;  
   }      
         
   public void editar(Sucursales suc){
       suc.flag=false;
   }
  
   public void cancelar(Sucursales suc){
       suc.flag=true;
   }
      
}
