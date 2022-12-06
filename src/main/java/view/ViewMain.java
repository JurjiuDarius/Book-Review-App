package view;


import java.util.Scanner;

import controller.AuthorController;
import controller.BookController;
import controller.BookStoreController;
import entity.*;
import repository.Repository;
import controller.AdminController;
import controller.CriticController;
import controller.EditorController;
import controller.ReviewController;
import controller.StoreLocationController;
public class ViewMain {


    public static void main(String[] args) {

        Repository<Book> bookRepository = new Repository<>();
        BookView bookView = new BookView();
        BookController bookController= new BookController(bookRepository,bookView);
        Repository<Author> authorRepository = new Repository<>();
        AuthorView authorView = new AuthorView();
        AuthorController authorController = new AuthorController(authorRepository,authorView);
        Repository<BookStore> bookStoreRepository = new Repository<>();
        BookStoreView bookStoreView = new BookStoreView();
        BookStoreController bookStoreController = new BookStoreController(bookStoreRepository,bookStoreView);
        Repository<Admin> adminRepository = new Repository<>();
        AdminView adminView = new AdminView();
        AdminController adminController = new AdminController(adminRepository,adminView);
        Repository<Critic> criticRepository = new Repository<>();
        CriticView criticView = new CriticView();
        CriticController criticController = new CriticController(criticRepository,criticView);
        Repository<Editor> editorRepository = new Repository<>();
        EditorView editorView = new EditorView();
        EditorController editorController = new EditorController(editorRepository,editorView);
        Repository<Review> reviewRepository = new Repository<>();
        ReviewView reviewView = new ReviewView();
        ReviewController reviewController = new ReviewController(reviewRepository,reviewView);
        Repository<StoreLocation> storeLocationRepository = new Repository<>();
        StoreLocationView storeLocationView = new StoreLocationView();
        StoreLocationController storeLocationController = new StoreLocationController(storeLocationRepository,storeLocationView);



        System.out.println("Options:");
        System.out.println("1:Display Books");
        System.out.println("2:Display Authors");
        System.out.println("3:Display Stores");
        System.out.println("4.Display Adminss");
        System.out.println("5:Display Critics");
        System.out.println("6:Display Editors");
        System.out.println("7:Display Reviews");
        System.out.println("8:Display StoreLocations");
        System.out.println("9:Menu");
        System.out.println("10:Quit");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        do {
            switch (choice) {
                case "1":
                    bookController.displayAll();
                    break;
                case "2":
                    authorController.displayAll();
                    break;
                case "3":
                    bookStoreController.displayAll();
                    break;
                case "4":
                    adminController.displayAll();
                    break;
                case "5":
                    criticController.displayAll();
                    break;
                case "6":
                    editorController.displayAll();
                    break;
                case "7":
                    reviewController.displayAll();
                    break;
                case "8":
                    storeLocationController.displayAll();
                    break;
                case "9":
                    System.out.println("Options:");
                    System.out.println("1:Display Books");
                    System.out.println("2:Display Author");
                    System.out.println("3:Display Stores");
                    System.out.println("4.Display Admin");
                    System.out.println("5:Display Critics");
                    System.out.println("6:Display Editors");
                    System.out.println("7:Display Reviews");
                    System.out.println("8:Display StoreLocations");
                    System.out.println("9:Menu");
                    System.out.println("10:Quit");
                    break;
            }

        }while(choice != "10");

    }
}






