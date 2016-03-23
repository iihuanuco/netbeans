
package entities;

import dao.SqlSucursales;
import java.util.Date;

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

    public Sucursales() {
    }

    public Sucursales(int userc, int userm, Date fechac, Date fecham, int registrosuc, String nombresuc, String direccionsuc, int alcancesuc, String codigomodularsuc, String autorizacionsuc, Date fechaautorizacionsuc, String revalidacionsuc, int tipodegestionsuc, int empresa, int distrito) {
        this.userc = userc;
        this.userm = userm;
        this.fechac = fechac;
        this.fecham = fecham;
        this.registrosuc = registrosuc;
        this.nombresuc = nombresuc;
        this.direccionsuc = direccionsuc;
        this.alcancesuc = alcancesuc;
        this.codigomodularsuc = codigomodularsuc;
        this.autorizacionsuc = autorizacionsuc;
        this.fechaautorizacionsuc = fechaautorizacionsuc;
        this.revalidacionsuc = revalidacionsuc;
        this.tipodegestionsuc = tipodegestionsuc;
        this.empresa = empresa;
        this.distrito = distrito;
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
    
      
    
}
