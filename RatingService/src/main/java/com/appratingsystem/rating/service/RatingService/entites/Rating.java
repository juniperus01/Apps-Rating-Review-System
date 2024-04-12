package com.appratingsystem.rating.service.RatingService.entites;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ratings")
public class Rating {
    @Id
    private String ratingId;
    private String userId;
    private String appId;
    private String rating;
    private String feedback;
}
