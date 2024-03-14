package com.appratingsystem.rating.service.RatingService.controllers;
import java.util.List;

import com.appratingsystem.rating.service.RatingService.entites.Rating;
import com.appratingsystem.rating.service.RatingService.services.RatingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    
    @Autowired
    private RatingService ratingService;

    // create rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    // get all
    @GetMapping
    public ResponseEntity<List<Rating>> getRatings(){
        return ResponseEntity.ok(ratingService.getRatings());
    }

    // get ratings by userId
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
    }

     // get ratings by appId
    @GetMapping("/apps/{appId}")
    public ResponseEntity<List<Rating>> getRatingByAppId( @PathVariable String appId){
        return ResponseEntity.ok(ratingService.getRatingByAppId(appId));
    }
}
