/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Repository;

import Domain.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author paulh
 */
public class Repository {
    
    protected ArrayList<ObjectClass> objects = new ArrayList<ObjectClass>();
    protected String fileName;
    
    public Repository(){
        
    }
    
    public Repository(String fileName) throws Exception {
        this.fileName = fileName;
        readFromFileCSV();
    }
    
    public ArrayList<ObjectClass> getAll() throws Exception{
        return this.objects;
    }
    
    public void add(ObjectClass object) throws Exception{
        if(objects.isEmpty())
            this.objects.add(object.clone());
        else{
            for (int i=0;i<objects.size();i++) {
            if(object.clone().getId()!=this.objects.get(i).getId()) //urmeza si get class sa pun
            {
                this.objects.add(object.clone());
                break;
            }
            else
                throw new Exception("Can't add this object");
            }
        }
        writeToFileCSV(); 
    }
    
    public void delete(ObjectClass object) throws Exception{
        int i;
        if(objects.isEmpty())
            throw new Exception("ArrayList is empty");
        else{
            for (i=0;i<objects.size();i++) {
            if(object.clone().getId()==this.objects.get(i).getId()) //urmeza si get class sa pun
            {
                this.objects.remove(i);
                break;
            }
            }
            if(i == this.objects.size())
                throw new Exception("Not find this object to delete");
        } 
        writeToFileCSV();
    }
    
    public void update(ObjectClass oldObject, ObjectClass newObject) throws Exception{
        int i;
        if(objects.isEmpty())
            throw new Exception("ArrayList is empty");   
        else{
            for (i=0;i<objects.size();i++) {
            if(oldObject.clone().getId()==this.objects.get(i).getId()) //urmeza si get class sa pun
            {
                this.objects.set(i, newObject);
                break;
            }
           }
            if(i == this.objects.size())
                throw new Exception("Not find this object to update");
        }  
        writeToFileCSV();
    }
    
    public void readFromFileCSV() throws Exception {

        try
        {
            BufferedReader fileIn = new BufferedReader(new FileReader(this.fileName));
            String line;
            while((line=fileIn.readLine())!=null) {
                String[] parts = line.split(",");
                if(parts[0].equals("Admin")) {
                    int id = Integer.parseInt(parts[1]);
                    String lastName = parts[2];
                    String firstName = parts[3];
                    String username = parts[4];
                    String password = parts[5];
                    String occupation = parts[6];
                    String eMail = parts[7];
                    String cod = parts[8];
                    String telephone = parts[9];
                    ObjectClass admin = new Admin(id,lastName,firstName,cod,username,password,occupation,eMail,telephone);
                    this.objects.add(admin.clone());
                }
                else
                    if(parts[0].equals("Client")) {
                    int id = Integer.parseInt(parts[1]);
                    String lastName = parts[2];
                    String firstName = parts[3];
                    String username = parts[4];
                    String password = parts[5];
                    String occupation = parts[6];
                    String eMail = parts[7];
                    String listBooksImprumutate = parts[8];
                    String listBooksDeReturnat = parts[9];
                    ObjectClass client = new Client(id,lastName,firstName,username,password,listBooksImprumutate,listBooksDeReturnat,occupation,eMail);
                    this.objects.add(client.clone());
                }
                else
                    if(parts[0].equals("Employee")) {
                    int id = Integer.parseInt(parts[1]);
                    String lastName = parts[2];
                    String firstName = parts[3];
                    String username = parts[4];
                    String password = parts[5];
                    String occupation = parts[6];
                    String eMail = parts[7];
                    String CNP = parts[8];
                    String telephone = parts[9];
                    ObjectClass employee = new Employee(id,lastName,firstName,CNP,username,password,occupation,eMail,telephone);
                    this.objects.add(employee.clone());
                }
            }
            fileIn.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void writeToFileCSV() throws IOException {
        
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(this.fileName));
        for(ObjectClass object : this.objects) {
            fileOut.write(object.toString());
            fileOut.write("\n");
        }
        fileOut.close();
    }
    
}
    

