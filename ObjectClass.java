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
public class ObjectClass {
    protected int id;
    
    public ObjectClass() {
        
    }

    public ObjectClass(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public ObjectClass clone() throws CloneNotSupportedException{
        return new ObjectClass(this.id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }

   
}
