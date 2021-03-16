package UI;

import Domain.*;
import Service.ServiceAuthors;
import Service.ServiceBook;
import Service.ServicePerson;
import Service.ServicePublisher;
import java.util.*;

public class UI {
    private final ServiceBook serviceBooks;
    private final ServiceAuthors serviceAuthor;
    private final ServicePerson servicePersons;
    private final ServicePublisher servicePublisher;

    public UI(ServiceBook serviceBooks, ServiceAuthors serviceAuthor, ServicePerson servicePersons, ServicePublisher servicePublisher) {
        this.serviceBooks = serviceBooks;
        this.serviceAuthor = serviceAuthor;
        this.servicePersons = servicePersons;
        this.servicePublisher = servicePublisher;
    } // constructor with parameters

    private void addBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,title,listAuthors(;),year,price,publisher,quota");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String[] partsAuthors=parts[2].split(";");
            ArrayList<Author> authors = new ArrayList<Author>();
            for (String partsAuthor : partsAuthors) {
                Author author = new Author(1, partsAuthor);
                authors.add(author);
            }
            int year = Integer.parseInt(parts[3]);
            double price = Double.parseDouble(parts[4]);
            String publisher = parts[5];
            Publisher p = new Publisher(1, publisher);
            String quota = parts[6];

            serviceBooks.addBook(id, title, authors, year, price, p, quota, false);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            addBook();
        }
    }                                  // add book
    private void updateBook() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,title,listAuthors(;),year,price,publisher,quota,borrowed(true/false)");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String title = parts[1];
            String[] partsAuthors = parts[2].split(";");
            ArrayList<Author> authors = new ArrayList<Author>();
            for (String partsAuthor : partsAuthors) {
                Author author = new Author(1, partsAuthor);
                authors.add(author);
            }
            int year = Integer.parseInt(parts[3]);
            double price = Double.parseDouble(parts[4]);
            String publisher = parts[5];
            Publisher p = new Publisher(1, publisher);  //cauta sevice id ul publisherului
            String quota = parts[6];
//            String borrowed = parts[7];
            boolean b = Boolean.parseBoolean(parts[7]);
