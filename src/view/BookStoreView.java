package view;

import entity.Book;
import entity.BookStore;
import entity.Critic;

import java.util.List;

public class BookStoreView {

    public void displayBookStore(Book bookStore){
        System.out.println(bookStore);
    }
    public void displayBookstore(List<Critic> bookstores){
        for(Critic bookstore:bookstores){
            System.out.println(bookstore);
        }
    }

}

