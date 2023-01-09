package controller;

import entity.Book;
import exception.BadValueException;
import service.BookService;
import view.BookView;

public class BookController {

    private final BookService bookService;
    private final BookView bookView;

    public BookController(BookService bookService, BookView bookView) {
        this.bookService = bookService;
        this.bookView = bookView;
    }

    public Book addBook(Book book) throws BadValueException {
        if (book.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return bookService.add(book);
    }

    public Book updateBook(Book book) throws BadValueException {
        if (book.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return bookService.update(book);
    }

    public void deleteBookById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        bookService.deleteById(id);
    }

    public void displayAll() {

        bookView.displayBooks(bookService.findAll());
    }

    public void displayById(int id) throws BadValueException {

        bookView.displayBook(bookService.findById(id));
    }

    public void createBook() {
        Book book = bookView.newBook();
        bookService.add(book);
    }

    public void booksOlderThan(int year) {
        bookView.displayBooks(bookService.booksOlderThan(year));
    }

    public void booksContainingKeyword(String keyword) {
        bookView.displayBooks(bookService.booksContainingKeyword(keyword));
    }

    public void booksFromAuthor(String authorName) {
        bookView.displayBooks(bookService.booksFromAuthor(authorName));
    }

    public void booksSortedByYear() {
        bookView.displayBooks(bookService.booksSortedByYear());
    }

    public void booksSortedByName() {
        bookView.displayBooks(bookService.booksSortedByName());
    }
}
