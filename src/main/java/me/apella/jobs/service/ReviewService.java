package me.apella.jobs.service;

import me.apella.jobs.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<Review> getAllReviews(UUID companyId);

    boolean createReview(UUID companyId, Review review);

    Review getReviewById(UUID companyId, UUID reviewId);

    boolean deleteReviewById(UUID companyID, UUID reviewId);

    boolean updateReviewById(UUID companyId, UUID reviewId, Review updatedReview);
}
