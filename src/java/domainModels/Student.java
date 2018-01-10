/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModels;



/**
 *
 * @author tjasa
 */
public class Student{
    
    private int ID;
    private String Name;
    private String Studiengang;
    private boolean editable = false;
    //pro student kann ich editieren oder nicht

    public Student(int ID, String Name, String Studiengang) {
        this.ID = ID;
        this.Name = Name;
        this.Studiengang = Studiengang;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStudiengang() {
        return Studiengang;
    }

    public void setStudiengang(String Studiengang) {
        this.Studiengang = Studiengang;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }
    
    
    
    
    
}
