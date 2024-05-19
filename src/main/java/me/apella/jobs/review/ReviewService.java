package me.apella.jobs.review;

import java.util.List;

public interface ReviewService {
    List<Review> getAllReviews(Integer companyId);

    boolean createReview(Integer companyId, Review review);

    Review getReviewById(Integer companyId, Integer reviewId);

    boolean deleteReviewById(Integer companyID, Integer reviewId);

    boolean updateReviewById(Integer companyId, Integer reviewId, Review updatedReview);
}
