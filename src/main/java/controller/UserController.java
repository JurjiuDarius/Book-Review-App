package controller;

import entity.User;
import exception.BadValueException;
import exception.EntityNotFoundException;
import repository.Repository;
import service.AuthenticationService;
import view.UserView;

import java.util.Optional;
import lombok.AllArgsConstructor;
@AllArgsConstructor
public class UserController {


    private AuthenticationService authenticationService;

    public void logIn(String username, String password) throws EntityNotFoundException {
        authenticationService.logUserIn(username,password);

    }

}