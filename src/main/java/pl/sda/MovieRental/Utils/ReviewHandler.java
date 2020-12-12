package pl.sda.MovieRental.Utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.sda.MovieRental.model.Movie;
import pl.sda.MovieRental.service.ReviewService;

public class ReviewHandler {

    private final ReviewService reviewService;

    public ReviewHandler(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    public static ResponseEntity<?> beginReviewAuthorisation(Long id){
        if (!UserHandler.isUserLoggedIn()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("You must be logged in to post a review");
        }
        if (!UserHandler.userRentedMovie(id)) {
            return ResponseEntity
                    .status(HttpStatus.NOT_ACCEPTABLE)
                    .body("You must have rented the movie to post a review");
        }
        return ResponseEntity
                .ok(id);
    }

}
