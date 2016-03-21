/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.SqlUsers;
import entities.Users;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Deyvi
 */

@ManagedBean(name="login")
@SessionScoped

public class Login {
    private SqlUsers sqlu=new SqlUsers();
    private Users user=new Users();
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public SqlUsers getSqlUser() {
        return sqlu;
    }

    public void setSqlUser(SqlUsers sqlUsers) {
        this.sqlu = sqlu;
    }
    
    public String validardatos(){
        sqlu.validarDatos();
        if (user.getRegistro()>0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Acceso permitido."));
            return "principal";
        }
        
        else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Acceso denegado."));
            return "index";
        }
    
    }
    
    /*
    private Users user=new Users();
    
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
    
    public String validardatos(){
        user.validarDatos();
        if (user.getRegistro()>0) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Acceso permitido."));
            return "principal";
        }
        
        else{
            FacesContext.getCurrentInstance().addMessage(null,
            new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Acceso denegado."));
            return "index";
        }
    
    }
    */
    
    
    
}
