package test;

import controller.AdminController;
import entity.Admin;
import entity.Book;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.AdminView;

import java.util.ArrayList;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AdminControllerTest {

    Repository<Admin> adminRepository = new Repository<Admin>();
    AdminView adminView = new AdminView();
    AdminController adminController;

    ArrayList<Book> booklist = new ArrayList<Book>();
    Book list = new Book(1,"book1","romantic","ro","a1",2020);


    @BeforeAll
    private void setup() {
        adminController = new AdminController(adminRepository, adminView);
    }

    @Test
    void testAdd() {
        Object List;

        Admin admin = new Admin(1,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.addAdmin(admin);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testAddFail() {
        Admin admin = new Admin(-2,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.addAdmin(admin);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }

    @Test
    void testUpdateFail() {
        Admin admin = new Admin(1,"Stephen King",1950,"Oxford", booklist);
        Admin updateAdmin = new Admin(1,"Stephen King",1940,"Oxford", booklist);
        try {
            adminController.addAdmin(admin);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete() {
        Admin admin = new Admin(1,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.deleteAdminById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDeleteFail() {
        Admin admin = new Admin(-2,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.deleteAdminById(-2);

        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void displayByIdTest() {
        Admin admin = new Admin(1,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void displayByIdFail() {
        Admin admin = new Admin(-2,"Stephen King",1950,"Oxford", booklist);
        try {
            adminController.displayById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }
}



