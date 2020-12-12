package pl.sda.MovieRental.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.MovieRental.Utils.ReviewHandler;
import pl.sda.MovieRental.model.Review;
import pl.sda.MovieRental.service.ReviewService;

import java.net.URI;

@RestController
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/movie-list/{id}/review")
    public ResponseEntity<?> getReviewViewForMovie (@PathVariable("id") Long id){
        return reviewService.addReview(id);
    }

    @GetMapping("/review/{id}")
    public ResponseEntity<?> getReviewById (@PathVariable("id") Long id){
        return reviewService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity
                        .notFound()
                        .build());
    }

    @PutMapping("/review")
    public ResponseEntity<?> addReview (@RequestBody Review review){
        Review savedReview = reviewService.save(review);
        return ResponseEntity
                .created(URI.create("/"+savedReview.getId()))
                .body(savedReview);
    }
}
