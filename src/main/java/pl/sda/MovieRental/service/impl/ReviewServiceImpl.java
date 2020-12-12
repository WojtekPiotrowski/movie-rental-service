package pl.sda.MovieRental.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.sda.MovieRental.Utils.ReviewHandler;
import pl.sda.MovieRental.model.Review;
import pl.sda.MovieRental.repository.ReviewRepository;
import pl.sda.MovieRental.service.ReviewService;

import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Optional<Review> getById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public ResponseEntity<?> addReview(Long id) {
        return ReviewHandler.beginReviewAuthorisation(id);
    }

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }
}
