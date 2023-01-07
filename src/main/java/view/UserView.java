package view;

import entity.User;

import java.util.List;

public class UserView {

    public void displayUser(User user) {
        System.out.println(user);
    }

    public void displayUsers(List<User> users) {
        for (User user : users) {
            System.out.println(user);
        }
    }

}

