package controller;
import entity.Book;
import exception.BadValueException;
import repository.Repository;
import entity.Review;
import view.ReviewView;

import java.util.Optional;

public class ReviewController {
    private Repository<Review> reviewRepository;
    private ReviewView reviewView;

    public ReviewController(Repository<Review> repository, ReviewView reviewView) {
        this.reviewRepository=repository;
        this.reviewView=reviewView;
    }
    public Review addReview(Review review) throws BadValueException{
        if(review.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }

        return reviewRepository.add(review);
    }
    public Review updateReview(Review review) throws BadValueException{
        if(review.getId()<0) {
            throw new BadValueException("Ids are positive numbers");
        }
        return reviewRepository.update(review);
    }
    public void deleteReviewById(int id) throws BadValueException {
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        reviewRepository.deleteById(id);
    }
    public void displayAll(){
        reviewView.displayReview((Review) reviewRepository.findAll());

    }
    public void displayById(int id) throws BadValueException {
        Optional<Review> reviewOptional=reviewRepository.findById(id);
        if(id<0){
            throw new BadValueException("Ids are positive numbers");
        }
        if(!reviewOptional.isEmpty()) {
            reviewView.displayReview(reviewOptional.get());
        }
    }


}
