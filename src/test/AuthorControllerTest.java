package test;

import controller.AuthorController;
import entity.Author;
import entity.Book;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.AuthorView;

import java.util.ArrayList;
import java.util.List;



@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorControllerTest {

    Repository<Author> authorRepository = new Repository<Author>();
    AuthorView authorView = new AuthorView();
    AuthorController authorController;

    ArrayList<Book> booklist = new ArrayList<>();


    @BeforeAll
    private void setup() {
        authorController = new AuthorController(authorRepository, authorView);
    }

    @Test
    void testAdd() {
        Object List;

        Author author = new Author(1,"Stephen King",1992,"Oxford",booklist);
        try {
            authorController.addAuthor(author);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        Author author = new Author(-2,"Stephen King",1950,"Oxford",booklist);
        try {
            authorController.addAuthor(author);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        Author author = new Author(1,"Stephen King",1950,"Oxford",booklist);
        Author updateAuthor = new Author(1,"Stephen King",1940,"Oxford",booklist);
        try {
            authorController.addAuthor(author);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        Author author = new Author(1,"Stephen King",1950,"Oxford",booklist);
        try {
            authorController.deleteAuthorById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        Author author = new Author(-2,"Stephen King",1950,"Oxford",booklist);
        try {
            authorController.deleteAuthorById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        Author author = new Author(1,"Stephen King",1950,"Oxford",booklist);
        try {
            authorController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        Author author = new Author(-2,"Stephen King",1950,"Oxford",booklist);
        try {
            authorController.displayById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}
