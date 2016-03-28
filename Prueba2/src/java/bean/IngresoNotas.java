/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import entities.Actividades;
import entities.Users;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author user
 */
@ManagedBean
@ViewScoped
public class IngresoNotas {
    private Actividades actividad=new Actividades();
    private Users profesor=new Users();
    
    public IngresoNotas() {
    }
    
}
