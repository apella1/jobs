package me.apella.jobs.repository;

import me.apella.jobs.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ReviewRepository extends JpaRepository<Review, UUID> {
    List<Review> findByCompanyId(UUID companyId);
}
