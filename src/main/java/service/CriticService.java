package service;

import entity.Book;
import entity.Review;
import entity.User;
import enums.AuthorityEnum;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class CriticService {

    private Repository<Book> bookRepository;
    private Repository<Review> reviewRepository;
    private Repository<User> criticRepository;

    public User add(User critic) {
        return criticRepository.add(critic);
    }

    public User update(User critic) {
        return criticRepository.update(critic);
    }

    public void deleteById(Integer id) {
        criticRepository.deleteById(id);
    }

    public User findById(Integer id) {
        return criticRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Critic not found!"));
    }

    public List<User> findAll(Integer id) {
        return criticRepository.findAll().stream().filter(user -> user.getAuthority().equals(AuthorityEnum.CRITIC)).collect(Collectors.toList());
    }

    public void addReview(User critic, Integer bookId, String text) {
        Book book = bookRepository.findById(bookId).get();
        bookRepository.update(book);
        critic = criticRepository.findById(critic.getId()).get();
        Review review = Review.builder().critic(critic).text(text).book(book).publicationDate(new Date()).build();
        reviewRepository.add(review);

    }

}
