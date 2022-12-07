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

	private Repository<User> authorRepository;

	public void addUser(User author) {
		authorRepository.add(author);
	}

	public void updateUser(User author) {
		authorRepository.update(author);
	}

	public void deleteUser(Integer id) {
		authorRepository.deleteById(id);
	}

	public List<User> getAllUsers(Integer id) {
		return authorRepository.findAll();
	}

	public void addReview(User critic, Integer bookId, String text) {
		Book book = bookRepository.findById(bookId).get();
		Review review = Review.builder().critic(critic).text(text).book(book).build();
		reviewRepository.add(review);

	}

}
