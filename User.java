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
public class User extends ObjectClass{
    
    protected String lastName;
    protected String firstName;
    protected String username;
    protected String password;
    protected String occupation;
    protected String eMail;
    
    public User() {
       
    }
    
    public User(int id, String lastName, String firstName, String username, String password, String occupation, String eMail){
        super(id);
        this.lastName=lastName;
        this.firstName=firstName;
        this.username=username;
        this.password=password;
        this.occupation=occupation;
        this.eMail=eMail;
    }
    
    @Override
    public ObjectClass clone(){
        return new User(this.id,this.lastName,this.firstName,this.username,this.password,this.occupation,this.eMail);
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    @Override
    public String toString() {
        return super.toString() + "," + lastName + "," + firstName + "," + username + "," + password + "," + occupation + "," + eMail;
    }
}
