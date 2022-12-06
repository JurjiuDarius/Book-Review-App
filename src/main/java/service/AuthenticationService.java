package service;

import entity.User;
import repository.Repository;

import java.util.List;

public class AuthenticationService {

	Repository<User> userRepository;
	User currentUser;
	List<String> privilegeList;

	public void logIn(String username, String password){

	}
	public void logOut(){

	}
}
