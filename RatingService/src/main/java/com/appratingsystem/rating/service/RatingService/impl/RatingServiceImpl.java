package com.appratingsystem.rating.service.RatingService.impl;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appratingsystem.rating.service.RatingService.entites.Rating;
import com.appratingsystem.rating.service.RatingService.repositories.RatingRepository;
import com.appratingsystem.rating.service.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{
    
    @Autowired
    private RatingRepository ratingRepository;
    
    @Override
    public Rating create(Rating rating){
        String ratingId = UUID.randomUUID().toString();
        rating.setRatingId(ratingId);
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getRatings(){
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId){
        return ratingRepository.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByAppId(String appId){
        return ratingRepository.findByAppId(appId);
    }
}
