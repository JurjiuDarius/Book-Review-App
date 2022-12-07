package service;

import com.google.common.hash.Hashing;
import entity.User;
import exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.nio.charset.StandardCharsets;
import java.util.List;

@AllArgsConstructor
public class AuthenticationService {

	private Repository<User> userRepository;

	public void addUser(User user) {
		userRepository.add(user);
	}

	public void updateUser(User user) {
		userRepository.update(user);
	}

	public void deleteUser(Integer id) {
		userRepository.deleteById(id);
	}

	public List<User> getAllUsers(Integer id) {
		return userRepository.findAll();
	}

	public User logUserIn(String username, String password) throws EntityNotFoundException {
		List<User> users = userRepository.findAll();
		String hash = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(hash)) {
				return user;
			}
		}
		throw new EntityNotFoundException("User does not exist");
	}

}
