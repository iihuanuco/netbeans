
package entities;

import java.sql.Date;

public class user {
    
    
    private int nivel,userc,userm,registro,dni;
    private String usuario,password,nombre,email;
    private Date fechac,fecham;

    public user() {
    }

    public user(int nivel, int userc, int userm, int registro, int dni, String usuario, String password, String nombre, String email, Date fechac, Date fecham) {
        this.nivel = nivel;
        this.userc = userc;
        this.userm = userm;
        this.registro = registro;
        this.dni = dni;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.email = email;
        this.fechac = fechac;
        this.fecham = fecham;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    public int getRegistro() {
        return registro;
    }

    public void setRegistro(int registro) {
        this.registro = registro;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    
    
    
}
