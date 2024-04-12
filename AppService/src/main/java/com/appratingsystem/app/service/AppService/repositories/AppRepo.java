package com.appratingsystem.app.service.AppService.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appratingsystem.app.service.AppService.entities.App;

public interface AppRepo extends JpaRepository<App, String>{
    @Query("SELECT a FROM App a WHERE a.name = :appName")
    Optional<App> findByName(@Param("appName") String appName);
}
