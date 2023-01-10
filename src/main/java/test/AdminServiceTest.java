package test;

import entity.*;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.AdminService;
import service.AuthenticationService;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminServiceTest {
    private AdminService adminService;

    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private Repository<Author> authorRepository;
    @Mock
    private Repository<BookStore> bookStoreRepository;
    @Mock
    private Repository<Book> bookRepository;
    @Mock
    private Repository<Editor> editorRepository;



    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        adminService = new AdminService(authenticationService, authorRepository, bookStoreRepository, bookRepository, editorRepository);

    }

    @Test
    void deleteUserByIdTest() {
        User user = User.builder().id(1).build();
        try {
            adminService.deleteUserById(1);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void addAuthorTest() {
        Author author = Author.builder().id(1).name("Stephen King").build();
        try {
            adminService.addAuthor(author);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    public void addBookToAuthorTest() {
        Author author = Author.builder().id(1).name("Stephen King").build();
        Book book = Book.builder().id(2).build();

        try {
            adminService.addBookForAuthor(author.getId(), book.getId());

        } catch (Exception e) {
            if (book.getId() == 0) {
                throw new NoSuchElementException();
            }

        }


    }

    @Test
    public void addBookToBookstoreTest() {
        Book book = Book.builder().id(2).build();
        BookStore bookStore = BookStore.builder().id(1).build();
        try {
            adminService.addBookToBookStore(bookStore.getId(), book.getId());

        } catch (Exception e) {
            if (book.getId() == 0) {
                throw new NoSuchElementException();
            }

        }


    }

    @Test
    public void addBookToEditor() {
        Editor editor = Editor.builder().id(4).build();
        Book book = Book.builder().id(2).build();
        try {
            adminService.addBookToEditor(editor.getId(), book.getId());

        } catch (Exception e) {
            if (book.getId() == 0) {
                throw new NoSuchElementException();
            }

        }
    }
}




