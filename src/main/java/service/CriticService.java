package service;

import entity.Book;
import entity.Review;
import entity.User;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;

@AllArgsConstructor
public class CriticService {

	private Repository<Book> bookRepository;
	private Repository<Review> reviewRepository;
	private Repository<User> criticRepository;

	public void addUser(User critic) {
		criticRepository.add(critic);
	}

	public void updateUser(User critic) {
		criticRepository.update(critic);
	}

	public void deleteUser(Integer id) {
		criticRepository.deleteById(id);
	}

	public List<User> getAllUsers(Integer id) {
		return criticRepository.findAll();
	}

	public void addReview(User critic, Integer bookId, String text) {
		Book book = bookRepository.findById(bookId).get();
		bookRepository.update(book);
		critic = criticRepository.findById(critic.getId()).get();
		Review review = Review.builder().critic(critic).text(text).book(book).build();
		reviewRepository.add(review);

	}

}
