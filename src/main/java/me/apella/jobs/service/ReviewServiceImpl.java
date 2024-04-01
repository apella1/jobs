package me.apella.jobs.service;

import me.apella.jobs.model.Review;
import me.apella.jobs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getAllReviews(UUID companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public void createReview(UUID companyId, Review review) {
        reviewRepository.save(review);
    }

    @Override
    public Review getReviewById(UUID companyId, UUID reviewId) {
        return reviewRepository.findById(reviewId).orElse(null);
    }

    @Override
    public boolean deleteReviewById(UUID companyId, UUID reviewId) {
        if (reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(UUID companyId, UUID reviewId, Review updatedReview) {
        Optional<Review> optionalReview = reviewRepository.findById(reviewId);
        if (optionalReview.isPresent()) {
            Review review = optionalReview.get();
            review.setDescription(updatedReview.getDescription());
            review.setDislikes(updatedReview.getDislikes());
            review.setLikes(updatedReview.getLikes());
            reviewRepository.save(review);
            return true;
        }
        return false;
    }
}
