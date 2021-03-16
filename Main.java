package Controller;

import Repository.AuthorArray;
import Repository.BorrowedBookArray;
import Repository.PersonArray;
import Repository.PublisherArray;
import Service.ServiceAuthors;
import Service.ServiceBook;
import Service.ServicePerson;
import Service.ServicePublisher;
import UI.UI;
import GUI.GUI;

public class Main {

    public static void main(String[] args) throws Exception {
        //______________________________________________________________________________________________________________
//        Author a1 = new Author(1,"Ion Caragiale");
//        Author a2 = new Author(2,"Ioan Slavici");
//        Author a3 = new Author(3,"Ion Creanga");
//        Author a4 = new Author(4,"Mihai Eminescu");
//        ArrayList<Author> authorArrayList = new ArrayList<Author>();
//        authorArrayList.add(a1);
//        authorArrayList.add(a2);
//        authorArrayList.add(a3);
//        authorArrayList.add(a4);
//        System.out.println(authorArrayList);
//        //______________________________________________________________________________________________________________
//        Publisher p1 = new Publisher(1,"Libris");
//        Publisher p2 = new Publisher(2,"Acarta");
//        Publisher p3 = new Publisher(3,"Litera");
//        Publisher p4 = new Publisher(4,"Enciclopedia");
//        ArrayList<Publisher> publisherArrayList = new ArrayList<Publisher>();
//        publisherArrayList.add(p1);
//        publisherArrayList.add(p2);
//        publisherArrayList.add(p3);
//        publisherArrayList.add(p4);
//        System.out.println(publisherArrayList);
        //______________________________________________________________________________________________________________
//        Book b1 = new Book(1,"Povestea lui Harap Alb",authorArrayList,2000,12.23,p1,"23R46");
//        Book b2 = new Book(2,"Baltagul",authorArrayList,1900,33,p2,"23RR6");
//        Book b3 = new Book(3,"Ion",authorArrayList,2010,12,p3,"R46");
//        ArrayList<Book> bookArrayList = new ArrayList<Book>();
//        bookArrayList.add(b1);
//        bookArrayList.add(b2);
//        bookArrayList.add(b3);
//        System.out.println(bookArrayList);
//        //______________________________________________________________________________________________________________
//        BorrowedBook bb1 = new BorrowedBook(1,"Povestea lui Harap Alb",authorArrayList,2000,12.23,p1,"23R46",true);
//        BorrowedBook bb2 = new BorrowedBook(2,"Ion",authorArrayList,2012,1.6,p2,"236",false);
//        BorrowedBook bb3 = new BorrowedBook(3,"Povesti",authorArrayList,2003,12,p3,"2R46",false);
//        ArrayList<BorrowedBook> borrowedBookArrayList = new ArrayList<BorrowedBook>();
//        borrowedBookArrayList.add(bb1);
//        borrowedBookArrayList.add(bb2);
//        borrowedBookArrayList.add(bb3);
//        System.out.println(borrowedBookArrayList);
//        //______________________________________________________________________________________________________________
//        Person pe1 = new Person(1,"Paul","5000928245045",bookArrayList,bookArrayList);
//        Person pe2 = new Person(2,"Dani","5000976543045",bookArrayList,bookArrayList);
//        Person pe3 = new Person(3,"Andrei","5000934545045",bookArrayList,bookArrayList);
//        ArrayList<Person> personArrayList = new ArrayList<Person>();
//        personArrayList.add(pe1);
//        personArrayList.add(pe2);
//        personArrayList.add(pe3);
//        System.out.println(personArrayList);
//        //______________________________________________________________________________________________________________
//        BorrowedBookArray bookArray = new BorrowedBookArray();
//        Book b4 = new Book(1,"Povestea lui Harap Alb",authorArrayList,2000,12.23,p1,"23R46");
//        Book b5 = new Book(2,"Baltagul",authorArrayList,1900,33,p2,"23RR6");
//        Book b6 = new Book(3,"Ion",authorArrayList,2010,12,p3,"R46");
//        bookArray.addBook(b4);
//        bookArray.addBook(b5);
//        bookArray.deleteBook(2);
//        bookArray.updateBook(1,b6);
//        System.out.print(bookArray.show());

        // file name of app
        String fileNameBooks = "C:\\Users\\paulh\\OneDrive\\Desktop\\Projects\\Facultate_Anul2\\Metode Avansate de Programare\\Laborator\\Lab4\\Library\\src\\Files\\Books";
        String fileNamePersons = "C:\\Users\\paulh\\OneDrive\\Desktop\\Projects\\Facultate_Anul2\\Metode Avansate de Programare\\Laborator\\Lab4\\Library\\src\\Files\\Persons";
        String fileNamePublishers = "C:\\Users\\paulh\\OneDrive\\Desktop\\Projects\\Facultate_Anul2\\Metode Avansate de Programare\\Laborator\\Lab4\\Library\\src\\Files\\Publishers";
        String fileNameAuthors = "C:\\Users\\paulh\\OneDrive\\Desktop\\Projects\\Facultate_Anul2\\Metode Avansate de Programare\\Laborator\\Lab4\\Library\\src\\Files\\Authors";

        BorrowedBookArray borrowedBookArray = new BorrowedBookArray(fileNameBooks);         // create arrays of app
        PersonArray personArray = new PersonArray(fileNamePersons);
        PublisherArray publisherArray = new PublisherArray(fileNamePublishers);
        AuthorArray authorArray = new AuthorArray(fileNameAuthors);

        ServiceBook serviceBook = new ServiceBook(borrowedBookArray);                       // create services of app
        ServicePerson servicePersons = new ServicePerson(personArray);
        ServicePublisher servicePublisher = new ServicePublisher(publisherArray);
        ServiceAuthors serviceAuthor = new ServiceAuthors(authorArray);

        GUI GUI=new GUI(serviceBook, serviceAuthor, servicePersons, servicePublisher);
        GUI.runApp();

        UI ui = new UI(serviceBook, serviceAuthor, servicePersons, servicePublisher);       // create UI of app
        ui.runApp();                                                                        // run of app


    }
}
