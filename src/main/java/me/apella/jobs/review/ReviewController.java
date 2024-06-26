package me.apella.jobs.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Integer companyId) {
        List<Review> reviews = reviewService.getAllReviews(companyId);
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@PathVariable Integer companyId, @RequestBody Review review) {
        boolean created = reviewService.createReview(companyId, review);
        if (created) {
            return new ResponseEntity<>("Review created successfully!", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Company does not exists", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(
            @PathVariable Integer companyId,
            @PathVariable Integer reviewId
    ) {
        Review review = reviewService.getReviewById(companyId, reviewId);
        if (review == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(review, HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReviewById(
            @PathVariable Integer companyId,
            @PathVariable Integer reviewId,
            @RequestBody Review updatedReview
    ) {
        boolean updated = reviewService.updateReviewById(companyId, reviewId, updatedReview);
        if (updated) {
            return new ResponseEntity<>("Review updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReviewById(@PathVariable Integer companyId, @PathVariable Integer reviewId) {
        boolean deleted = reviewService.deleteReviewById(companyId, reviewId);
        if (deleted) {
            return new ResponseEntity<>("Review deleted successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review not found.", HttpStatus.NOT_FOUND);
    }
}
