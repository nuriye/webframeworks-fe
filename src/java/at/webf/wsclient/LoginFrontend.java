/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package at.webf.wsclient;


import at.ws.InputPayloadLogin;
import at.ws.OutputPayloadLogin;
import at.ws.StudyServices;
import at.ws.StudyServices_Service;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
//import javax.inject.Named;
import javax.servlet.http.HttpSession;

/**
 *
 * @author PU
 */
//@Named //Wichtig um die Klasse zum Binding für die index.xhtml Seite zu klassifizieren (Binding wird in faces-config.xml durchgeführt)
@ManagedBean(name = "loginFrontend")
public class LoginFrontend implements Serializable{
    
    //Variablen zum Binding für index.xhtml
    private String username;
    private String password;
    private Integer userid;
    private String role;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    
    
    //--------------------------------------- Container für Username & Passwort
    private InputPayloadLogin parameter;

    public InputPayloadLogin getParameter() {
        return parameter;
    }

    public void setParameter(InputPayloadLogin parameter) {
        this.parameter = parameter;
    }
    
    //---------------------------------------
    
    public String login(){ //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.
    
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();
        parameter = new InputPayloadLogin();
        
        parameter.setUsername(username);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setPassword(password);
        
        
        OutputPayloadLogin opl = port.login(parameter); //Der eigentliche Aufruf des WebServices (Synchron)
        
        String fehlerbeschreibung = opl.getFehlerbeschreibung(); //Auslesen der Resultate
        userid = opl.getUserid();
        role = opl.getRolle();
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
        // Variable für Sessions
        session.setAttribute("userid",userid);
        session.setAttribute("role",role);
                
        /*if(role.equals("lecturer")){
           return "Kursubersicht"; //Umleitung auf die Home Seite
        } else {
            return "Notenubersicht";
        }*/
        
        return "StudentHome";

    }
    
    public String logout(){
        FacesContext context = FacesContext.getCurrentInstance();
        return "loginTemplate";
    }
    
    
    public String showCourses(){ //Login-methode, wird ausgeführt wenn der Button in index.xhtml geklickt wird.
    
        StudyServices_Service service = new StudyServices_Service(); //Verbindungsaufbau zum Backend über WebServices
        StudyServices port = service.getStudyServicesPort();
        parameter = new InputPayloadLogin();
        
        parameter.setUsername(username);      //Vorbereitung der Daten welche über das WS transportiert werden sollen
        parameter.setPassword(password);
        
        
        OutputPayloadLogin opl = port.login(parameter); //Der eigentliche Aufruf des WebServices (Synchron)
        
        String fehlerbeschreibung = opl.getFehlerbeschreibung(); //Auslesen der Resultate
        userid = opl.getUserid();
        role = opl.getRolle();
        
        
        FacesContext context = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
        // Variable für Sessions
        session.setAttribute("userid",userid);
        session.setAttribute("role",role);
                
        /*if(role.equals("lecturer")){
           return "Kursubersicht"; //Umleitung auf die Home Seite
        } else {
            return "Notenubersicht";
        }*/
        
        return "Notenubersicht";
        
        
        //int x=0; //Hilfsvariablen
        //x++;
    }
}
