package com.appratingsystem.user.service.UserService.impl;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appratingsystem.user.service.UserService.entities.App;
import com.appratingsystem.user.service.UserService.entities.Rating;
import com.appratingsystem.user.service.UserService.entities.User;
import com.appratingsystem.user.service.UserService.exceptions.ResourceNotFoundException;
import com.appratingsystem.user.service.UserService.repositories.UserRepository;
import com.appratingsystem.user.service.UserService.services.UserService;

@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public User saveUser(User user){
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    @Override
    public User getUser(String userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !!: " + userId));
        Rating[] ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" + userId, Rating[].class);
        
        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            ResponseEntity<App> forEntity = restTemplate.getForEntity("http://localhost:8082/apps/" + rating.getAppId(), App.class);
            App app = forEntity.getBody();
            rating.setApp(app);
            return rating;
        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        return user;
    }
}
