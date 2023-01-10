package test;

import entity.BookStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.BookStoreService;

public class BookStoreServiceTest {
    @Mock
    private Repository<BookStore> bookStoreRepository;
    @Mock
    private BookStoreService bookStoreService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        bookStoreService = new BookStoreService(bookStoreRepository);


    }

    @Test

    void addBookStoreTest(){
        BookStore bookStore = BookStore.builder().id(2).build();

        try {
            bookStoreService.add(bookStore);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteBookStoreTest(){
        BookStore bookStore = BookStore.builder().id(2).build();
        try {
            bookStoreService.deleteById(bookStore.getId());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateBookStoreTest(){
        BookStore bookStore = BookStore.builder().id(2).build();
        try {
            bookStoreService.update(bookStore);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
