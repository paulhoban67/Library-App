package Domain;

import java.util.ArrayList;

public class Book {
    private int id;
    private String title;
    private ArrayList<Author> authors; //    private ArrayList<String> authors;
    private int year;
    private double price;
    private Publisher publisher;
    private String quota;

    public Book(){
        this.id=0;
        this.title="";
        this.authors=new ArrayList<Author>();
        this.year=0;
        this.price=0.0;
        this.publisher=null;
        this.quota="";
    }                                                        // implicit constructor
    public Book(int id,String title,ArrayList<Author> authors,int year,double price,Publisher publisher,String quota){
        this.id=id;
        this.title=title;
        this.authors=authors;
        this.year=year;
        this.price=price;
        this.publisher=publisher;
        this.quota=quota;
    } // constructor with parameters
    public Book(String partsBorrowedBook) {
        this.title=partsBorrowedBook;
    }   // constructor with one of parameters

    public int getId(){
        return this.id;
    }                                    // getters
    public String getTitle(){
        return this.title;
    }
    public ArrayList<Author> getAuthors(){
        return this.authors;
    }
    public int getYear(){
        return this.year;
    }
    public double getPrice(){
        return this.price;
    }
    public Publisher getPublisher(){
        return this.publisher;
    }
    public String getQuota(){
        return this.quota;
    }

    public void setId(int id){
        this.id=id;
    }                                 // setters
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthors(ArrayList<Author> authors){
        this.authors=authors;
    }
    public void setYear(int year){
        this.year=year;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public void setPublisher(Publisher publisher){
        this.publisher=publisher;
    }
    public void setQuota(String quota){
        this.quota=quota;
    }

    public String toString(){
        return "Book "+id+": "+title+" "+authors+" "+year+" "+price+" "+publisher.getName()+" "+quota;
    }                                             // Book in format to String
}
