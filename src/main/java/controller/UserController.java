package controller;

import exception.EntityNotFoundException;
import service.AuthenticationService;

import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserController {
///

    private AuthenticationService authenticationService;

    public boolean logIn(String username, String password) throws EntityNotFoundException {
        authenticationService.logUserIn(username,password);

        return false;
    }

}