package controller;

import entity.User;
import exception.EntityNotFoundException;
import service.AuthenticationService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserController {
///

    private AuthenticationService authenticationService;

    public User logIn(String username, String password) throws EntityNotFoundException {
        authenticationService.logUserIn(username,password);
        return authenticationService.logUserIn(username,password);

    }

}