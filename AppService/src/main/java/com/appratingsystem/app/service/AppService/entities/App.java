package com.appratingsystem.app.service.AppService.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "apps")
public class App {

    @Id
    @Column(name = "ID")
    private String appId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PUBLISHER")
    private String publisher;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VERSION")
    private String version;

    @Column(name = "RELEASE_DATE")
    private LocalDateTime releaseDate;


}
