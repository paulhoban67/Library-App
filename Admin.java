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
public class Admin extends User {
    
    private String cod;
    private String telephone;
    
    public Admin(){
        
    }
    
    public Admin(int id, String lastName, String firstName, String cod, String username, String password, String occupation, String eMail, String telephone){
        super(id,lastName,firstName,username,password,occupation,eMail);
        this.cod = cod;
        this.telephone = telephone;
     }
     
    @Override
    public ObjectClass clone(){
        return new Admin(this.id,this.lastName,this.firstName,this.cod,this.username,this.password,this.occupation,this.eMail,this.telephone);
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }
   
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    @Override
    public String toString() {
        return "Admin" + "," + super.toString() + "," + cod + "," + telephone;
    }
    
}
