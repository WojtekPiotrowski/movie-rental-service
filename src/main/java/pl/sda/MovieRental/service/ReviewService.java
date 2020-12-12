package pl.sda.MovieRental.service;

import org.springframework.http.ResponseEntity;
import pl.sda.MovieRental.model.Review;

import java.util.Optional;

public interface ReviewService {
    Review save(Review review);

    Optional<Review> getById(Long id);

    ResponseEntity<?> addReview(Long id);
}
