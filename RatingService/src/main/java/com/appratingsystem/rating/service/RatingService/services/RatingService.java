package com.appratingsystem.rating.service.RatingService.services;
import java.util.List;
import com.appratingsystem.rating.service.RatingService.entites.Rating;

public interface RatingService {
    // create rating
    Rating create(Rating rating);

    // get all ratings
    List<Rating> getRatings();

    // get all ratings by userId
    List<Rating> getRatingByUserId(String userId);
    
    // get all ratings by appId
    List<Rating> getRatingByAppId(String appId);
}