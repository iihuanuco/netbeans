/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class util {
static public java.sql.Date dateutil2sql(java.util.Date fechautil){ 
    java.sql.Date sqlDate = new java.sql.Date(fechautil.getTime());
return sqlDate;    
}    

static public int getregistro(PreparedStatement preparedStatement){
        int registro=0;
        try {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next())
                registro=rs.getInt("registro");
            
        } catch (SQLException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        }
    return registro;    
    }
    
    static public ResultSet getfila(PreparedStatement preparedStatement){
    ResultSet rs=null;
        try {
            rs = preparedStatement.executeQuery();
            rs.next();
         } catch (SQLException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        } 
    return rs;
    }    
    
    static public void creararchivotexto(String s){
        try {
            PrintWriter writer;
            writer=new PrintWriter(new BufferedWriter(new FileWriter("/web/java.txt", true)));
            writer.println(s);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
