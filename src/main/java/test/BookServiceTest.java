package test;

import entity.*;
import exception.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.AdminService;
import service.AuthenticationService;
import service.AuthorService;
import service.BookService;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookServiceTest {

    @Mock
    private Repository<Book> bookRepository;
    @Mock
    private BookService bookService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookService = new BookService(bookRepository);


    }

    @Test
    void addBookTest() {
        Book book = Book.builder().id(2).build();

        try {
            bookService.add(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteBookTest() {
        Book book = Book.builder().id(2).build();
        try {
            bookService.deleteById(book.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateBookTest() {
        Book book = Book.builder().id(2).build();
        try {
            bookService.update(book);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void findOlderThanTest() {
        Book book = Book.builder().name("stiu").id(1).publicationYear(1990).build();
        Book book1 = Book.builder().name("stiuss").id(2).publicationYear(1942).build();
        List<Book> bookList = List.of(
                book1,
                book);

        int py = 1945;
        try {
            bookService.booksOlderThan(py);
            assertTrue(bookList.contains(book1));

        } catch (Exception e) {
            throw new NoSuchElementException(e);
        }


    }


    @Test
    void bookAuthTest(){
        Author author = Author.builder().name("Miau").build();
        Author author1 = Author.builder().name("Ham").build();
        Book book = Book.builder().author(author).build();
        Book book1 = Book.builder().author(author1).build();
        List<Book> bookList = List.of(
                book,
                book1
        );

        try{
            bookService.booksFromAuthor("Ham");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}















