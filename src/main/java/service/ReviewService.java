package service;

import entity.Review;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import repository.Repository;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class ReviewService {

    private Repository<Review> reviewRepository;

    public Review add(Review review) {
        return reviewRepository.add(review);
    }

    public Review update(Review review) {
        return reviewRepository.update(review);
    }

    public void deleteById(Integer id) {
        reviewRepository.deleteById(id);
    }

    public Review findById(Integer id) {
        return reviewRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Review not found!"));
    }

    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    public List<Review> reviewsOlderThan(int year) {
        return reviewRepository.findAll().stream().filter(el -> el.getPublicationDate().getYear() > year).collect(Collectors.toList());
    }

    public List<Review> reviewsContainingKeyword(String keyword) {
        return reviewRepository.findAll().stream().filter(el -> el.getText().contains(keyword)).collect(Collectors.toList());
    }
}
