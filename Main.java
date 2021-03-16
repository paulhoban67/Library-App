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
