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
public class Client extends User {
    
    private String listBooksImprumutate;
    private String listBooksDeReturnat;
    
    public Client(){
        
    }
    
    public Client(int id, String lastName, String firstName, String username, String password, String listBooksImprumutate, String listBooksDeReturnat, String occupation, String eMail){
        super(id,lastName,firstName,username,password,occupation,eMail);
        this.listBooksImprumutate = listBooksImprumutate;
        this.listBooksDeReturnat = listBooksDeReturnat;
     }
     
    @Override
    public ObjectClass clone(){
        return new Client(this.id,this.lastName,this.firstName,this.username,this.password,this.listBooksImprumutate,this.listBooksDeReturnat,this.occupation,this.eMail);
    }
    
    public String getListBooksImprumutate() {
        return listBooksImprumutate;
    }

    public void setListBooksImprumutate(String listBooksImprumutate) {
        this.listBooksImprumutate = listBooksImprumutate;
    }

    public String getListBooksDeReturnat() {
        return listBooksDeReturnat;
    }

    public void setListBooksDeReturnat(String listBooksDeReturnat) {
        this.listBooksDeReturnat = listBooksDeReturnat;
    }
    
    @Override
    public String toString() {
        return "Client" + "," + super.toString() + "," + listBooksImprumutate + "," + listBooksDeReturnat;
    }
}
    

    
