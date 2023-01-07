package service;

import com.google.common.hash.Hashing;
import entity.User;
import exception.BadValueException;
import exception.EntityNotFoundException;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import repository.Repository;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RequiredArgsConstructor
@Data
public class AuthenticationService {

    private final Repository<User> userRepository;
    private User currentUser;

    public void addUser(User user) throws BadValueException {
        String hash = Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString();
        user.setPassword(hash);
        List<User> users = userRepository.findAll();
        for (User dbUser : users) {
            if (dbUser.getUsername().equals(user.getUsername())) {
                throw new BadValueException("Username already exists!");
            }
        }
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
                currentUser = user;
                return user;
            }
        }
        throw new EntityNotFoundException("User does not exist");
    }

    public void logOut() {
        this.currentUser = null;
    }

}
