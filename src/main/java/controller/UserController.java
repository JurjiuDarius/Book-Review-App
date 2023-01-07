package controller;

import entity.User;
import exception.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import service.AuthenticationService;

@RequiredArgsConstructor
@Data
public class UserController {
///

    private final AuthenticationService authenticationService;
    private User currentUser;

    public User logIn(String username, String password) throws EntityNotFoundException {
        currentUser = authenticationService.logUserIn(username, password);
        return currentUser;

    }

    public void logOut() {
        this.authenticationService.logOut();
    }

    public User getCurrentUser() {
        return authenticationService.getCurrentUser();
    }

}