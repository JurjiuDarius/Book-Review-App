package controller;

import entity.Review;
import exception.BadValueException;
import repository.Repository;
import view.ReviewView;

import java.util.Optional;
import java.util.stream.Collectors;

public class ReviewController {

    //comm
    private final Repository<Review> reviewRepository;
    private final ReviewView reviewView;

    public ReviewController(Repository<Review> repository, ReviewView reviewView) {
        this.reviewRepository = repository;
        this.reviewView = reviewView;
    }

    public Review addReview(Review review) throws BadValueException {
        if (review.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return reviewRepository.add(review);
    }

    public Review updateReview(Review review) throws BadValueException {
        if (review.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return reviewRepository.update(review);
    }

    public void deleteReviewById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        reviewRepository.deleteById(id);
    }

    public void displayAll() {
        reviewView.displayReviews(reviewRepository.findAll());
    }

    public void displayById(int id) throws BadValueException {
        Optional<Review> reviewOptional = reviewRepository.findById(id);
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        if (!reviewOptional.isEmpty()) {
            reviewView.displayReview(reviewOptional.get());
        }
    }

    public void reviewsOlderThan(int year) {
        reviewView.displayReviews(reviewRepository.findAll().stream().filter(el -> el.getPublicationDate().getYear() > year).collect(Collectors.toList()));
    }

    public void reviewsContainingKeyword(String keyword) {
        reviewView.displayReviews(reviewRepository.findAll().stream().filter(el -> el.getText().contains(keyword)).collect(Collectors.toList()));
    }

}
