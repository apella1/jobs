package me.apella.jobs.service;

import me.apella.jobs.model.Review;

import java.util.List;
import java.util.UUID;

public interface ReviewService {
    List<Review> findAll();

    void createReview(Review review);

    Review getReviewById(UUID id);

    boolean deleteReviewById(UUID id);

    boolean updateReviewById(UUID id, Review updatedReview);
}
