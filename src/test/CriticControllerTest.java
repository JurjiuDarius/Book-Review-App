package test;

import controller.CriticController;
import entity.Book;
import entity.BookStore;
import entity.Critic;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.CriticView;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CriticControllerTest {

    Repository<Critic> criticRepository = new Repository<Critic>();
    CriticView criticView = new CriticView();
    CriticController criticController;

    ArrayList<Book> booklist = new ArrayList<Book>();

    @BeforeAll
    private void setup() {
        criticController = new CriticController(criticRepository, criticView);
    }

    @Test
    void testAdd() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.addCritic(critic);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.addCritic(critic);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        Critic updateCritic = new Critic(1,"new name",1992,"",booklist);
        try {
            criticController.addCritic(critic);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.deleteCriticById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        Critic critic = new Critic(-2,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.deleteCriticById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        Critic critic = new Critic(1,"Ronaldo",1992,"Stanford",booklist);
        try {
            criticController.displayById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}



