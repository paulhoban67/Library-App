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
public class Author extends ObjectClass {
    
    private String lastName;
    private String firstName;
    private String category;
    private int rating;
    
    public Author() {
        
    }
    
    public Author(int id, String lastName, String firstName, String category, int rating) {
       super(id);
       this.lastName = lastName;
       this.firstName = firstName;
       this.category = category;
       this.rating = rating;
    }
    
    @Override
    public ObjectClass clone() throws CloneNotSupportedException{
        return new Author(this.id,this.lastName,this.firstName,this.category,this.rating);
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Author" + " " + super.toString() + " " + lastName + " " + firstName + " " + category + " " + rating;
    }
    
}
