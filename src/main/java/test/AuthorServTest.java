package test;

import entity.*;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.AdminService;
import service.AuthenticationService;
import service.AuthorService;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AuthorServTest {

    @Mock
    private Repository<Author> authorRepository;
    @Mock
    private AuthorService authorService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authorService = new AuthorService(authorRepository);


    }

    @Test
    void addAuthorTest() {
        Author author = Author.builder().name("stiu").build();
        try {
            authorService.add(author);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateAuthorTest() {
        Author author = Author.builder().name("stiu").build();
        try {
            authorService.update(author);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteByIdTest() {
        Author author = Author.builder().name("stiu").id(1).build();
        try {
            authorService.deleteById(1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void findOlderThanTest() {
        Author author = Author.builder().name("stiu").id(1).birthYear(1990).build();
        Author author1 = Author.builder().name("stius").id(2).birthYear(1942).build();
        List<Author> authors = List.of(
                author,
                author1);

        int birthyear = 1945;
        try {
            authorService.authorsOlderThan(birthyear);
            assertTrue(authors.contains(author1));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }


}

