package controller;

import entity.Review;
import exception.BadValueException;
import service.ReviewService;
import view.ReviewView;

public class ReviewController {

    //comm
    private final ReviewService reviewService;
    private final ReviewView reviewView;

    public ReviewController(ReviewService reviewService, ReviewView reviewView) {
        this.reviewService = reviewService;
        this.reviewView = reviewView;
    }

    public Review addReview(Review review) throws BadValueException {
        if (review.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return reviewService.add(review);
    }

    public Review updateReview(Review review) throws BadValueException {
        if (review.getId() < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return reviewService.update(review);
    }

    public void deleteReviewById(int id) throws BadValueException {
        if (id < 0) {
            throw new BadValueException("Ids are positive numbers");
        }
        reviewService.deleteById(id);
    }

    public void displayAll() {
        reviewView.displayReviews(reviewService.findAll());
    }

    public void displayById(int id) throws BadValueException {

        reviewView.displayReview(reviewService.findById(id));

    }

    public void reviewsOlderThan(int year) {
        reviewView.displayReviews(reviewService.reviewsOlderThan(year));
    }

    public void reviewsContainingKeyword(String keyword) {
        reviewView.displayReviews(reviewService.reviewsContainingKeyword(keyword));
    }

}
