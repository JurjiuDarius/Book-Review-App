package view;


import java.util.*;

import controller.*;
import exception.BadValueException;
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
    public static void main(String[] args) throws EntityNotFoundException, BadValueException {
        AuthorityEnum authorityEnum = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
        Repository<Author> authorRepository = new Repository<>(emf.createEntityManager(), "Author");
        Repository<Editor> editorRepository = new Repository<>(emf.createEntityManager(), "Editor");
        Repository<StoreLocation> storeLocationRepository = new Repository<>(emf.createEntityManager(), "StoreLocation");
        Repository<Book> bookRepository = new Repository<>(emf.createEntityManager(), "Book");
        Repository<Review> reviewRepository = new Repository<>(emf.createEntityManager(), "Review");
        Repository<BookStore> bookStoreRepository = new Repository<>(emf.createEntityManager(), "BookStore");
        Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");

        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(authenticationService, authorRepository, storeLocationRepository, bookStoreRepository, bookRepository, editorRepository);
        CriticService criticService = new CriticService(bookRepository, reviewRepository, userRepository);

        BookView bookView = new BookView();
        AuthorView authorView = new AuthorView();
        BookStoreView bookStoreView = new BookStoreView();
        EditorView editorView = new EditorView();
        ReviewView reviewView = new ReviewView();
        StoreLocationView storeLocationView = new StoreLocationView();

        UserController userController = new UserController(authenticationService);
        CriticController criticController = new CriticController(criticService);
        AdminController adminController = new AdminController(adminService);
        BookController bookController = new BookController(bookRepository, bookView);
        AuthorController authorController = new AuthorController(authorRepository,authorView);
        BookStoreController bookStoreController = new BookStoreController(bookStoreRepository,bookStoreView);
        EditorController editorController = new EditorController(editorRepository,editorView);
        ReviewController reviewController = new ReviewController(reviewRepository,reviewView);
        StoreLocationController storeLocationController = new StoreLocationController(storeLocationRepository,storeLocationView);



        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        System.out.println("Username:");
        String password = input.nextLine();
        System.out.println("Password:");
        User user = userController.logIn(username, password);

        switch (user.getAuthority()) {
            case ADMIN: {
                adminMenu(bookController, authorController, bookStoreController, criticController, editorController, reviewController, storeLocationController, adminController, bookView);


                break;
            }
            case VIEWER: {
                userMenu(bookController, authorController, bookStoreController, criticController, editorController, reviewController, storeLocationController, adminController, bookView);
                break;
            }

            case CRITIC:
                criticMenu(bookController,authorController,bookStoreController,criticController,editorController,reviewController,storeLocationController,adminController,bookView);
                break;
        }
    }


        public static void adminMenu (BookController bookController, AuthorController authorController, BookStoreController
        bookStoreController, CriticController criticController, EditorController
        editorController, ReviewController reviewController, StoreLocationController
        storeLocationController, AdminController adminController, BookView bookView){
            Scanner adminMenu = new Scanner(System.in);
            System.out.println("1. Display menu");
            System.out.println("2. Add Book for Author");
            System.out.println("3. Add Book to Bookstore");
            System.out.println("4. Add Book to editor");
            System.out.println("5. Delete User");
            System.out.println("6. Quit");
            int menu = 0;

            do {
                System.out.println("Enter command: ");
                menu = adminMenu.nextInt();

                switch (menu) {
                    case 1:
                        int case1;
                        System.out.println("1. Display Books");
                        System.out.print("2. Display Authors");
                        System.out.println("3. Display Bookstores");
                        System.out.println("4. Display Editors");
                        System.out.println("5. Display Reviews");
                        System.out.println("6. Display Store Locations");
                        System.out.println("7. Back");
                        case1 = adminMenu.nextInt();
                        switch (case1) {

                            case 1:
                                System.out.println("Books: ");
                                bookController.displayAll();
                                break;
                            case 2:
                                System.out.println("Authors: ");
                                authorController.displayAll();
                                break;
                            case 3:
                                System.out.println("Book Stores: ");
                                bookStoreController.displayAll();
                                break;
                            case 4:
                                System.out.println("Editors: ");
                                editorController.displayAll();
                                break;
                            case 5:
                                System.out.println("Reviews: ");
                                reviewController.displayAll();
                                break;
                            case 6:
                                System.out.println("Store Locations: ");
                                storeLocationController.displayAll();
                                break;
                            case 7:
                                System.out.println("1. Display menu");
                                System.out.println("2. Add Book for Author");
                                System.out.println("3. Add Book to Bookstore");
                                System.out.println("4. Add Book to editor");
                                System.out.println("5. Delete User");
                                break;
                        }
                        break;

                    case 2:
                        System.out.println("Author id for adding book: ");
                        Integer authID = adminMenu.nextInt();
                        System.out.println("Book id :");
                        Integer bookId = adminMenu.nextInt();
                        adminController.addBookForAuth(authID, bookId);
                        System.out.println("Added");
                        break;
                    case 3:
                        System.out.println("Book id: ");
                        Integer bookid = adminMenu.nextInt();
                        System.out.println("Book Store id: ");
                        Integer bookStoreId = adminMenu.nextInt();
                        adminController.addBookToBookstore(bookid, bookStoreId);
                        System.out.println("Added book to book store");
                        break;
                    case 4:
                        System.out.println("Book id: ");
                        Integer bookID = adminMenu.nextInt();
                        System.out.println("Editor id: ");
                        Integer editorId = adminMenu.nextInt();
                        adminController.addBookToEditor(bookID, editorId);
                        System.out.println("Added book to Editor");
                        break;

                    case 5:
                        System.out.println("User Id to delete");
                        Integer id = adminMenu.nextInt();
                        adminController.deleteUserByID(id);
                        break;
                }

            } while (menu != 6);

        }

        public static void userMenu (BookController bookController, AuthorController authorController, BookStoreController
        bookStoreController, CriticController criticController, EditorController
        editorController, ReviewController reviewController, StoreLocationController
        storeLocationController, AdminController adminController, BookView bookView) throws BadValueException {
            Scanner userMenu = new Scanner(System.in);
            System.out.println("1. Book options");
            System.out.println("2. Author options");
            System.out.println("3. Quit");
            int um;
            do {
                um = userMenu.nextInt();
                switch (um) {
                    case 1:
                        int case1;
                        System.out.println("1. Search book by id");
                        System.out.println("2. Display books");
                        System.out.println("3. Back");
                        case1 = userMenu.nextInt();
                        switch (case1) {
                            case 1:
                                System.out.println("Enter book id");
                                Integer bookid = userMenu.nextInt();
                                bookController.displayById(bookid);
                                break;
                            case 2:
                                System.out.println("Books: ");
                                bookController.displayAll();
                                break;
                            case 3:
                                System.out.println("1. Book options");
                                System.out.println("2. Author options");
                                System.out.println("3. Quit");
                                break;

                        }
                        break;
                    case 2:
                        int case2;
                        System.out.println("1. Search author by id");
                        System.out.println("2. Display Authors");
                        System.out.println("3. Back");
                        case2 = userMenu.nextInt();
                        switch (case2) {
                            case 1:
                                System.out.println("Enter author id");
                                int auid = userMenu.nextInt();
                                authorController.displayById(auid);
                                break;
                            case 2:
                                System.out.println("Authors:");
                                authorController.displayAll();
                                break;
                            case 3:
                                System.out.println("1. Book options");
                                System.out.println("2. Author options");
                                System.out.println("3. Quit");
                                break;
                        }
                        break;

                }
            } while (um != 3);

        }


        public static void criticMenu (BookController bookController, AuthorController authorController, BookStoreController
        bookStoreController, CriticController criticController, EditorController
        editorController, ReviewController reviewController, StoreLocationController
        storeLocationController, AdminController adminController, BookView bookView) throws BadValueException {

            Scanner criticMenu = new Scanner(System.in);
            System.out.println("1. Book options");
            System.out.println("2. Author options");
            System.out.println("3. Add Review for Book");
            System.out.println("4. Quit");
            int cm;
            do {
                cm = criticMenu.nextInt();

                switch (cm) {
                    case 1:
                        int case1;
                        System.out.println("1. Search book by id");
                        System.out.println("2. Display books");
                        System.out.println("3. Back");
                        case1 = criticMenu.nextInt();
                        switch (case1) {
                            case 1:
                                System.out.println("Enter book id");
                                Integer bookId = criticMenu.nextInt();
                                bookController.displayById(bookId);
                                break;
                            case 2:
                                System.out.println("Books: ");
                                bookController.displayAll();
                                break;
                            case 3:
                                System.out.println("1. Book options");
                                System.out.println("2. Author options");
                                System.out.println("3. Quit");
                                break;

                        }
                        break;
                    case 2:
                        int case2;
                        System.out.println("1. Search author by id");
                        System.out.println("2. Display Authors");
                        System.out.println("3. Back");
                        case2 = criticMenu.nextInt();
                        switch (case2) {
                            case 1:
                                System.out.println("Enter author id");
                                int authid = criticMenu.nextInt();
                                authorController.displayById(authid);
                                break;
                            case 2:
                                System.out.println("Authors:");
                                authorController.displayAll();
                                break;
                            case 3:
                                System.out.println("1. Book options");
                                System.out.println("2. Author options");
                                System.out.println("3. Add Review for Book");
                                System.out.println("4. Quit");
                                break;
                        }
                        break;

                    case 3:
                        User critic = new User();
                        System.out.println("Enter bookid: ");
                        int bookID = criticMenu.nextInt();
                        System.out.println("Enter Review: ");
                        String rev = criticMenu.nextLine();
                        criticController.addReview(critic, bookID, rev);
                        break;


                }
            } while (cm != 4);

        }
    }

