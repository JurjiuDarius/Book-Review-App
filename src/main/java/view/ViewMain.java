package view;

import controller.*;
import entity.*;
import enums.AuthorityEnum;
import exception.BadValueException;
import exception.EntityNotFoundException;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.Repository;
import service.*;

import java.util.Scanner;

public class ViewMain {

    public static void mainView() {
        AuthorityEnum authorityEnum = null;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
        Repository<Author> authorRepository = new Repository<>(emf.createEntityManager(), "Author");
        Repository<Editor> editorRepository = new Repository<>(emf.createEntityManager(), "Editor");
        Repository<Book> bookRepository = new Repository<>(emf.createEntityManager(), "Book");
        Repository<Review> reviewRepository = new Repository<>(emf.createEntityManager(), "Review");
        Repository<BookStore> bookStoreRepository = new Repository<>(emf.createEntityManager(), "BookStore");
        Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");

        AuthenticationService authenticationService = new AuthenticationService(userRepository);
        AdminService adminService = new AdminService(authenticationService, authorRepository, bookStoreRepository, bookRepository, editorRepository);
        CriticService criticService = new CriticService(bookRepository, reviewRepository, userRepository);
        BookService bookService = new BookService(bookRepository);
        AuthorService authorService = new AuthorService(authorRepository);
        BookStoreService bookStoreService = new BookStoreService(bookStoreRepository);
        ReviewService reviewService = new ReviewService(reviewRepository);
        EditorService editorService = new EditorService(editorRepository);

        BookView bookView = new BookView();
        AuthorView authorView = new AuthorView();
        BookStoreView bookStoreView = new BookStoreView();
        EditorView editorView = new EditorView();
        ReviewView reviewView = new ReviewView();

        UserController userController = new UserController(authenticationService);
        CriticController criticController = new CriticController(criticService);
        AdminController adminController = new AdminController(adminService);
        BookController bookController = new BookController(bookService, bookView);
        AuthorController authorController = new AuthorController(authorService, authorView);
        BookStoreController bookStoreController = new BookStoreController(bookStoreService, bookStoreView, bookView);
        EditorController editorController = new EditorController(editorService, editorView, bookView);
        ReviewController reviewController = new ReviewController(reviewService, reviewView);
        Scanner input = new Scanner(System.in);

        int choose = 0;
        while (choose != 3) {
            System.out.println("1. Create account");
            System.out.println("2. Log in");
            System.out.println("3. Quit");
            choose = input.nextInt();
            input.nextLine();
            if (choose == 1) {
                createAccount(authenticationService);
            } else if (choose == 2) {

                System.out.println("Username:");
                String username = input.nextLine();
                System.out.println("Password:");
                String password = input.nextLine();
                try {
                    User user = userController.logIn(username, password);


                    switch (user.getAuthority()) {
                        case ADMIN: {
                            adminMenu(bookController, authorController, bookStoreController, criticController, editorController, reviewController, adminController, bookView, authorView, bookStoreView, editorView);

                            break;
                        }
                        case VIEWER: {
                            displayMenu(bookController, authorController, editorController, bookStoreController, reviewController);
                            break;
                        }

                        case CRITIC: {
                            criticMenu(userController, bookController, authorController, bookStoreController, criticController, editorController, reviewController, adminController, bookView);
                            break;
                        }
                        default: {
                            System.out.println("There is no user");
                        }
                    }
                } catch (EntityNotFoundException e) {
                    System.out.println("The user does not exist!");
                }
            }
        }
    }

