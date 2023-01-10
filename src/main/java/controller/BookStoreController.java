package controller;

import entity.BookStore;
import exception.BadValueException;
import service.BookStoreService;
import view.BookStoreView;
import view.BookView;

public class BookStoreController {

    private final BookStoreService bookStoreService;
    private final BookStoreView bookStoreView;
    private final BookView bookView;

    public BookStoreController(BookStoreService bookStoreService, BookStoreView bookStoreView, BookView bookView) {
        this.bookStoreService = bookStoreService;
        this.bookStoreView = bookStoreView;
        this.bookView = bookView;
    }

    public BookStore addBookStore(BookStore bookStore) throws BadValueException {
        if (bookStore.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return bookStoreService.add(bookStore);
    }

    public BookStore updateBookStore(BookStore bookStore) throws BadValueException {
        if (bookStore.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return bookStoreService.update(bookStore);
    }

    public void deleteBookStoreById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        bookStoreService.deleteById(id);
    }

    public void displayAll() {

        bookStoreView.displayBookstore(bookStoreService.findAll());
    }

    public void displayById(int id) throws BadValueException {
        bookStoreView.displayBookStore(bookStoreService.findById(id));
    }

    public void displayBooksForStore(String name) throws BadValueException {
        bookView.displayBooks(bookStoreService.booksForBookStore(name));
    }



}
