package view;


import java.util.*;

import controller.*;
import exception.EntityNotFoundException;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaDelete;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.metamodel.Metamodel;
import service.AdminService;
import entity.*;
import repository.Repository;
import service.AuthenticationService;
import service.CriticService;
import enums.AuthorityEnum;

public class ViewMain {
    public static void main(String[] args) throws EntityNotFoundException {
        AuthorityEnum authorityEnum = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
        Repository<Book> bookRepository = new Repository<>(emf.createEntityManager(), "Book");
        Repository<Author> authorRepository = new Repository<>(emf.createEntityManager(), "Author");
        Repository<Review> reviewRepository = new Repository<>(emf.createEntityManager(), "Review");
        Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");
        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(authenticationService, authorRepository);
        CriticService criticService = new CriticService(bookRepository, reviewRepository, userRepository);
        UserController userController = new UserController(authenticationService);
        CriticController criticController = new CriticController(criticService);
        ;
        BookView bookView = new BookView();
        BookController bookController = new BookController(bookRepository, bookView);
        AdminController adminController = new AdminController(adminService);
        Scanner input = new Scanner(System.in);

        String username = input.nextLine();
        System.out.println("Username:");
        String password = input.nextLine();
        System.out.println("Password:");
        userController.logIn(username, password);
        {
            Scanner adminMenu = new Scanner(System.in);
            System.out.println("1. Add Author");
            System.out.println("2. Add Book for Author");
            System.out.println("3. Quit");
            Integer select = adminMenu.nextInt();
            do {
                switch (select) {
                    case 1:

                        Author a;
                        System.out.println("Author name:");
                        String name = adminMenu.nextLine();
                        System.out.println("Author education");
                        String educ = adminMenu.nextLine();
                        System.out.println("Author birthYear");
                        Integer birthYear = adminMenu.nextInt();
                        List<Book> bookList =new ArrayList<>();
                        //System.out.println("Author Books");
                        //String bookName = adminMenu.nextLine();
                        //System.out.println("Book description");
                        //String descript = adminMenu.nextLine();
                        //System.out.println("Book type");
                        //String type = adminMenu.nextLine();
                        //System.out.println("Publication year");
                        //Integer pubY = adminMenu.nextInt();
                        //System.out.println("Where can you find the book?");
                        //List<BookStore> bookStoreList = new List<BookStore>() {
                        a = new Author(name, educ, bookList, birthYear);
                        adminController.addAuthor(a);
                        break;
                    case 2:

                        Book b;
                        Author au;
                        Editor e;

                        System.out.println("Enter AuthorID");
                        Integer authorId = adminMenu.nextInt();
                        System.out.println("Book name");
                        String bookName = adminMenu.nextLine();
                        System.out.println("Description");
                        String descr = adminMenu.nextLine();
                        System.out.println("Book Type");
                        String type = adminMenu.nextLine();
                        System.out.println("Publication Year?");
                        Integer pubyear = adminMenu.nextInt();
                        au = new Author();
                        e = new Editor();
                        List<BookStore> bookStoreList = new ArrayList<>();
                        b = new Book(authorId, bookName, descr, type, bookStoreList, au, pubyear, e);
                        adminController.addBookForAuth(authorId, b);
                }


            } while (select != 3);
            adminMenu.close();
        }

        userController.logIn(UserN, UserP);
        {
            Scanner userMenu = new Scanner(System.in);
            int selection = userMenu.nextInt();
            System.out.println("1:Display Books");
            System.out.println("2: Add Review");
            System.out.println("3: Quit");
            do {
                switch (selection) {
                    case 1:
                        bookController.displayAll();
                        break;
                    case 2:
                        User critic = new User();
                        System.out.println("Book id");
                        Integer bookId = userMenu.nextInt();
                        System.out.println("Text");
                        String text = userMenu.nextLine();
                        criticController.addReview(critic, bookId, text);
                }


            } while (selection != 3);

        }


    }
}