package test;

import entity.Review;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import repository.Repository;
import service.ReviewService;

public class ReviewServiceTest {
    @Mock
    private Repository<Review> reviewRepository;
    @Mock
    private ReviewService reviewService;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        reviewService = new ReviewService(reviewRepository);


    }

    @Test

    void addReviewTest(){
        Review review = Review.builder().id(2).build();

        try {
            reviewService.add(review);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void deleteReviewTest(){
        Review review = Review.builder().id(2).build();
        try {
            reviewService.deleteById(review.getId());
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @Test
    void updateReviewTest(){
        Review review = Review.builder().id(2).build();
        try {
            reviewService.update(review);
        } catch (Exception e){
            throw new RuntimeException(e);
        }

    }
}
