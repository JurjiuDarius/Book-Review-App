package test;

import controller.BookStoreController;
import entity.BookStore;
import entity.StoreLocation;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.BookStoreView;

import java.util.ArrayList;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookStoreControllerTest {

    Repository<BookStore> bookStoreRepository = new Repository<BookStore>();
    BookStoreView bookStoreView = new BookStoreView();
    BookStoreController bookStoreController;
    ArrayList<StoreLocation> storeLocationslist = new ArrayList<StoreLocation>();

    @BeforeAll
    private void setup() {
        bookStoreController = new BookStoreController(bookStoreRepository, bookStoreView);
    }

    @Test
    void testAdd() {
        BookStore bookStore = new BookStore(1,2,storeLocationslist,2001);
        try {
            bookStoreController.addBookStore(bookStore);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        BookStore bookStore = new BookStore(-1,2,storeLocationslist,2001);
        try {
            bookStoreController.addBookStore(bookStore);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        BookStore bookStore = new BookStore(1,2,storeLocationslist,2001);
        BookStore bookStoreupdate = new BookStore(-1,2,storeLocationslist,2001);;
        try {
            bookStoreController.addBookStore(bookStore);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        BookStore bookStore = new BookStore(1,2,storeLocationslist,2001);
        try {
            bookStoreController.deleteBookStoreById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        BookStore bookStore = new BookStore(-2,2,storeLocationslist,2001);
        try {
            bookStoreController.deleteBookStoreById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        BookStore bookStore = new BookStore(1,2,storeLocationslist,2001);
        try {
            bookStoreController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        BookStore bookStore = new BookStore(-2,2,storeLocationslist,2001);
        try {
            bookStoreController.displayById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}


