package com.appratingsystem.user.service.UserService.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {
    private String ratingId;
    private String userId;
    private String appId;
    private String rating;
    private String feedback;
    private App app;
}
