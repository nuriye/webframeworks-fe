/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package managedBeans;

import domainModels.Student;
import java.io.Serializable;
import java.util.ArrayList;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
//import javax.faces.application.FacesMessage;
//import javax.faces.context.FacesContext;

/**
 *
 * @author tjasa
 */
//@Named(value = "seite1MB")
//markierung setzen und namen setzen šber welceh die managed bean ansprechbar ist
//von java classe zu einer oberflćche
@Named(value="seite1MB")

//Daten, die MB bleiben über session erhalten // bis user auf der seite ist!
//solange der browser offen hat, ind diese daten vorhanden. šbr die dauer einer sitzung.
//bis der browwer geschlossen ist->jedes mal fšllt sich savenewsutedn nach und nach fšhlt
@SessionScoped

//@requestscoped ->blieben über request-response-> daten šber einen durchlauf erhalten bleiben

//@Dependent

public class Seite1MB implements Serializable{
    
    private ArrayList<Student> allStudents;
    private int studentId;
    private String studentName;
    private String studienGang;
    private Student student;

    public Seite1MB() {
        allStudents = new ArrayList<Student>();
        for(int i=1; i<=5; i++){
            Student s = new Student(i, "Name"+i, "Studiengang"+i);
            allStudents.add(s);
        }
    }
    
        public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ArrayList<Student> getAllStudents() {
        return allStudents;
    }

    public void setAllStudents(ArrayList<Student> allStudents) {
        this.allStudents = allStudents;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudienGang() {
        return studienGang;
    }

    public void setStudienGang(String studienGang) {
        this.studienGang = studienGang;
    }
    
    public void saveNewStudent(){
        Student stud = new Student(studentId, studentName, studienGang);
        
        //aktualisierung der oberfläche
        allStudents.add(stud);
        
        //aufruf der soap server und übergabe d. studentenobjekts
    
    }
    public void deleteStudent(){
        allStudents.remove(student);
    }
    
    public void initUpdate(boolean editable){
        for(Student oneStud:allStudents){
            oneStud.setEditable(false);
        }
        student.setEditable(editable);
        //wir setzen die eigenschaft des eines objektes zu
        //auf der oberflache weiss ic dass ich studenten als inputfeld ausgeben kann->wenn er auf editable true gesetzt ist!
    }
    
        public void updateStudent(){
        student.setEditable(false);
        //setzen wir editierbarkar auf false
        int index = allStudents.indexOf(student);
        //holle mir das index
        allStudents.set(index, student);
        //setze das objekt
    }
    
    
}
