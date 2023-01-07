package service;

import entity.Book;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class BookService {

    private Repository<Book> bookRepository;

    public void addBook(Book book) {
        bookRepository.add(book);
    }

    public void updateBook(Book book) {
        bookRepository.update(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public List<Book> getAllBooks(Integer id) {
        return bookRepository.findAll();
    }

}
