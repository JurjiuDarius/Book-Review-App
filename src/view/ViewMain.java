package view;
import java.util.Scanner;

import controller.BookController;
import entity.Book;
import view.BookView;

public class ViewMain {
    public static void main(String[] args) {
        BookView bookv = new BookView();
        AuthorView authv = new AuthorView();
        BookStoreView store = new BookStoreView();
        System.out.println("Options:");
        System.out.println("1:Display Books");
        System.out.println("2:Display Author");
        System.out.println("3:DisplayStores");
        System.out.println("4:Menu");
        System.out.println("5:Quit");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        do {
            switch (choice) {
                case "1":
                    bookv.displayBooks();
                    break;
                case "2":
                    authv.displayAuthors();
                    break;
                case "3":
                    store.displayBookstore();
                    break;
                case "4":
                    System.out.println("Options:");
                    System.out.println("1:Display Boooks");
                    System.out.println("2:Display Author");
                    System.out.println("3:DisplayStores");
                    System.out.println("4:Menu");
                    System.out.println("5:Quit");

            }
        } while (choice != "5");
    }
}


