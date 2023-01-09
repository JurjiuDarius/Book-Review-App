package SiteBook;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import view.ViewMain;

public class Main {

    //    @PersistenceUnit(name="BookReviewApp")
//    private static EntityManagerFactory emf;
    public static void main(String[] args) {

//		User user = User.builder().username("admin").password("admin").authority(AuthorityEnum.ADMIN).build();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BookReviewApp");
//		Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");
//		AuthenticationService authenticationService = new AuthenticationService(userRepository);
//		User user2 = User.builder().username("critic").password("critic").authority(AuthorityEnum.CRITIC).build();
//		authenticationService.addUser(user);
//		authenticationService.addUser(user2);


//		Book book1=Book.builder().name("Crime and Punishment").build();
//		Book book2=Book.builder().name("Brothers Karamazov").build();
//		Author author1= Author.builder().name("Dostoiesvski2").books(new ArrayList<>()).build();
//		author1.getBooks().add(book1);
//		author1.getBooks().add(book2);
//		Repository<Book> bookRepository=new Repository<>(emf.createEntityManager(),"Book");
//		Repository<Author> authorRepository=new Repository<>(emf.createEntityManager(),"Author");
//		authorRepository.update(author1);
//        Repository<User> userRepository = new Repository<>(emf.createEntityManager(), "User");
//        Repository<Book> bookRepository = new Repository<>(emf.createEntityManager(), "Book");
//        Repository<Review> reviewRepository = new Repository<>(emf.createEntityManager(), "Review");
//        User critic = userRepository.findById(2).get();
//        Book book = bookRepository.findById(2452).get();
//        Review review = Review.builder().critic(critic).book(book).text("A great book also has a movie").build();
//        System.out.println(book.getReviews());

        ViewMain.mainView();


    }

}



