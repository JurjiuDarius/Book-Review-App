package SiteBook;

import entity.User;
import enums.AuthorityEnum;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import repository.Repository;
import service.AuthenticationService;

public class Main {

	//    @PersistenceUnit(name="BookReviewApp")
//    private static EntityManagerFactory emf;
	public static void main(String[] args) {

		User user = User.builder().username("admin").password("password").authority(AuthorityEnum.ADMIN).build();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
		Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");
		AuthenticationService authenticationService = new AuthenticationService(userRepository);
		User user2 = User.builder().username("critic").password("critic").authority(AuthorityEnum.CRITIC).build();
		//authenticationService.addUser(user);
		//authenticationService.addUser(user2);

	}

}



