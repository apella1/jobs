package me.apella.jobs.service;

import me.apella.jobs.model.Company;
import me.apella.jobs.model.Review;
import me.apella.jobs.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(UUID companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            List<Review> reviews = reviewRepository.findByCompanyId(companyId);
            return reviews;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean createReview(UUID companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(UUID companyId, UUID reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteReviewById(UUID companyId, UUID reviewId) {
        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(UUID companyId, UUID reviewId, Review updatedReview) {
        if (companyService.getCompanyById(companyId) != null) {
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
        return false;
    }
}
