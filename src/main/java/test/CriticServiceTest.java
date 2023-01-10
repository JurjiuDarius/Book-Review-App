package test;

import entity.Book;
import entity.Review;
import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.CriticService;

public class CriticServiceTest {
    @Mock
    private Repository<Book> bookRepositoryy;
    @Mock
    private CriticService criticService;
    @Mock
    private Repository<Review> reviewRepository;
    @Mock
    private Repository<User>  userRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        criticService = new CriticService(bookRepositoryy,reviewRepository,userRepository);


    }

    @Test

    void addCriticTest(){
        User critic = User.builder().id(2).build();

        try {
            criticService.add(critic);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteCriticTest(){
        User critic = User.builder().id(2).build();
        try {
            criticService.deleteById(critic.getId());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateCriticTest(){
        User critic = User.builder().id(2).build();
        try {
            criticService.update(critic);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
