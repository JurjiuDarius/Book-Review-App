package controller;

import entity.Book;
import exception.BadValueException;
import repository.Repository;
import view.BookView;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookController {

    private final Repository<Book> bookRepository;
    private final BookView bookView;

    public BookController(Repository<Book> repository, BookView bookView) {
        this.bookRepository = repository;
        this.bookView = bookView;
    }

    public Book addBook(Book book) throws BadValueException {
        if (book.id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return bookRepository.add(book);
    }

    public Book updateBook(Book book) throws BadValueException {
        if (book.id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return bookRepository.update(book);
    }

    public void deleteBookById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        bookRepository.deleteById(id);
    }

    public void displayAll() {

        bookView.displayBooks(bookRepository.findAll());
    }

    public void displayById(int id) throws BadValueException {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        if (!bookOptional.isEmpty()) {
            bookView.displayBook(bookOptional.get());
        }
    }

    public void createBook() {
        Book book = bookView.newBook();
        bookRepository.add(book);
    }

    public void booksOlderThan(int year) {
        bookView.displayBooks(bookRepository.findAll().stream().filter(el -> el.getPublicationYear() > year).collect(Collectors.toList()));
    }

    public void booksContainingKeyword(String keyword) {
        bookView.displayBooks(bookRepository.findAll().stream().filter(el -> el.getName().contains(keyword)).collect(Collectors.toList()));
    }

    public void booksFromAuthor(String authorName) {
        bookView.displayBooks(bookRepository.findAll().stream().filter(el -> el.getAuthor().getName().equals(authorName)).collect(Collectors.toList()));
    }

    public void booksSortedByYear() {
        bookView.displayBooks(bookRepository.findAll().stream().sorted(Comparator.comparingInt(Book::getPublicationYear)).collect(Collectors.toList()));
    }

    public void booksSortedByName() {
        bookView.displayBooks(bookRepository.findAll().stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList()));
    }
}
