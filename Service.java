/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Domain.*;
import Repository.Repository;
import java.util.ArrayList;

/**
 *
 * @author paulh
 */
public class Service {
    
    private Repository repository;

    public Service(Repository repository) {
        this.repository = repository;
    }

    public void addAdmin(int id, String lastName, String firstName, String cod, String username, String password, String occupation, String eMail, String telephone) throws Exception {
        ObjectClass admin = new Admin(id,lastName,firstName,cod,username,password,occupation,eMail,telephone);
        this.repository.add(admin);
    }
    
    public void addEmployee(int id, String lastName, String firstName, String CNP, String username, String password, String occupation, String eMail, String telephone) throws Exception {
        ObjectClass employee = new Employee(id,lastName,firstName,CNP,username,password,occupation,eMail,telephone);
        this.repository.add(employee);
    }
    
    public void addClient(int id, String lastName, String firstName, String username, String password, String listBooksImprumutate, String listBooksDeReturnat, String occupation, String eMail) throws Exception {
        ObjectClass client = new Client(id,lastName,firstName,username,password,listBooksImprumutate,listBooksDeReturnat,occupation,eMail);
        this.repository.add(client);
    }

    public void addAuthor(int id, String lastName, String firstName, String category, int rating) throws Exception {
        ObjectClass author = new Author(id,lastName,firstName,category,rating);
        this.repository.add(author);
    }

    public void addPublisher(int id, String name, String siteWeb, String eMail, String telephone, int rating) throws Exception {
        ObjectClass publisher = new Publisher(id,name,siteWeb,eMail,telephone,rating);
        this.repository.add(publisher);
    }
    
    public ArrayList<ObjectClass> show() {
        return this.repository.getAll();
    }
}
