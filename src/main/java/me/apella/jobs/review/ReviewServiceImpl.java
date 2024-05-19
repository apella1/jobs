package me.apella.jobs.review;

import me.apella.jobs.company.Company;
import me.apella.jobs.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    ReviewRepository reviewRepository;
    CompanyService companyService;

    public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> getAllReviews(Integer companyId) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            List<Review> reviews = reviewRepository.findByCompanyId(companyId);
            return reviews;
        }
        return new ArrayList<>();
    }

    @Override
    public boolean createReview(Integer companyId, Review review) {
        Company company = companyService.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    @Override
    public Review getReviewById(Integer companyId, Integer reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream().filter(review -> review.getId().equals(reviewId)).findFirst().orElse(null);
    }

    @Override
    public boolean deleteReviewById(Integer companyId, Integer reviewId) {
        if (companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
            reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public boolean updateReviewById(Integer companyId, Integer reviewId, Review updatedReview) {
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
