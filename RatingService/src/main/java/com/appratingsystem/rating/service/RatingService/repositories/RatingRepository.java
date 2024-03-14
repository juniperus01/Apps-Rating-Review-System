package com.appratingsystem.rating.service.RatingService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appratingsystem.rating.service.RatingService.entites.Rating;
import java.util.List;


public interface RatingRepository extends JpaRepository<Rating, String>{
    // custom finder methods
    List<Rating> findByUserId(String userId);
    List<Rating> findByAppId(String appId);
}
