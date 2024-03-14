package com.appratingsystem.user.service.UserService.entities;

import java.time.LocalDateTime;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class App {
    private String appId;
    private String name;
    private String publisher;
    private String description;
    private String version;
    private LocalDateTime releaseDate;
}