    public static void adminMenu(BookController bookController, AuthorController authorController, BookStoreController
            bookStoreController, CriticController criticController, EditorController
                                         editorController, ReviewController reviewController, AdminController adminController, BookView bookView, AuthorView authorView,
                                 BookStoreView bookStoreView,
                                 EditorView editorView) {
        Scanner adminMenu = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println("1. Display menu");
            System.out.println("2. Add Book for Author");
            System.out.println("3. Add Book to Bookstore");
            System.out.println("4. Add Book to Editor");
            System.out.println("5. Delete User");
            System.out.println("6. Add Menu");
            System.out.println("7. Quit");
            System.out.println("Enter command: ");
            menu = adminMenu.nextInt();

            switch (menu) {
                case 1:
                    displayMenu(bookController, authorController, editorController, bookStoreController, reviewController);
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

                case 6:
                    addMenu(adminMenu, bookController, bookView, authorController, authorView, bookStoreView, editorView, bookStoreController, editorController);
                    break;
            }

        } while (menu != 7);

    }

    public static void displayMenu(BookController bookController, AuthorController authorController,
                                   EditorController editorController, BookStoreController bookStoreController,
                                   ReviewController reviewController) {
        int case1 = 0;
        Scanner displayMenu = new Scanner(System.in);
        while (case1 != 8) {
            System.out.println("1. Display Books");
            System.out.println("2. Display Authors");
            System.out.println("3. Display Bookstores");
            System.out.println("4. Display Editors");
            System.out.println("5. Display Reviews");
            System.out.println("6. Filtering");
            System.out.println("7. Sorting");
            System.out.println("8. Back");

            case1 = displayMenu.nextInt();
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
                    filterDisplays(bookController, authorController, editorController, bookStoreController, reviewController);
                    break;
                case 7:
                    sortedDisplays(bookController, authorController, editorController, bookStoreController, reviewController);
                    break;

            }

        }

    }

    public static void filterDisplays(BookController bookController, AuthorController authorController,
                                      EditorController editorController, BookStoreController bookStoreController,
                                      ReviewController reviewController) {

        int case1 = 0;
        int year = 0;
        String keyword;
        Scanner displayMenu = new Scanner(System.in);
        while (case1 != 8) {
            System.out.println("1. Display Books older than given year");
            System.out.println("2. Display Authors older than given year");
            System.out.println("3. Display books that contain a given keyword");
            System.out.println("4. Display review that contain a given keyword");
            System.out.println("5. Display Books from a certain author");
            System.out.println("6. Display Books from a certain store");
            System.out.println("7. Display Books from a certain editor");
            System.out.println("8. Back");
            case1 = displayMenu.nextInt();
            displayMenu.nextLine();
            switch (case1) {

                case 1:
                    System.out.println("Year: ");
                    year = displayMenu.nextInt();
                    bookController.booksOlderThan(year);
                    break;
                case 2:
                    System.out.println("Year: ");
                    year = displayMenu.nextInt();
                    authorController.authorsOlderThan(year);
                    break;
                case 3:
                    System.out.println("Keyword: ");
                    keyword = displayMenu.nextLine();
                    bookController.booksContainingKeyword(keyword);
                    break;
                case 4:
                    System.out.println("Keyword: ");
                    keyword = displayMenu.nextLine();
                    reviewController.reviewsContainingKeyword(keyword);
                    break;
                case 5:
                    System.out.println("Author name: ");
                    keyword = displayMenu.nextLine();
                    bookController.booksFromAuthor(keyword);
                    break;
                case 6:
                    System.out.println("Store name: ");
                    keyword = displayMenu.nextLine();
                    try {
                        bookStoreController.displayBooksForStore(keyword);
                    } catch (BadValueException e) {
                        System.out.println("Store does not exist");
                    }
                    break;
                case 7:
                    System.out.println("Editor name: ");
                    keyword = displayMenu.nextLine();
                    try {
                        editorController.displayBooksForEditor(keyword);
                    } catch (BadValueException e) {
                        System.out.println("Editor does not exist");
                    }
                    break;
            }
        }

    }

    public static void sortedDisplays(BookController bookController, AuthorController authorController,
                                      EditorController editorController, BookStoreController bookStoreController,
                                      ReviewController reviewController) {

        int case1 = 0;
        int year = 0;
        String keyword;
        Scanner displayMenu = new Scanner(System.in);
        while (case1 != 6) {
            System.out.println("1. Sort books by year");
            System.out.println("2. Sort books by title");
            System.out.println("3. Sort authors by year");
            System.out.println("4. Sort authors by name");
            System.out.println("5. Sort authors by number of books");
            System.out.println("6. Back");
            case1 = displayMenu.nextInt();
            displayMenu.nextLine();
            switch (case1) {

                case 1:
                    System.out.println("Year: ");
                    bookController.booksSortedByYear();
                    break;
                case 2:
                    System.out.println("Year: ");
                    bookController.booksSortedByName();
                    break;
                case 3:
                    System.out.println("Keyword: ");
                    keyword = displayMenu.nextLine();
                    bookController.booksContainingKeyword(keyword);
                    break;
                case 4:
                    System.out.println("Keyword: ");
                    keyword = displayMenu.nextLine();
                    reviewController.reviewsContainingKeyword(keyword);
                    break;
                case 5:
                    System.out.println("Author name: ");
                    keyword = displayMenu.nextLine();
                    bookController.booksFromAuthor(keyword);
                    break;
            }
        }

    }

    public static void addMenu(Scanner adminMenu, BookController bookController, BookView bookView, AuthorController authorController,
                               AuthorView authorView, BookStoreView bookStoreView, EditorView editorView,
                               BookStoreController bookStoreController, EditorController editorController
    ) {
        int case6 = 0;
        while (case6 != 6) {
            System.out.println("1. Add Book");
            System.out.println("2. Add Author");
            System.out.println("3. Add BookStore");
            System.out.println("4. Add Editor");
            System.out.println("6. Back");
            case6 = adminMenu.nextInt();
            switch (case6) {
                case 1:
                    try {
                        bookController.addBook(bookView.newBook());
                    } catch (BadValueException e) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    try {
                        authorController.addAuthor(authorView.addAuthor());
                    } catch (BadValueException e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    try {
                        bookStoreController.addBookStore(bookStoreView.newBookStore());
                    } catch (BadValueException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        editorController.addEditor(editorView.newEditor());
                    } catch (BadValueException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }


        }
    }

    public static void criticMenu(UserController userController, BookController bookController, AuthorController authorController, BookStoreController
            bookStoreController, CriticController criticController, EditorController
                                          editorController, ReviewController reviewController
            , AdminController adminController, BookView bookView) {

        Scanner criticMenu = new Scanner(System.in);

        int cm = 0;
        while (cm != 3) {
            System.out.println("1. Display menu");
            System.out.println("2. Add Review for Book");
            System.out.println("3. Quit");
            cm = criticMenu.nextInt();

            switch (cm) {
                case 1:
                    displayMenu(bookController, authorController, editorController, bookStoreController,
                            reviewController);

                case 2:
                    System.out.println("Enter book id: ");
                    int bookID = criticMenu.nextInt();
                    System.out.println("Enter Review text: ");
                    String rev = criticMenu.nextLine();
                    criticController.addReview(userController.getCurrentUser(), bookID, rev);
                    criticMenu.nextLine();
                    break;

            }
        }

    }

    public static void createAccount(AuthenticationService authenticationService) {
        Scanner input = new Scanner(System.in);
        User user;
        System.out.println("Enter username:");
        String username = input.nextLine();
        System.out.println("Enter password:");
        String password = input.nextLine();
        System.out.println("Enter Birth year: ");
        Integer birthYear = input.nextInt();
        input.nextLine();
        System.out.println("Enter wanted authority: ");
        String authority = input.nextLine();
        System.out.println("Authority is:" + authority);
        AuthorityEnum authorityEnum = AuthorityEnum.valueOf(authority);

        user = User.builder().username(username).password(password).birthYear(birthYear).authority(authorityEnum).build();
        try {
            authenticationService.addUser(user);
        } catch (BadValueException e) {
            System.out.println(e.getMessage());
        }
    }


}

