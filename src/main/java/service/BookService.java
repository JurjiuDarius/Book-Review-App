package service;

import entity.Book;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookService {

    private Repository<Book> bookRepository;

    public Book add(Book book) {
        return bookRepository.add(book);
    }

    public Book update(Book book) {
        return bookRepository.update(book);
    }

    public void deleteById(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book findById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found!"));
    }

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public List<Book> booksOlderThan(int year) {
        return bookRepository.findAll().stream().filter(el -> el.getPublicationYear() > year).collect(Collectors.toList());
    }

    public List<Book> booksContainingKeyword(String keyword) {
        return bookRepository.findAll().stream().filter(el -> el.getName().contains(keyword)).collect(Collectors.toList());
    }

    public List<Book> booksFromAuthor(String authorName) {
        return bookRepository.findAll().stream().filter(el -> el.getAuthor().getName().equals(authorName)).collect(Collectors.toList());
    }

    public List<Book> booksSortedByYear() {
        return bookRepository.findAll().stream().sorted(Comparator.comparingInt(Book::getPublicationYear)).collect(Collectors.toList());
    }

    public List<Book> booksSortedByName() {
        return bookRepository.findAll().stream().sorted(Comparator.comparing(Book::getName)).collect(Collectors.toList());
    }

}
