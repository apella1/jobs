package me.apella.jobs.review;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import me.apella.jobs.common.BaseEntity;
import me.apella.jobs.company.Company;

import java.util.UUID;

@Entity
@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {
    private UUID id;
    private String description;
    private Integer likes;
    private Integer dislikes;

    @ManyToOne()
    private Company company;
}
