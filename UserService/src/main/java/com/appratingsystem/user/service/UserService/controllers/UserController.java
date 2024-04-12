package com.appratingsystem.user.service.UserService.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.appratingsystem.user.service.UserService.entities.App;
import com.appratingsystem.user.service.UserService.entities.Rating;
import com.appratingsystem.user.service.UserService.entities.User;
import com.appratingsystem.user.service.UserService.services.UserService;

import org.springframework.web.bind.annotation.*;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    //create

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute("user") User user,
                            @RequestParam(value = "appname") String appname,
                            @RequestParam(value = "feedback") String feedback,
                            @RequestParam(value = "rating") String rate
    ){
        User user1 = userService.saveUser(user);
        
        // Assuming Rating service endpoint URL
        String ratingServiceUrl = "http://ratingservice/ratings";
        String appServiceUrl = "http://appservice/apps/name/" + appname;

        // Make an HTTP GET request to the App service
        ResponseEntity<App> appResponseEntity = restTemplate.exchange(
            appServiceUrl,
            HttpMethod.GET,
            null,
            App.class);

        // Get the response body from app service
        @SuppressWarnings("null")
        String appIdResponse = appResponseEntity.getBody().getAppId();
        
        // Create a request body containing the appname, feedback, and rating
        Rating requestBody = new Rating();
        requestBody.setRating(rate);
        requestBody.setFeedback(feedback);
        requestBody.setUserId(user1.getUserId());
        requestBody.setAppId(appIdResponse);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Create the HTTP request entity
        HttpEntity<Rating> requestEntity = new HttpEntity<>(requestBody, headers);

        // Make an HTTP POST request to the Rating service
        restTemplate.exchange(
                ratingServiceUrl,
                HttpMethod.POST,
                requestEntity,
                String.class);

        return "giveReview";

    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getSingleUser( @PathVariable String userId){
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/getusers")
    public ResponseEntity<List<User>> getAllUser(){
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

    @GetMapping()
    public String giveReview (Model model){
        model.addAttribute("message", "Give Review");
        model.addAttribute("user", new User());
        return "giveReview";
    }

    @GetMapping("/askUserDetails")
    public String askUserDetails (Model model){
        return "askUserDetails";
    }

    @GetMapping("/getAllReviews")
    public String getAllReviews(Model model, @RequestParam("userName") String userName,
                                @RequestParam("email") String email) {
        User user = userService.getUserByEmail(email);
        model.addAttribute("user", user);
        return "viewAllReview";
    }


}
