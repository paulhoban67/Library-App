/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author paulh
 */
public class Employee extends User {
    
    private String CNP;
    private String telefon;
    
    public Employee(){
        
    }
    
    public Employee(int id, String lastName, String firstName, String CNP, String username, String password, String occupation, String eMail, String telefon){
        super(id,lastName,firstName,username,password,occupation,eMail);
        this.CNP = CNP;
        this.telefon = telefon;
     }
     
    @Override
    public ObjectClass clone(){
        return new Employee(this.id,this.lastName,this.firstName,this.CNP,this.username,this.password,this.occupation,this.eMail,this.telefon);
    }
    
    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
    
    @Override
    public String toString() {
        return "Employee" + "," + super.toString() + "," + CNP + "," + telefon;
    }
    
}
