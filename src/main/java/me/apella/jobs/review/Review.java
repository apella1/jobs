package me.apella.jobs.review;

import jakarta.persistence.*;
import me.apella.jobs.company.Company;

import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
    private Integer likes;
    private Integer dislikes;

    @ManyToOne()
    private Company company;

    public Review(UUID id, String description, Integer likes, Integer dislikes, Company company) {
        this.id = id;
        this.description = description;
        this.likes = likes;
        this.dislikes = dislikes;
        this.company = company;
    }

    public Review() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
