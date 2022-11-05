package test;

import controller.ReviewController;
import entity.Book;
import entity.Review;
import exception.BadValueException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import repository.Repository;
import view.ReviewView;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ReviewControllerTest {

    Repository<Review> reviewRepository = new Repository<Review>();
    ReviewView reviewView = new ReviewView();
    ReviewController reviewController;

    @BeforeAll
    private void setup() {
        reviewController = new ReviewController(reviewRepository, reviewView);
    }

    @Test
    void testAdd() {
        Review review = new Review("smecher",2020,1) ;
        try {
            reviewController.addReview(review);
        } catch (BadValueException e) {
            assert (false);
        }
    }



    @Test
    void testAddFail() {
        Review review = new Review("smecher",2020,1) ;
        try {
            reviewController.addReview(review);

        } catch (BadValueException e) {
            assert (e.getClass().equals(BadValueException.class));
        }
    }
    @Test
    void testUpdateFail() {
        Review review = new Review("smecher",2020,1) ;
        Review updateReview = new Review("new",2021,1);
        try {
            reviewController.addReview(review);

        } catch (BadValueException e) {
            assert (false);
        }
    }

    @Test
    void testDelete(){
        Review review = new Review("smecher",2020,1) ;
        try{
            reviewController.deleteReviewById(1);
        }catch (BadValueException e){
            assert(false);
        }
    }

    @Test
    void testDeleteFail(){
        Review review = new Review("smecher",2020,1);
        try{
            reviewController.deleteReviewById(-2);
        } catch (BadValueException e) {
            throw new RuntimeException(e);
        }
    }



    @Test
    void displayByIdTest() {
        Review review = new Review("smecher",2020,1) ;
        try {
            reviewController.displayById(1);
        } catch (BadValueException e) {
            assert (false);
        }
    }

   @Test
    void displayByIdTestFail(){
       Review review = new Review("smecher",2020,1) ;
       try{
           reviewController.displayById(-1);
       } catch (BadValueException e) {
           throw new RuntimeException(e);
       }
   }





}

