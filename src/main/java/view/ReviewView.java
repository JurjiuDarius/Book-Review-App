package view;

import entity.Review;

import java.util.List;

public class ReviewView {

    public void displayReview(Review review) {
        System.out.println(review);
    }

    public void displayReviews(List<Review> reviews) {
        for (Review review : reviews) {
            System.out.println(review);
        }
    }

}
