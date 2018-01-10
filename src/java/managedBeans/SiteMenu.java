/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


/**
 *
 * @author tjasa
 */
@Named(value = "siteMenu")
//@Dependent //die xml installiert immer neue instanc // wird mit new site memu neu gelegt
// beim jeden aufruf neues objekt instanziert wird
@RequestScoped
//gültigkeitsbetereich der variablen dauert über eine request/response Zyklus an
public class SiteMenu {
    
    private int seitennr;

    public SiteMenu() {
    }

    public int getSeitennr() {
        return seitennr;
    }

    public void setSeitennr(int seitennr) {
        this.seitennr = seitennr;
    }
    
    
    
    //wenn methode public ist, jann uch von
    public String goToSite(int s){ 
        return "Seite" + s;
    }
    
    public String nextPage(){
        return "Seite" + seitennr;
    }
    
    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    } 
    
        public void delete() {
        addMessage("Success", "Data deleted");
    }
    
    public void addMessage(String summary, String detail) {
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
