package test;

import entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.AdminService;
import service.AuthenticationService;

public class AuthentServTest {

    @Mock
    private AuthenticationService authenticationService;
    @Mock
    private Repository<User> userRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        authenticationService = new AuthenticationService(userRepository);


    }

    @Test
    void updateUserTest() {
        User user = User.builder().id(1).build();
        try {
            authenticationService.updateUser(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    @Test
    void deleteUserTest() {
        User user = User.builder().id(1).build();
        try {
            authenticationService.deleteUser(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void getAllUserTest() {
        User user = User.builder().id(1).build();
        try {
            authenticationService.getAllUsers(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