//            if (borrowed.equals("0"))
//                b = false;
//            else if (borrowed.equals("1"))
//                b = true;

            serviceBooks.updateBook(id, title, authors, year, price, p, quota, b);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            updateBook();
        }
    }                               // update book
    private void deleteBook() {
        try {
            System.out.println("Care carte delete? ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            serviceBooks.deleteBook(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            deleteBook();
        }
    }                               // delete book
    private void showBook(){
        headBook();
        ArrayList<BorrowedBook> borrowedList = new ArrayList<BorrowedBook>(serviceBooks.showBook());
        for (BorrowedBook borrowedBook : borrowedList) {
            if (borrowedBook.getAuthors().size() == 1) {
                String borrowed;
                if (borrowedBook.getBorrowed()) {
                    borrowed = "imprumutata";
                } else {
                    borrowed = "neimprumutata";
                }
                System.out.format("|%4d| %-23s| %-24s|%-6s| %-6s| %-15s| %-6s| %-13s|\n", borrowedBook.getId(),
                        borrowedBook.getTitle(), borrowedBook.getAuthors().get(0).getName(), borrowedBook.getYear(),
                        borrowedBook.getPrice(), borrowedBook.getPublisher().getName(), borrowedBook.getQuota(),
                        borrowed);
            } else {
                String borrowed;
                if (borrowedBook.getBorrowed()) {
                    borrowed = "imprumutata";
                } else {
                    borrowed = "neimprumutata";
                }
                System.out.format("|%4d| %-23s| %-24s|%-6s| %-6s| %-15s| %-6s| %-11s|\n", borrowedBook.getId(),
                        borrowedBook.getTitle(), borrowedBook.getAuthors().get(0).getName(), borrowedBook.getYear(),
                        borrowedBook.getPrice(), borrowedBook.getPublisher().getName(), borrowedBook.getQuota(),
                        borrowed);
                for (int j = 1; j < borrowedBook.getAuthors().size(); j++) {
                    System.out.format("|%-4s| %-23s| %-24s|%-6s| %-6s| %-15s| %-6s| %-11s|\n", "", "", borrowedBook.getAuthors().get(j).getName(),
                            "", "", "", "", "");
                }
            }
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------");
    }                                  // show all books

    private void addPublisher() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];

            servicePublisher.addPublisher(id, name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            addPublisher();
        }
    }                             // add publisher
    private void updatePublisher() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];

            servicePublisher.updatePublisher(id, name);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            updatePublisher();
        }
    }                          // update publisher
    private void deletePublisher() {
        try {
            System.out.println("ID Editura: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            servicePublisher.deletePublisher(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            deletePublisher();
        }
    }                          // delete publisher
    private void showPublisher(){
        headPublisher();
        ArrayList<Publisher> publisherList = new ArrayList<Publisher>(servicePublisher.showPublisher());
        for (Publisher publisher : publisherList) {
            {
                System.out.format("|%4d| %-17s|\n", publisher.getId(), publisher.getName());
            }
        }
        System.out.println("-------------------------");
    }                             // show all publishers

    private void addAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];

            serviceAuthor.addAuthor(id, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            addAuthor();
        }
    }                                // add author
    private void updateAuthor() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];

            serviceAuthor.updateAuthors(id, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            updateAuthor();
        }
    }                             // update author
    private void deleteAuthor() {
        try {
            System.out.println("ID Author: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            serviceAuthor.deleteAuthor(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            deleteAuthor();
        }
    }                             // delete author
    private void showAuthor(){
        headAuthor();
        ArrayList<Author> authorList = new ArrayList<Author>(serviceAuthor.showAuthors());
        for (Author author : authorList) {
            {
                System.out.format("|%4d| %-20s|\n", author.getId(), author.getName());
            }
        }
        System.out.println("----------------------------");

    }                                // show all authors

    private void addPerson() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name,cnp,borrowed books(;),remaining books(;)");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String cnp = parts[2];
            String[] partsBorrowedBooks = parts[3].split(";");
            ArrayList<Book> borrowedBooks = new ArrayList<Book>();
            for (String partsBorrowedBook : partsBorrowedBooks) {
                Book b = new Book(partsBorrowedBook);
                borrowedBooks.add(b);
            }

            String[] partsRemainingBooks = parts[4].split(";");
            ArrayList<Book> remainingBooks = new ArrayList<Book>();
            for (String partsRemainingBook : partsRemainingBooks) {
                Book b = new Book(partsRemainingBook);
                remainingBooks.add(b);
            }

            servicePersons.addPerson(id, name, cnp, borrowedBooks, remainingBooks);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            addPerson();
        }
    }                                // add person
    private void updatePerson() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("FORMAT: id,name,cnp,borrowed books(;),remaining books(;)");
            String line = scanner.nextLine();
            String[] parts = line.split(",");

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            String cnp = parts[2];
            String[] partsBorrowedBooks = parts[3].split(";");
            ArrayList<Book> borrowedBooks = new ArrayList<Book>();
            for (String partsBorrowedBook : partsBorrowedBooks) {
                Book b = new Book(partsBorrowedBook);
                borrowedBooks.add(b);
            }

            String[] partsRemainingBooks = parts[4].split(";");
            ArrayList<Book> remainingBooks = new ArrayList<Book>();
            for (String partsRemainingBook : partsRemainingBooks) {
                Book b = new Book(partsRemainingBook);
                remainingBooks.add(b);
            }

            servicePersons.updatePerson(id, name, cnp, borrowedBooks, remainingBooks);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            updatePerson();
        }
    }                             // update person
    private void deletePerson() {
        try {
            System.out.println("Care persoana delete? ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();

            servicePersons.deletePerson(id);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            deletePerson();
        }
    }                             // delete person
    private void showPerson(){
        headPersons();
        ArrayList<Person> personList = new ArrayList<Person>(servicePersons.showPerson());
        for (Person person : personList) {
            {
                servicePersons.checkArrayRB();
                if (person.getBorrowedBooks().size() == 1 && person.getRemainingBooks().size() == 1)
                    System.out.format("|%4d| %-20s| %-15s|%-26s| %-26s|\n", person.getId(),
                            person.getName(), person.getCnp(), person.getBorrowedBooks().get(0).getTitle(),
                            person.getRemainingBooks().get(0).getTitle());
                else if (person.getBorrowedBooks().size() == 1 && person.getRemainingBooks().size() > 1) {
                    System.out.format("|%4d| %-20s| %-15s|%-26s| %-26s|\n", person.getId(),
                            person.getName(), person.getCnp(), person.getBorrowedBooks().get(0).getTitle(),
                            person.getRemainingBooks().get(0).getTitle());
                    for (int j = 1; j < person.getRemainingBooks().size(); j++) {
                        System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", "", person.getRemainingBooks().get(j).getTitle());
                    }
                } else if (person.getBorrowedBooks().size() > 1 && person.getRemainingBooks().size() == 1) {
                    System.out.format("|%4d| %-20s| %-15s|%-26s| %-26s|\n", person.getId(),
                            person.getName(), person.getCnp(), person.getBorrowedBooks().get(0).getTitle(),
                            person.getRemainingBooks().get(0).getTitle());
                    for (int j = 1; j < person.getBorrowedBooks().size(); j++) {
                        System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getBorrowedBooks().get(j).getTitle(), "");
                    }
                } else if (person.getBorrowedBooks().size() == 0 || person.getRemainingBooks().size() == 0) {
                    System.out.format("|%4d| %-20s| %-15s|%-26s| %-26s|\n", person.getId(),
                            person.getName(), person.getCnp(), person.getBorrowedBooks().get(0).getTitle(),
                            person.getRemainingBooks().get(0).getTitle());
                } else if (person.getBorrowedBooks().size() > 1 && person.getRemainingBooks().size() > 1) {
                    System.out.format("|%4d| %-20s| %-15s|%-26s| %-26s|\n", person.getId(),
                            person.getName(), person.getCnp(), person.getBorrowedBooks().get(0).getTitle(),
                            person.getRemainingBooks().get(0).getTitle());
                    if (person.getBorrowedBooks().size() > person.getRemainingBooks().size()) {
                        for (int j = 1; j < person.getRemainingBooks().size(); j++)
                            System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getBorrowedBooks().get(j).getTitle(), person.getRemainingBooks().get(j).getTitle());
                        for (int j = person.getRemainingBooks().size(); j < person.getBorrowedBooks().size(); j++)
                            System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getBorrowedBooks().get(j).getTitle(), "");
                    }
                    if (person.getBorrowedBooks().size() < person.getRemainingBooks().size()) {
                        for (int j = 1; j < person.getBorrowedBooks().size(); j++)
                            System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getBorrowedBooks().get(j).getTitle(), person.getRemainingBooks().get(j).getTitle());
                        for (int j = person.getBorrowedBooks().size(); j < person.getRemainingBooks().size(); j++)
                            System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getRemainingBooks().get(j).getTitle(), "");
                    }
                    if (person.getBorrowedBooks().size() == person.getRemainingBooks().size()) {
                        for (int j = 1; j < person.getRemainingBooks().size(); j++)
                            System.out.format("|%-4s| %-20s| %-15s|%-26s| %-26s|\n", "", "", "", person.getBorrowedBooks().get(j).getTitle(), person.getRemainingBooks().get(j).getTitle());
                    }
                }
            }
        }
        String linii="----------------------------------------------------------------------------------------------------";
        System.out.println(linii);
    }                                // show all persons

    private static void headBook() {
        String linii="----------------------------------------------------------------------------------------------------------------";
        System.out.println(linii);
        System.out.format("| %-3s|\t\t\t%-14s|\t\t\t%-16s| %-5s| %-6s|\t%-12s| %-6s|\t%-11s|\n","ID","Title","Authors","Year","Price","Publisher","Quota","Borrowed");
        System.out.println(linii);
    }                          // head table of books
    private static void headAuthor() {
        String linii="----------------------------";
        System.out.println(linii);
        System.out.format("| %-3s|\t\t%-15s|\n","ID","Name");
        System.out.println(linii);
    }                        // head table of authors
    private static void headPublisher() {
        String linii="-------------------------";
        System.out.println(linii);
        System.out.format("| %-3s|\t\t%-12s|\n","ID","Name");
        System.out.println(linii);
    }                     // head table of publishers
    private static void headPersons() {
        String linii="----------------------------------------------------------------------------------------------------";
        System.out.println(linii);
        System.out.format("| %-3s|\t\t%-15s|\t\t%-8s|\t\t%-19s|\t\t%-19s|\n","ID","Name","CNP","Borrowed Books","Remaining Books");
        System.out.println(linii);
    }                       // head table of persons

    public void borrow() throws Exception {
        System.out.println("PERSONS:");
        showPerson();
        System.out.println("BOOKS:");
        showBook();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Person: ");
        int idPersoana = scanner.nextInt();
        System.out.println("Book: ");
        int idCarte = scanner.nextInt();
        servicePersons.borrow(idPersoana,idCarte);
    }                   // borrow a book

    private void menuApp(){
        System.out.println("1.Books");
        System.out.println("2.Persons");
        System.out.println("3.Publishers");
        System.out.println("4.Authors");
        System.out.println("5.Borrow a book");
        System.out.println("6.EXIT");
    }                                   // menu of app
    private void menuCRUD(){
        System.out.println("1.Add");
        System.out.println("2.Update");
        System.out.println("3.Delete");
        System.out.println("4.Show");
        System.out.println("5.Exit");
    }                                  // menu of CRUDs

    public void runApp() throws Exception {
        menuApp();
        System.out.print("Option: ");
        Scanner scanner=new Scanner(System.in);
        int option=scanner.nextInt();
        while(option!=6){
            if(option==1)
            {
                menuCRUD();
                System.out.print("Option: ");
                int option1=scanner.nextInt();
                while(option1!=5)
                {
                    if(option1==1) addBook();
                    if(option1==2) updateBook();
                    if(option1==3) deleteBook();
                    if(option1==4) showBook();
                    menuCRUD();
                    System.out.println("Option: ");
                    option1=scanner.nextInt();
                }
            }
            if(option==2)
            {
                menuCRUD();
                System.out.println("Option: ");
                int option1=scanner.nextInt();
                while(option1!=5)
                {
                    if(option1==1) addPerson();
                    if(option1==2) updatePerson();
                    if(option1==3) deletePerson();
                    if(option1==4) showPerson();
                    menuCRUD();
                    System.out.print("Option: ");
                    option1=scanner.nextInt();
                }
            }
            if(option==3)
            {
                menuCRUD();
                System.out.println("Option: ");
                int option1=scanner.nextInt();
                while(option1!=5)
                {
                    if(option1==1) addPublisher();
                    if(option1==2) updatePublisher();
                    if(option1==3) deletePublisher();
                    if(option1==4) showPublisher();
                    menuCRUD();
                    System.out.print("Option: ");
                    option1=scanner.nextInt();
                }
            }
            if(option==4)
            {
                menuCRUD();
                System.out.println("Option: ");
                int option1=scanner.nextInt();
                while(option1!=5)
                {
                    if(option1==1) addAuthor();
                    if(option1==2) updateAuthor();
                    if(option1==3) deleteAuthor();
                    if(option1==4) showAuthor();
                    menuCRUD();
                    System.out.print("Option: ");
                    option1=scanner.nextInt();
                }
            }
            if(option==5)
            {
                borrow();
            }
            menuApp();
            System.out.print("Option: ");
            option=scanner.nextInt();
        }
        System.out.println("EXIT PROGRAM");
    }                   // run of app
}
